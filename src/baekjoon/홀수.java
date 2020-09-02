package baekjoon;

import java.util.Scanner;

public class 홀수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<7; i++){
            int value = scanner.nextInt();
            if(value % 2 == 1){
                sum+=value;
                if(min > value) min = value;
            }
        }
        if(sum == 0) System.out.print(-1);
        else{
            System.out.println(sum);
            System.out.print(min);
        }
    }
}
