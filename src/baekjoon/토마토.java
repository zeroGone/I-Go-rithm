package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 토마토 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int status = Integer.parseInt(st.nextToken());
                if (status == 1) map[i][j] = 1;
                else if (status == -1) map[i][j] = -1;
            }
        }

        LinkedList<Point> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) q.add(new Point(i, j));
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            int x = now.getX();
            int y = now.getY();

            if (x + 1 < M && map[x + 1][y] == 0) {
                map[x + 1][y] = map[x][y] + 1;
                q.add(new Point(x + 1, y));
            }

            if (x - 1 >= 0 && map[x - 1][y] == 0) {
                map[x - 1][y] = map[x][y] + 1;
                q.add(new Point(x - 1, y));
            }

            if (y + 1 < N && map[x][y + 1] == 0) {
                map[x][y + 1] = map[x][y] + 1;
                q.add(new Point(x, y + 1));
            }

            if (y - 1 >= 0 && map[x][y - 1] == 0) {
                map[x][y - 1] = map[x][y] + 1;
                q.add(new Point(x, y - 1));
            }
        }

        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0){
                    System.out.print(-1);
                    return;
                }
                max = Math.max(max, map[i][j]);
            }
        }

        System.out.print(max-1);
    }

    static class Point {
        private final int x;
        private final int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
