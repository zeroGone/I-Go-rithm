package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AB5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while(true){
            String[] strings = reader.readLine().split(" ");
            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);

            if(A == 0 && B == 0 ) break;
            else{
                int sum = A+B;
                builder.append(sum+"\n");
            }
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
        reader.close();
    }
}
