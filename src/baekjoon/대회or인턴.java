package baekjoon;

import java.util.Scanner;

public class 대회or인턴 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        int answer = Math.min(N / 2, M);

        int temp = (N - answer * 2) + (M - answer);

        if(temp < K){
            K = K - temp;
            K = K % 3 > 0 ? K / 3 + 1 : K / 3;
            answer -= K;
        }
        System.out.print(answer);
    }
}
