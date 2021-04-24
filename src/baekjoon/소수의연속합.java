package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수의연속합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        List<Integer> primeNumbers = new ArrayList<>();

        for (int number = 2; number < N; number += 1) {
            if (isPrime(primeNumbers, number)) {
                primeNumbers.add(number);
            }
        }
        System.out.println(primeNumbers);
        int answer = 0;
        if (isPrime(primeNumbers, N)) {
            primeNumbers.add(N);
            answer += 1;
        }

        int sum = 0;
        int left = 0;
        int right = 0;

        for (int index = 0; sum < N && index < primeNumbers.size(); index += 1) {
            sum += primeNumbers.get(index);
            right++;
        }
        if (right == primeNumbers.size()) {
            right -= 1;
        }
        while (left < right) {
            if (sum == N) {
                answer++;
            }
            if (sum > N) {
                sum -= primeNumbers.get(left++);
            } else {
                sum += primeNumbers.get(right--);
            }
        }
        System.out.print(answer);
    }

    private static boolean isPrime(List<Integer> primeNumbers, int value) {
        return primeNumbers.stream().noneMatch(number -> value % number == 0);
    }
}
