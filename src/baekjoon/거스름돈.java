package baekjoon;

import java.util.Scanner;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int temp = 1000 - input;
        int[] money = new int[]{
                500, 100, 50, 10, 5, 1
        };

        int answer = 0;
        for(int m : money){
            while( m <= temp){
                temp -= m;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
