package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이동하기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[][] miro = new int[N][M];
            int[][] candy = new int[N][M];

            for (int y = 0; y < N; y += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                for (int x = 0; x < M; x += 1) {
                    int value = Integer.parseInt(stringTokenizer.nextToken());
                    miro[y][x] = value;
                    candy[y][x] = value;
                }
            }

            for (int y = 0; y < N; y += 1) {
                for (int x = 0; x < M; x += 1) {
                    if (y + 1 < miro.length && candy[y][x] + miro[y + 1][x] >= candy[y + 1][x]) {
                        candy[y + 1][x] = candy[y][x] + miro[y + 1][x];
                    }
                    if (x + 1 < miro[y].length && candy[y][x] + miro[y][x + 1] >= candy[y][x + 1]) {
                        candy[y][x + 1] = candy[y][x] + miro[y][x + 1];
                    }
                    if (y + 1 < miro.length && x + 1 < miro[y].length && candy[y][x] + miro[y + 1][x + 1] >= candy[y + 1][x + 1]) {
                        candy[y + 1][x + 1] = candy[y][x] + miro[y + 1][x + 1];
                    }
                }
            }

            for (int y = 0; y < N; y += 1) {
                System.out.println(Arrays.toString(candy[y]));
            }
            System.out.println(candy[N - 1][M - 1]);
        }
    }
}
