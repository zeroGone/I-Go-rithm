package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean[] array = new boolean[2000001];

            int N = Integer.parseInt(reader.readLine());

            for (int number = 1; number <= N; number += 1) {
                int value = Integer.parseInt(reader.readLine());

                if (value < 0) {
                    value = -value + 1000000;
                }

                array[value] = true;
            }

            StringBuilder builder = new StringBuilder();

            for (int index = array.length - 1; index > 1000000; index -= 1) {
                if (array[index]) {
                    builder.append(-(index - 1000000)).append("\n");
                }
            }

            for (int index = 0; index <= 1000000; index += 1) {
                if (array[index]) {
                    builder.append(index).append("\n");
                }
            }

            System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
        }
    }
}
