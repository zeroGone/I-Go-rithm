package baekjoon;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.print(solution(N));
    }

    private static int solution(int N) {
        for (int number = 1; number < N; number += 1) {
            int sum = number;

            for (int temp = number; temp > 0; temp /= 10) {
                sum += temp % 10;
            }

            if (sum == N) {
                return number;
            }
        }
        return 0;
    }
}