package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            int[] values = new int[n];

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int index = 0; index < n; index += 1) {
                values[index] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(values);

            int answer = 0;
            int target = Integer.parseInt(reader.readLine());
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int sum = values[left] + values[right];

                if (sum == target) {
                    answer += 1;
                    left++;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            System.out.print(answer);
        }
    }
}
