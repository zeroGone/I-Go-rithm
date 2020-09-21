package baekjoon;

import java.util.Scanner;

public class 이엑스엔타일링 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        a[1] = 1;
        if(n>=2) a[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            a[i] = a[i - 1] + a[i - 2] ;
        }
        System.out.print(a[n] % 10007);
    }
}
