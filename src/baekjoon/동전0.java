package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        long K = Long.parseLong(s[1]);

        List<Long> coins = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            long value = Long.parseLong(reader.readLine());

            if (value <= K) coins.add(value);
        }

        int answer = 0;
        long sum = 0;
        for (int i = coins.size() - 1; i >= 0; i--) {
            long now = coins.get(i);
            while(sum + now <= K) {
                answer+=1;
                sum += now;
            }
        }

        System.out.println(answer);
    }
}
