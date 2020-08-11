package baekjoon;

import java.util.Scanner;

public class 상근날드 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] menu = new int[5];
        for(int i=0; i<5; i++){
            menu[i] = scanner.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<=2; i++){
            for(int j=3; j<=4; j++){
                int price = menu[i] + menu[j] - 50;
                if(min > price) min = price;
            }
        }

        System.out.println(min);
    }
}
