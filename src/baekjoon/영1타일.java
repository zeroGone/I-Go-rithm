package baekjoon;

import java.util.Scanner;

public class 영1타일 {
    public static void main(String[] args) {
        int[] array = new int[1000001];
        array[1] = 1;
        array[2] = 2;

        for (int number = 3; number <= 1000000; number += 1) {
            array[number] = (array[number - 1] + array[number - 2]) % 15746;
        }

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.print(array[N]);
    }
}
