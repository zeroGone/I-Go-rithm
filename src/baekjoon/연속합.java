package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            long[] values = new long[n];
            for (int index = 0; index < n; index += 1) {
                values[index] = Long.parseLong(stringTokenizer.nextToken());
            }

            for (int x = n - 2; x >= 0; x -= 1) {
                values[x] = Math.max(values[x], values[x] + values[x + 1]);
            }

            long answer = -Long.MAX_VALUE;
            for (long value : values) {
                answer = Math.max(answer, value);
            }

            System.out.print(answer);
        }
    }
}
