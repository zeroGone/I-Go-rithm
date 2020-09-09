package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '1') map[i][j] = 1;
            }
        }


        int num = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {

                    LinkedList<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    int n = 0;
                    while (!q.isEmpty()) {
                        Point now = q.poll();
                        int x = now.getX();
                        int y = now.getY();

                        if (x + 1 < N && map[x + 1][y] == 1 && !visited[x + 1][y]) {
                            visited[x+1][y] = true;
                            q.add(new Point(x + 1, y));
                        }

                        if (x - 1 >= 0 && map[x - 1][y] == 1 && !visited[x - 1][y]) {
                            visited[x-1][y] = true;
                            q.add(new Point(x - 1, y));
                        }

                        if (y + 1 < N && map[x][y + 1] == 1 && !visited[x][y + 1]) {
                            visited[x][y+1] = true;
                            q.add(new Point(x, y + 1));
                        }

                        if (y - 1 >= 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
                            visited[x][y-1] = true;
                            q.add(new Point(x, y - 1));
                        }
                        n++;
                    }

                    list.add(n);
                    num++;
                }
            }
        }
        System.out.println(num);

        StringBuilder builder = new StringBuilder();
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) builder.append(list.get(i)).append("\n");
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
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
