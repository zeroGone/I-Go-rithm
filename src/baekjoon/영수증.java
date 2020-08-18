package baekjoon;

import java.util.Scanner;

public class 영수증 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for(int i=0; i<9; i++) sum -= scanner.nextInt();
        System.out.println(sum);
    }
}
