package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] array = new long[N];
        for (int i = 0; i < N; i++) array[i] = Long.parseLong(reader.readLine());
        Arrays.sort(array);

        int max = 0;
        long maxValue = array[0];
        int num = 1;
        for (int i = 1; i < N; i++) {
            if (array[i - 1] != array[i]) num = 1;
            else {
                if (max < ++num) {
                    max = num;
                    maxValue = array[i];
                }
            }
        }
        System.out.println(maxValue);
    }
}
