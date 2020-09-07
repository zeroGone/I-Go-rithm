package baekjoon;

import java.util.*;

public class 세로읽기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<LinkedList<Character>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String input = scanner.next();
            LinkedList<Character> q = new LinkedList<>();
            for (int j = 0; j < input.length(); j++) q.add(input.charAt(j));
            list.add(q);
        }

        StringBuilder builder = new StringBuilder();

        while (true) {
            boolean check = true;
            for (LinkedList<Character> temp : list) {
                if (temp.isEmpty()) continue;
                builder.append(temp.poll());
                check = false;
            }
            if(check) break;
        }

        System.out.print(builder.toString());
    }
}
