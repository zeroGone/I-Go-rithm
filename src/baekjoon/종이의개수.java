package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 종이의개수 {
    private static Map<Integer, Integer> values = new HashMap<>();

    public static void main(String[] args) throws IOException {
        values.put(-1, 0);
        values.put(0, 0);
        values.put(1, 0);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            int[][] paper = new int[N][N];

            for (int y = 0; y < N; y += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                for (int x = 0; x < N; x += 1) {
                    paper[y][x] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            solution(paper, 0, N - 1, 0, N - 1);

            System.out.println(values.get(-1));
            System.out.println(values.get(0));
            System.out.print(values.get(1));
        }
    }

    private static void solution(int[][] paper, int startY, int endY, int startX, int endX) {
        if (isSameNumbers(paper, startY, endY, startX, endX)) {
            values.put(paper[startY][startX], values.get(paper[startY][startX]) + 1);
            return;
        }

        for (int y = startY; y <= endY; y += (endY - startY + 1) / 3) {
            for (int x = startX; x <= endX; x += (endX - startX + 1) / 3) {
                solution(paper, y, y + (endY - startY) / 3, x, x + (endX - startX) / 3);
            }
        }
    }

    private static boolean isSameNumbers(int[][] paper, int startY, int endY, int startX, int endX) {
        int temp = paper[startY][startX];
        for (int y = startY; y <= endY; y += 1) {
            for (int x = startX; x <= endX; x += 1) {
                if (temp != paper[y][x]) {
                    return false;
                }
            }
        }
        return true;
    }
}
