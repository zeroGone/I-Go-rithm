package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단어뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();

                for (int j = word.length() - 1; j >= 0; j--) {
                    builder.append(word.charAt(j));
                }

                builder.append(" ");
            }

            builder.append("\n");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
