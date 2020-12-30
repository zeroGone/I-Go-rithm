package programmers;

import java.util.ArrayList;
import java.util.List;

public class 이중우선순위큐 {
    private static final String INSERT = "I";
    private static final int MAX_OPERATION = 1;

    private List<Integer> queue = new ArrayList<>();

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] splited = operation.split(" ");

            int number = Integer.parseInt(splited[1]);

            if (splited[0].equals(INSERT)) {
                insert(number);
                continue;
            }

            if (queue.isEmpty()) {
                continue;
            }

            if (number == MAX_OPERATION) {
                queue.remove(0);
            } else {
                queue.remove(queue.size() - 1);
            }
        }

        if (queue.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{queue.get(0), queue.get(queue.size() - 1)};
        }
    }

    private void insert(int value) {
        for (int index = 0; index < queue.size(); index += 1) {
            if (queue.get(index) < value) {
                queue.add(index, value);
                return;
            }
        }
        queue.add(value);
    }
}