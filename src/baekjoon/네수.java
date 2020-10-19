package baekjoon;

import java.util.Scanner;

public class 네수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();

        String AB = Integer.toString(A)+Integer.toString(B);
        String CD = Integer.toString(C)+Integer.toString(D);

        System.out.print(Long.parseLong(AB)+Long.parseLong(CD));
    }
}
