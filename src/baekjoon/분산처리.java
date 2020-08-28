package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분산처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            b = b % 4 == 0 ? 4 : b % 4;
            a = (int)Math.pow(a, b) % 10;
            a = a == 0 ? 10 : a;
            builder.append(a).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
