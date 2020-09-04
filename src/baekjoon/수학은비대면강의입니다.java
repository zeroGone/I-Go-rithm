package baekjoon;

import java.util.Scanner;

public class 수학은비대면강의입니다 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        System.out.printf("%d %d", (c*e - b*f)/(a*e - d*b), (c*d - a*f) / (b*d - e*a));
    }
}
