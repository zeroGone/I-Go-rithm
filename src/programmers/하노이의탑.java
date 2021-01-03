package programmers;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {
    private final List<int[]> moves = new ArrayList<>();

    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);

        int[][] answer = new int[moves.size()][2];
        for (int index = 0; index < moves.size(); index += 1) {
            answer[index][0] = moves.get(index)[0];
            answer[index][1] = moves.get(index)[1];
        }
        return answer;
    }

    private void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            moves.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, to, by);
            moves.add(new int[]{from, to});
            hanoi(n - 1, by, from, to);
        }
    }
}