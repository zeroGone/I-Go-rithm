package baekjoon;

import java.util.Scanner;

public class 다리놓기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int testcase = 1; testcase <= T; testcase += 1) {
            int west = scanner.nextInt();
            int east = scanner.nextInt();

            long[][] dp = new long[west + 1][east + 1];

            stringBuilder.append(solution(dp, west, east)).append("\n");
        }
        System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
    }

    private static long solution(long[][] dp, int west, int east) {
        if (dp[west][east] != 0) {
            return dp[west][east];
        }
        if (west == 0) {
            return 1;
        }

        long sum = 0;
        for (int choose = east - 1; choose >= 0; choose -= 1) {
            if (west - 1 > choose) {
                break;
            }
            sum += solution(dp, west - 1, choose);
        }
        return dp[west][east] = sum;
    }
}
