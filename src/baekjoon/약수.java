package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 약수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] array = new int[N];

        for (int index = 0; index < N; index += 1) {
            array[index] = scanner.nextInt();
        }

        Arrays.sort(array);

        long answer = (long) array[0] * array[N - 1];

        System.out.print(answer);
    }
}
