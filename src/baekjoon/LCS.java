package baekjoon;

import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.next();
        String string2 = scanner.next();

        System.out.print(LCS(string1, string2));
    }

    private static int LCS(String string1, String string2) {
        int[][] dp = new int[string1.length() + 1][string2.length() + 1];

        for (int index1 = string1.length() - 1; index1 >= 0; index1 -= 1) {
            for (int index2 = string2.length() - 1; index2 >= 0; index2 -= 1) {
                if (string1.charAt(index1) == string2.charAt(index2)) {
                    dp[index1][index2] = dp[index1 + 1][index2 + 1] + 1;
                } else {
                    dp[index1][index2] = Math.max(dp[index1 + 1][index2], dp[index1][index2 + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
