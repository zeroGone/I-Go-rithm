package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 카드놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");

        int[] A = new int[strings.length];
        for(int i=0; i<strings.length; i++) A[i] = Integer.parseInt(strings[i]);

        int[] B = new int[strings.length];
        strings = reader.readLine().split(" ");
        for(int i=0; i<strings.length; i++) B[i] = Integer.parseInt(strings[i]);

        int result = 0;
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] > B[i]){
                sum1+=3;
                result = 1;
            }else if(A[i] < B[i]){
                sum2+=3;
                result = -1;
            } else{
                sum1++;
                sum2++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(sum1).append(" ").append(sum2).append("\n");
        if(result == 0) builder.append('D');
        else if(sum1 > sum2) builder.append('A');
        else if(sum1 < sum2) builder.append('B');
        else builder.append(result == 1 ? 'A' : 'B');

        System.out.print(builder.toString());
    }
}
