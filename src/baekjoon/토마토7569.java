package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 토마토7569 {
    private static int[][][] tomatoBox;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int H = Integer.parseInt(stringTokenizer.nextToken());

            tomatoBox = new int[H][N][M];

            for (int boxNumber = 0; boxNumber < H; boxNumber += 1) {
                for (int y = 0; y < N; y += 1) {
                    stringTokenizer = new StringTokenizer(reader.readLine());
                    for (int x = 0; x < M; x += 1) {
                        tomatoBox[boxNumber][y][x] = Integer.parseInt(stringTokenizer.nextToken());
                    }
                }
            }

            System.out.print(solution());
        }
    }

    private static int solution() {
        int days = 0;

        List<int[]> tomatos = new ArrayList<>();
        for (int boxNumber = 0; boxNumber < tomatoBox.length; boxNumber += 1) {
            for (int y = 0; y < tomatoBox[boxNumber].length; y += 1) {
                for (int x = 0; x < tomatoBox[boxNumber][y].length; x += 1) {
                    if (tomatoBox[boxNumber][y][x] == 1) {
                        tomatos.add(new int[]{boxNumber, y, x});
                    }
                }
            }
        }

        while (!tomatos.isEmpty()) {
            List<int[]> rawTomatos = new ArrayList<>(tomatos);
            tomatos.clear();

            for (int[] rawTomato : rawTomatos) {
                int boxNumber = rawTomato[0];
                int y = rawTomato[1];
                int x = rawTomato[2];

                if (boxNumber + 1 < tomatoBox.length && tomatoBox[boxNumber + 1][y][x] == 0) {
                    tomatoBox[boxNumber + 1][y][x] = 1;
                    tomatos.add(new int[]{boxNumber + 1, y, x});
                }
                if (y + 1 < tomatoBox[boxNumber].length && tomatoBox[boxNumber][y + 1][x] == 0) {
                    tomatoBox[boxNumber][y + 1][x] = 1;
                    tomatos.add(new int[]{boxNumber, y + 1, x});
                }
                if (x + 1 < tomatoBox[boxNumber][y].length && tomatoBox[boxNumber][y][x + 1] == 0) {
                    tomatoBox[boxNumber][y][x + 1] = 1;
                    tomatos.add(new int[]{boxNumber, y, x + 1});
                }
                if (boxNumber - 1 >= 0 && tomatoBox[boxNumber - 1][y][x] == 0) {
                    tomatoBox[boxNumber - 1][y][x] = 1;
                    tomatos.add(new int[]{boxNumber - 1, y, x});
                }
                if (y - 1 >= 0 && tomatoBox[boxNumber][y - 1][x] == 0) {
                    tomatoBox[boxNumber][y - 1][x] = 1;
                    tomatos.add(new int[]{boxNumber, y - 1, x});
                }
                if (x - 1 >= 0 && tomatoBox[boxNumber][y][x - 1] == 0) {
                    tomatoBox[boxNumber][y][x - 1] = 1;
                    tomatos.add(new int[]{boxNumber, y, x - 1});
                }
            }

            if (!tomatos.isEmpty()) {
                days += 1;
            }
        }

        for (int boxNumber = 0; boxNumber < tomatoBox.length; boxNumber += 1) {
            for (int y = 0; y < tomatoBox[boxNumber].length; y += 1) {
                for (int x = 0; x < tomatoBox[boxNumber][y].length; x += 1) {
                    if (tomatoBox[boxNumber][y][x] == 0) {
                        return -1;
                    }
                }
            }
        }
        return days;
    }
}
