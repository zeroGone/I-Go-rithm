package baekjoon;

import java.util.Scanner;

public class 최댓값 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        int answer = 0;

        for(int i=0; i<9; i++){
            int value = scanner.nextInt();
            if(max < value){
                max = value;
                answer = i+1;
            }
        }

        System.out.println(max);
        System.out.print(answer);
    }
}
