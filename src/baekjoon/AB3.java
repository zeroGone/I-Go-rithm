package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AB3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<T; i++){
            String[] strings = reader.readLine().split(" ");
            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);
            int sum = A+B;
            builder.append(sum+"\n");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
