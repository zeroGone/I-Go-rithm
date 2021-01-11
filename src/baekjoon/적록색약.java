package baekjoon;

import java.util.*;

public class 적록색약 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        char[][] map = new char[N][N];

        for (int index = 0; index < N; index += 1) {
            String string = scanner.next();
            for (int characterIndex = 0; characterIndex < N; characterIndex += 1) {
                map[index][characterIndex] = string.charAt(characterIndex);
            }
        }

        boolean[][] normal = new boolean[N][N];
        boolean[][] weakend = new boolean[N][N];

        int answer1 = 0;
        int answer2 = 0;

        for (int y = 0; y < N; y += 1) {
            for (int x = 0; x < N; x += 1) {
                if (!normal[y][x]) {
                    bfs1(normal, map, y, x);
                    answer1 += 1;
                }
                if (!weakend[y][x]) {
                    bfs2(weakend, map, y, x);
                    answer2 += 1;
                }
            }
        }
        System.out.print(answer1 + " " + answer2);
    }

    private static void bfs1(boolean[][] visit, char[][] map, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            List<int[]> nexts = new ArrayList<>(queue);
            queue.clear();

            for (int[] next : nexts) {
                int nextY = next[0];
                int nextX = next[1];
                if (nextY + 1 < visit.length && !visit[nextY + 1][nextX]
                        && map[nextY][nextX] == map[nextY + 1][nextX]) {
                    visit[nextY + 1][nextX] = true;
                    queue.add(new int[]{nextY + 1, nextX});
                }
                if (nextY - 1 >= 0 && !visit[nextY - 1][nextX]
                        && map[nextY][nextX] == map[nextY - 1][nextX]) {
                    visit[nextY - 1][nextX] = true;
                    queue.add(new int[]{nextY - 1, nextX});
                }
                if (nextX + 1 < visit.length && !visit[nextY][nextX + 1]
                        && map[nextY][nextX] == map[nextY][nextX + 1]) {
                    visit[nextY][nextX + 1] = true;
                    queue.add(new int[]{nextY, nextX + 1});
                }
                if (nextX - 1 >= 0 && !visit[nextY][nextX - 1]
                        && map[nextY][nextX] == map[nextY][nextX - 1]) {
                    visit[nextY][nextX - 1] = true;
                    queue.add(new int[]{nextY, nextX - 1});
                }
            }
        }
    }

    private static void bfs2(boolean[][] visit, char[][] map, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;

        while (!queue.isEmpty()) {
            List<int[]> nexts = new ArrayList<>(queue);
            queue.clear();

            for (int[] next : nexts) {
                int nextY = next[0];
                int nextX = next[1];
                if (nextY + 1 < visit.length && !visit[nextY + 1][nextX]
                        && isGreenAndRedBlind(map, nextY, nextX, nextY + 1, nextX)) {
                    visit[nextY + 1][nextX] = true;
                    queue.add(new int[]{nextY + 1, nextX});
                }
                if (nextY - 1 >= 0 && !visit[nextY - 1][nextX]
                        && isGreenAndRedBlind(map, nextY, nextX, nextY - 1, nextX)) {
                    visit[nextY - 1][nextX] = true;
                    queue.add(new int[]{nextY - 1, nextX});
                }
                if (nextX + 1 < visit.length && !visit[nextY][nextX + 1]
                        && isGreenAndRedBlind(map, nextY, nextX, nextY, nextX + 1)) {
                    visit[nextY][nextX + 1] = true;
                    queue.add(new int[]{nextY, nextX + 1});
                }
                if (nextX - 1 >= 0 && !visit[nextY][nextX - 1]
                        && isGreenAndRedBlind(map, nextY, nextX, nextY, nextX - 1)) {
                    visit[nextY][nextX - 1] = true;
                    queue.add(new int[]{nextY, nextX - 1});
                }
            }
        }
    }

    private static boolean isGreenAndRedBlind(char[][] map, int y1, int x1, int y2, int x2) {
        if (map[y1][x1] == 'G' && map[y2][x2] == 'R') {
            return true;
        }
        if (map[y1][x1] == 'R' && map[y2][x2] == 'G') {
            return true;
        }
        return map[y1][x1] == map[y2][x2];
    }
}