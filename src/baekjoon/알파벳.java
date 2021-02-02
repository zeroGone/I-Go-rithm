package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 알파벳 {
    private static char[][] map;

    private static int[][] directions = new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{-1, 0}
    };

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int R = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());

            map = new char[R][C];

            for (int Rindex = 0; Rindex < R; Rindex += 1) {
                String string = reader.readLine();
                for (int Cindex = 0; Cindex < C; Cindex += 1) {
                    map[Rindex][Cindex] = string.charAt(Cindex);
                }
            }

            System.out.print(dfs("", 0, 0));
        }
    }

    private static int dfs(String visit, int y, int x) {
        visit = visit + map[y][x];

        int max = visit.length();
        for (int[] direction : directions) {
            if (y + direction[0] < 0 || y + direction[0] >= map.length) {
                continue;
            }
            if (x + direction[1] < 0 || x + direction[1] >= map[y].length) {
                continue;
            }
            if (contain(visit, map[y + direction[0]][x + direction[1]])) {
                continue;
            }
            max = Math.max(max, dfs(visit, y + direction[0], x + direction[1]));
        }

        return max;
    }

    private static boolean contain(String string, char character) {
        for (char element : string.toCharArray()) {
            if (element == character) {
                return true;
            }
        }
        return false;
    }
}
