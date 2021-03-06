package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장긴바이토부분수열 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            int[] array = new int[N];
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int index = 0; index < N; index += 1) {
                array[index] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int[] right = new int[N];
            Arrays.fill(right, 1);

            for (int start = 0; start < N; start += 1) {
                for (int index = start + 1; index < N; index += 1) {
                    if (array[start] < array[index]) {
                        right[index] = Math.max(right[index], right[start] + 1);
                    }
                }
            }

            int[] left = new int[N];
            Arrays.fill(left, 1);

            for (int start = N - 1; start >= 0; start -= 1) {
                for (int index = start - 1; index >= 0; index -= 1) {
                    if (array[start] < array[index]) {
                        left[index] = Math.max(left[index], left[start] + 1);
                    }
                }
            }

            int sum = left[0] + right[0];
            for (int index = 1; index < N; index += 1) {
                sum = Math.max(sum, left[index] + right[index]);
            }

            System.out.print(sum - 1);
        }
    }
}
