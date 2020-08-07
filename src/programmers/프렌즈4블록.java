package programmers;

import java.util.Arrays;

public class 프렌즈4블록 {
    public static void main(String[] args) {
        System.out.println(new 프렌즈4블록().solution(6, 6, new String[]{
                "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
        }));
    }

    public int solution(int m, int n, String[] board) {

        char[][] chars = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            chars[i] = board[i].toCharArray();
        }

        int answer = 0;
        boolean check = true;
        while (check) {
            boolean[][] blockForBreak = new boolean[chars.length][chars[0].length];

            boolean b = false;
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i].length; j++) {
                    if (chars[i][j] == ' ') continue;

                    char now = chars[i][j];
                    boolean c = false;
                    if (i + 1 < chars.length && j + 1 < chars[i].length) {
                        char right = chars[i][j + 1];
                        char down = chars[i + 1][j];
                        char diagonal = chars[i + 1][j + 1];

                        if (now == right && now == down && now == diagonal) {
                            c = true;
                        }
                    }

                    if (c) {
                        blockForBreak[i][j] = true;
                        blockForBreak[i][j + 1] = true;
                        blockForBreak[i + 1][j] = true;
                        blockForBreak[i + 1][j + 1] = true;
                        b = true;
                    }
                }
            }

            if(b) {
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < chars[i].length; j++) {
                        if (blockForBreak[i][j]) {

                            for(int z = i; z>0; z--){
                                chars[z][j] = chars[z-1][j];
                            }
                            chars[0][j] = ' ';
                            answer++;
                        }
                    }
                }

            }else{
                check = false;
            }
        }
        return answer;
    }
}
