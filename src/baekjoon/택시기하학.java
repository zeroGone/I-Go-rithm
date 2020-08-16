package baekjoon;

import java.util.Scanner;

public class 택시기하학 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        System.out.printf("%.6f\n%.6f", R*R*Math.PI, (double)R*R*2);
    }
}
