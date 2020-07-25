package programmers;

import java.util.Arrays;

public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        System.out.println(new 가장큰정사각형찾기().solution(new int[][]{
                {0, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 0, 1, 0}
        }));
    }

    public int solution(int[][] board) {

        int answer = 0;
        if (board[0][0] == 1 || board[1][0] == 1 || board[0][1] == 1) answer = 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1])) + 1;
                    if (answer < board[i][j]) answer = board[i][j];
                }
            }
        }

        return answer * answer;
    }
}
