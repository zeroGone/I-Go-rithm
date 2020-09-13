package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            if (w == 1 || h == 1) {
                builder.append(Integer.parseInt(reader.readLine())).append("\n");
            } else {
                int[][] map = new int[h][w];
                for (int i = 0; i < h; i++) {
                    st = new StringTokenizer(reader.readLine());
                    for (int j = 0; j < w; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                boolean[][] visited = new boolean[h][w];

                int num = 0;
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if (map[i][j] == 1 && !visited[i][j]) {
                            visited[i][j] = true;
                            dfs(map, visited, i, j);
                            num++;
                        }
                    }
                }

                builder.append(num).append("\n");
            }
        }
        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }

    private static void dfs(int[][] map, boolean[][] visited, int y, int x) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (y + i < 0 || y + i == map.length) continue;
                if (x + j < 0 || x + j == map[y].length) continue;
                if (map[y + i][x + j] == 1 && !visited[y + i][x + j]) {
                    visited[y + i][x + j] = true;
                    dfs(map, visited, y + i, x + j);
                }
            }
        }
    }
}
