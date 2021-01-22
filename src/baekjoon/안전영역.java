package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 안전영역 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            map = new int[N][N];

            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int y = 0; y < N; y += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                for (int x = 0; x < N; x += 1) {
                    int number = Integer.parseInt(stringTokenizer.nextToken());
                    if (number < min) {
                        min = number;
                    }
                    if (number > max) {
                        max = number;
                    }
                    map[y][x] = number;
                }
            }

            int areaMaxNumber = 0;
            for (int height = min - 1; height <= max; height += 1) {
                boolean[][] floodedMap = getFloodedMap(height);

                int areaNumber = getAreaNumber(floodedMap);

                if (areaMaxNumber < areaNumber) {
                    areaMaxNumber = areaNumber;
                }
            }

            System.out.print(areaMaxNumber);
        }
    }

    private static boolean[][] getFloodedMap(int height) {
        boolean[][] flooded = new boolean[map.length][map.length];

        for (int y = 0; y < map.length; y += 1) {
            for (int x = 0; x < map.length; x += 1) {
                if (map[y][x] < height) {
                    flooded[y][x] = true;
                }
            }
        }

        return flooded;
    }

    private static int getAreaNumber(boolean[][] map) {
        int number = 0;
        for (int y = 0; y < map.length; y += 1) {
            for (int x = 0; x < map.length; x += 1) {
                if (!map[y][x]) {
                    map[y][x] = true;

                    List<int[]> areas = new ArrayList<>();
                    areas.add(new int[]{y, x});

                    while (!areas.isEmpty()) {
                        List<int[]> nexts = new ArrayList<>(areas);
                        areas.clear();

                        for (int[] next : nexts) {
                            int nextY = next[0];
                            int nextX = next[1];

                            if (nextY + 1 < map.length && !map[nextY + 1][nextX]) {
                                map[nextY + 1][nextX] = true;
                                areas.add(new int[]{nextY + 1, nextX});
                            }
                            if (nextX + 1 < map.length && !map[nextY][nextX + 1]) {
                                map[nextY][nextX + 1] = true;
                                areas.add(new int[]{nextY, nextX + 1});
                            }
                            if (nextY - 1 >= 0 && !map[nextY - 1][nextX]) {
                                map[nextY - 1][nextX] = true;
                                areas.add(new int[]{nextY - 1, nextX});
                            }
                            if (nextX - 1 >= 0 && !map[nextY][nextX - 1]) {
                                map[nextY][nextX - 1] = true;
                                areas.add(new int[]{nextY, nextX - 1});
                            }
                        }
                    }

                    number += 1;
                }
            }
        }
        return number;
    }
}
