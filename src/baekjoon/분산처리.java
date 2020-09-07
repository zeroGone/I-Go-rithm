package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분산처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            long value = (long) Math.pow(a, b);
            System.out.println(value);
            builder.append(value % 10 == 0 ? 10 : value % 10).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
