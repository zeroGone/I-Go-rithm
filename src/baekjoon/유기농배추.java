package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            boolean[][] visited = new boolean[N][M];

            int num = 0;
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (!visited[a][b]) {
                        visited[a][b] = true;
                        if (map[a][b] == 1) {
                            dfs(map, visited, a, b);
                            num++;
                        }
                    }
                }
            }
            builder.append(num).append("\n");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    private static void dfs(int[][] map, boolean[][] visited, int x, int y) {
        if (x + 1 < map.length && map[x + 1][y] == 1 && !visited[x + 1][y]) {
            visited[x + 1][y] = true;
            dfs(map, visited, x + 1, y);
        }

        if (x - 1 >= 0 && map[x - 1][y] == 1 && !visited[x - 1][y]) {
            visited[x - 1][y] = true;
            dfs(map, visited, x - 1, y);
        }

        if (y + 1 < map[x].length && map[x][y + 1] == 1 && !visited[x][y + 1]) {
            visited[x][y + 1] = true;
            dfs(map, visited, x, y + 1);
        }

        if (y - 1 >= 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
            visited[x][y - 1] = true;
            dfs(map, visited, x, y - 1);
        }
    }
}
