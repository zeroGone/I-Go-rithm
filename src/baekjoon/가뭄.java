package baekjoon;

import java.util.Scanner;

public class 가뭄 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double d1 = ((double) a - c + b) / 2;
        double d2 = ((double) c - b + a) / 2;
        double d3 = ((double) c - a + b) / 2;

        if (d1 < 1 || d2 < 1 || d3 < 1 || d1 + d2 != a || d1 + d3 != b || d2 + d3 != c)
            System.out.print(-1);
        else
            System.out.printf("1\n%.1f %.1f %.1f", d1, d2, d3);

    }
}
