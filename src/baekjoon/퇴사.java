package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 퇴사 {
    private static int[] days;
    private static int[] prices;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            days = new int[N + 1];
            prices = new int[N + 1];
            dp = new int[N + 1];

            for (int index = 1; index <= N; index += 1) {
                String[] strings = reader.readLine().split(" ");
                days[index] = Integer.parseInt(strings[0]);
                prices[index] = Integer.parseInt(strings[1]);
            }


            solution(1, 0);

            int answer = 0;
            for (int value : dp) {
                if (answer < value) {
                    answer = value;
                }
            }
            System.out.print(answer);
        }
    }

    private static void solution(int index, int total) {
        if (index >= days.length) {
            return;
        }

        solution(index + 1, total);

        if (index + days[index] > days.length) {
            return;
        }
        if (dp[index] < total + prices[index]) {
            dp[index] = total + prices[index];
            solution(index + days[index], total + prices[index]);
        }
    }
}
