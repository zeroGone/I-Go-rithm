package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴증가하는부분수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();

        int[] array = new int[A];
        for (int index = 0; index < A; index += 1) {
            array[index] = scanner.nextInt();
        }

        int[] dp = new int[A];
        Arrays.fill(dp, 1);

        for (int start = 0; start < A; start += 1) {
            for (int index = start + 1; index < A; index += 1) {
                if (array[start] < array[index]) {
                    dp[index] = Math.max(dp[index], dp[start] + 1);
                }
            }
        }

        int max = 0;
        for (int value : dp) {
            max = Math.max(value, max);
        }
        System.out.print(max);
    }
}
