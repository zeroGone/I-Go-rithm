package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상금헌터 {
    private static int[] festival1 = new int[]{
            0, 5000000,
            3000000, 3000000,
            2000000, 2000000, 2000000,
            500000, 500000, 500000, 500000,
            300000, 300000, 300000, 300000, 300000,
            100000, 100000, 100000, 100000, 100000, 100000,
    };

    private static int[] festival2 = new int[]{
            0,
            5120000,
            2560000, 2560000,
            1280000, 1280000, 1280000, 1280000,
            640000, 640000, 640000, 640000, 640000, 640000, 640000, 640000,
            320000, 320000, 320000, 320000, 320000, 320000, 320000, 320000,
            320000, 320000, 320000, 320000, 320000, 320000, 320000, 320000,
    };

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();

            int T = Integer.parseInt(reader.readLine());

            for (int number = 1; number <= T; number += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                long sum = 0;

                if (a < festival1.length) {
                    sum += festival1[a];
                }
                if (b < festival2.length) {
                    sum += festival2[b];
                }

                stringBuilder.append(sum).append("\n");
            }

            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }
}
