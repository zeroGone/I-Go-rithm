package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new HashMap<>();

        int N = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            Long value = Long.parseLong(input[i]);
            if (map.containsKey(value)) map.put(value, map.get(value) + 1);
            else map.put(value, 1);
        }
        StringBuilder builder = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            Long value = Long.parseLong(input[i]);
            builder.append(map.getOrDefault(value, 0)).append(" ");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
