package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 나이트의이동 {
    private static int[][] nightMoves = new int[][]{
            new int[]{-1, -2},
            new int[]{-2, -1},
            new int[]{-2, 1},
            new int[]{-1, 2},
            new int[]{2, 1},
            new int[]{1, 2},
            new int[]{2, -1},
            new int[]{1, -2}
    };

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();

            int testcase = Integer.parseInt(reader.readLine());

            for (int caseNumber = 1; caseNumber <= testcase; caseNumber += 1) {
                int l = Integer.parseInt(reader.readLine());

                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                int nightY = Integer.parseInt(stringTokenizer.nextToken());
                int nightX = Integer.parseInt(stringTokenizer.nextToken());

                stringTokenizer = new StringTokenizer(reader.readLine());
                int targetY = Integer.parseInt(stringTokenizer.nextToken());
                int targetX = Integer.parseInt(stringTokenizer.nextToken());

                boolean[][] visit = new boolean[l][l];

                List<int[]> nextMoves = new ArrayList<>();
                nextMoves.add(new int[]{nightY, nightX});
                visit[nightY][nightX] = true;

                int moveNumber = 0;

                loop:
                while (!nextMoves.isEmpty()) {
                    List<int[]> nowMoves = new ArrayList<>(nextMoves);
                    nextMoves.clear();

                    for (int[] move : nowMoves) {
                        int y = move[0];
                        int x = move[1];

                        if (y == targetY && x == targetX) {
                            break loop;
                        }

                        for (int[] nightMove : nightMoves) {
                            if (isPossibleMove(visit, y + nightMove[0], x + nightMove[1])) {
                                visit[y + nightMove[0]][x + nightMove[1]] = true;
                                nextMoves.add(new int[]{y + nightMove[0], x + nightMove[1]});
                            }
                        }
                    }

                    moveNumber += 1;
                }

                stringBuilder.append(moveNumber).append("\n");
            }

            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }

    private static boolean isPossibleMove(boolean[][] visit, int y, int x) {
        if (y < 0 || y >= visit.length) {
            return false;
        }
        if (x < 0 || x >= visit.length) {
            return false;
        }
        return !visit[y][x];
    }
}
