package programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class 카카오프렌즈컬러링북 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 카카오프렌즈컬러링북().solution(6, 4, new int[][]{
                new int[]{1, 1, 1, 0},
                new int[]{1, 1, 1, 0},
                new int[]{0, 0, 0, 1},
                new int[]{0, 0, 0, 1},
                new int[]{0, 0, 0, 1},
                new int[]{0, 0, 0, 1},
        })));
    }

    public int[] solution(int m, int n, int[][] picture) {

        int sum = 0;
        int max = 0;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] != 0 && !visit[i][j]) {

                    visit[i][j] = true;
                    sum++;

                    LinkedList<Point> q = new LinkedList<>();
                    q.add(new Point(i, j));

                    int num = 0;
                    while (!q.isEmpty()) {
                        num++;
                        Point now = q.poll();
                        int x = now.getX();
                        int y = now.getY();

                        int value = picture[x][y];
                        if (x + 1 < picture.length && !visit[x + 1][y] && y < picture[x + 1].length && value == picture[x + 1][y]) {
                            q.push(new Point(x + 1, y));
                            visit[x+1][y] = true;
                        }
                        if (y + 1 < picture[x].length && !visit[x][y + 1] && value == picture[x][y + 1]) {
                            q.push(new Point(x, y + 1));
                            visit[x][y+1] = true;
                        }
                        if (x - 1 >= 0 && !visit[x - 1][y] && y < picture[x - 1].length && value == picture[x - 1][y]) {
                            q.push(new Point(x - 1, y));
                            visit[x-1][y] = true;
                        }
                        if (y - 1 >= 0 && !visit[x][y - 1] && value == picture[x][y - 1]) {
                            q.push(new Point(x, y - 1));
                            visit[x][y-1] = true;
                        }
                    }

                    if (num > max) max = num;
                }
            }
        }

        return new int[]{sum, max};
    }

    class Point {
        private int x;
        private int y;

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
