package baekjoon.재귀;

import java.util.Scanner;

public class 일이삼더하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] array = new int[T];
        for (int i = 0; i < T; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(recursion(array[i], 0));
        }
    }

    public static int recursion(int goal, int value) {
        if (goal < value) return 0;
        else if (goal == value) return 1;

        int n = 0;
        n += recursion(goal, value + 1);
        n += recursion(goal, value + 2);
        n += recursion(goal, value + 3);
        return n;
    }
}
