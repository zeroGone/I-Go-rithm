package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 신나는함수실행 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();

            int[][][] dp = new int[21][21][21];
            w(dp, 20, 20, 20);

            while (true) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                int c = Integer.parseInt(stringTokenizer.nextToken());

                if (a == -1 && b == -1 && c == -1) {
                    break;
                }
                stringBuilder.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                        .append(w(dp, a, b, c)).append("\n");
            }

            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }

    private static int w(int[][][] dp, int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(dp, 20, 20, 20);
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            dp[a][b][c] = w(dp, a, b, c - 1) + w(dp, a, b - 1, c - 1) - w(dp, a, b - 1, c);
        }
        dp[a][b][c] = w(dp, a - 1, b, c) + w(dp, a - 1, b - 1, c) + w(dp, a - 1, b, c - 1) - w(dp, a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}
