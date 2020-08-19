package baekjoon;

import java.util.Scanner;

public class 에라토스테네스의체 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        boolean[] check = new boolean[N+1];
        check[0] = true;
        check[1] = true;

        int num = 0;

        che:
        while(true){
            boolean b = true;
            for(int i=2; i<=N; i++){
                if(!check[i]){
                    b = false;
                    for(int j=i; j<=N; j+=i){
                        if(!check[j]){
                            num++;
                            check[j] = true;

                            if(num == K) {
                                num = j;
                                break che;
                            }
                        }
                    }
                }
            }

            if(b) break;
        }

        System.out.print(num);
    }
}
