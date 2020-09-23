package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] wine = new int[N];
        for (int i = 0; i < wine.length; i++) wine[i] = Integer.parseInt(reader.readLine());

        int[] array = new int[N];

        if(N == 1) System.out.print(wine[0]);
        else if(N==2) System.out.println(wine[0]+wine[1]);
        else{
            array[0] = wine[0];
            array[1] = wine[0] + wine[1];

            array[2] = Math.max(Math.max(array[1], array[0] + wine[2]), wine[1] + wine[2]);

            for (int i = 3; i < N; i++) {
                array[i] = Math.max(Math.max(array[i - 1], array[i - 2] + wine[i]), array[i-3] + wine[i - 1] + wine[i]);
            }

            System.out.println(array[N-1]);
        }
    }

//    private static int dp(int[] wine, int index, int sum, int drink) {
//        if (index == -1) return sum;
//        if (drink == 2) return dp(wine, index - 1, sum, 0);
//        else return Math.max(dp(wine, index - 1, sum + wine[index], drink + 1), dp(wine, index - 1, sum, 0));
//    }

}
