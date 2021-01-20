package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무자르기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            long M = Long.parseLong(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(reader.readLine());

            long[] treeHeights = new long[N];

            for (int index = 0; index < treeHeights.length; index += 1) {
                treeHeights[index] = Long.parseLong(stringTokenizer.nextToken());
            }

            long answer = Long.MAX_VALUE;
            long start = 0;
            long end = Long.MAX_VALUE;

            while (start <= end) {
                long middle = (start + end) / 2;

                long sum = 0;
                for (long treeHeight : treeHeights) {
                    if (treeHeight > middle) {
                        sum += treeHeight - middle;
                    }
                }

                if (sum >= M) {
                    answer = middle;
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }

            System.out.print(answer);
        }
    }
}