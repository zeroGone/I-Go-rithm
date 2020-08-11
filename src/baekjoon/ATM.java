package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = scanner.nextInt();

        Arrays.sort(num);

        int answer = 0;
        int value = 0;
        for(int i:num){
            value+=i;
            answer+=value;
        }

        System.out.println(answer);
    }
}
