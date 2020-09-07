package baekjoon;

import java.util.Scanner;

public class 수학은체육과목입니다2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int[] a = new int[]{1, 2, 3, 4, 5, 4, 3, 2};
        System.out.println(a[(int) (n % a.length == 0 ? a.length - 1 : n % a.length - 1)]);
    }
}
