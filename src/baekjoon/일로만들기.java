package baekjoon;

import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        int[] dp = new int[1000001];
        dp[2] = 1;
        dp[3] = 1;

        for (int index = 4; index < dp.length; index += 1) {
            int min = dp[index - 1];
            if (index % 3 == 0) {
                min = Math.min(min, dp[index / 3]);
            }
            if (index % 2 == 0) {
                min = Math.min(min, dp[index / 2]);
            }
            dp[index] = min + 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print(dp[scanner.nextInt()]);
    }
}
