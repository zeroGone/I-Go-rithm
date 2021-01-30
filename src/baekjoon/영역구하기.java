package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 영역구하기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            boolean[][] paper = new boolean[M][N];

            for (int number = 1; number <= K; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int leftDownX = Integer.parseInt(stringTokenizer.nextToken());
                int leftDownY = Integer.parseInt(stringTokenizer.nextToken());
                int rightUpX = Integer.parseInt(stringTokenizer.nextToken());
                int rightUpY = Integer.parseInt(stringTokenizer.nextToken());

                for (int x = Math.min(leftDownX, rightUpX); x < Math.max(leftDownX, rightUpX); x += 1) {
                    for (int y = Math.min(leftDownY, rightUpY); y < Math.max(leftDownY, rightUpY); y += 1) {
                        paper[y][x] = true;
                    }
                }
            }

            List<Integer> areas = new ArrayList<>();
            for (int y = 0; y < M; y += 1) {
                for (int x = 0; x < N; x += 1) {
                    if (!paper[y][x]) {
                        int area = 0;
                        paper[y][x] = true;

                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{y, x});
                        while (!list.isEmpty()) {
                            area += list.size();
                            List<int[]> nexts = new ArrayList<>();
                            nexts.addAll(list);
                            list.clear();

                            for (int[] next : nexts) {
                                int nextY = next[0];
                                int nextX = next[1];
                                if (nextY + 1 < M && !paper[nextY + 1][nextX]) {
                                    paper[nextY + 1][nextX] = true;
                                    list.add(new int[]{nextY + 1, nextX});
                                }
                                if (nextX + 1 < N && !paper[nextY][nextX + 1]) {
                                    paper[nextY][nextX + 1] = true;
                                    list.add(new int[]{nextY, nextX + 1});
                                }
                                if (nextY - 1 >= 0 && !paper[nextY - 1][nextX]) {
                                    paper[nextY - 1][nextX] = true;
                                    list.add(new int[]{nextY - 1, nextX});
                                }
                                if (nextX - 1 >= 0 && !paper[nextY][nextX - 1]) {
                                    paper[nextY][nextX - 1] = true;
                                    list.add(new int[]{nextY, nextX - 1});
                                }
                            }
                        }
                        areas.add(area);
                    }
                }
            }
            Collections.sort(areas);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(areas.size()).append("\n");
            for (int area : areas) {
                stringBuilder.append(area).append(" ");
            }
            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }
}
