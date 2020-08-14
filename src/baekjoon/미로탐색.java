package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        int[][] miro = new int[N][M];
        int[][] min = new int[N][M];

        for (int i = 0; i < N; i++) {
            String string = reader.readLine();
            for (int j = 0; j < M; j++) {
                min[i][j] = Integer.MAX_VALUE;
                miro[i][j] = string.charAt(j) - 48;
            }
        }

        min[0][0] = miro[0][0];
        LinkedList<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            int x = now.getX();
            int y = now.getY();
            //오른쪽
            if (x + 1 < M && miro[y][x + 1] != 0 && min[y][x] + miro[y][x + 1] < min[y][x + 1]) {
                min[y][x + 1] = min[y][x] + miro[y][x + 1];
                q.add(new Point(x + 1, y));
            }
            //밑
            if (y + 1 < N && miro[y + 1][x] != 0 && min[y][x] + miro[y + 1][x] < min[y + 1][x]) {
                min[y + 1][x] = min[y][x] + miro[y + 1][x];
                q.add(new Point(x, y + 1));
            }
            //왼쪽
            if (x - 1 >= 0 && miro[y][x - 1] != 0 && min[y][x] + miro[y][x - 1] < min[y][x - 1]) {
                min[y][x - 1] = min[y][x] + miro[y][x - 1];
                q.add(new Point(x - 1, y));
            }
            //위
            if (y - 1 >= 0 && miro[y - 1][x] != 0 && min[y][x] + miro[y - 1][x] < min[y - 1][x]) {
                min[y - 1][x] = min[y][x] + miro[y - 1][x];
                q.add(new Point(x, y - 1));
            }
        }
        System.out.println(min[N - 1][M - 1]);
    }

    static class Point {
        int x;
        int y;

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
