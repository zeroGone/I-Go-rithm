package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long[] array = new long[101];
            array[1] = array[2] = array[3] = 1;

            for (int number = 4; number <= 100; number += 1) {
                array[number] = array[number - 2] + array[number - 3];
            }

            int T = Integer.parseInt(reader.readLine());

            StringBuilder stringBuilder = new StringBuilder();
            for (int number = 1; number <= T; number += 1) {
                stringBuilder.append(array[Integer.parseInt(reader.readLine())]).append("\n");
            }

            System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
        }
    }
}
