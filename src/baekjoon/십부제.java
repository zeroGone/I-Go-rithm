package baekjoon;

import java.util.Scanner;

public class 십부제 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int answer = 0;
        for(int i=0; i<5; i++){
            if(N == scanner.nextInt()) answer++;
        }

        System.out.print(answer);
    }
}
