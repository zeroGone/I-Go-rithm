package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전1 {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strings = reader.readLine().split(" ");
            int n = Integer.parseInt(strings[0]);
            int k = Integer.parseInt(strings[1]);

            dp = new int[n][k + 1];

            int[] coins = new int[n];
            for (int index = 0; index < n; index += 1) {
                Arrays.fill(dp[index], -1);
                coins[index] = Integer.parseInt(reader.readLine());
            }

            System.out.print(solution(coins, 0, k));

            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

    private static long solution(int[] coins, int index, int rest) {
        if (index >= coins.length) {
            return 0;
        }

        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }

        int sum = 0;
        for (int number = rest / coins[index]; number >= 0; number -= 1) {
            if (rest - coins[index] * number == 0) {
                sum += 1;
            } else {
                sum += solution(coins, index + 1, rest - coins[index] * number);
            }
        }
        return dp[index][rest] = sum;
    }
}
