package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 농구경기 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Map<Character, Integer> map = new HashMap<>();

            int N = Integer.parseInt(reader.readLine());
            for (int number = 1; number <= N; number += 1) {
                String string = reader.readLine();

                if (!map.containsKey(string.charAt(0))) {
                    map.put(string.charAt(0), 0);
                }
                map.put(string.charAt(0), map.get(string.charAt(0)) + 1);
            }

            List<Character> answer = new ArrayList<>();
            for (char character : map.keySet()) {
                if (map.get(character) >= 5) {
                    answer.add(character);
                }
            }

            if (answer.isEmpty()) {
                System.out.print("PREDAJA");
            } else {
                Collections.sort(answer);

                StringBuilder stringBuilder = new StringBuilder();
                for (char character : answer) {
                    stringBuilder.append(character);
                }
                System.out.print(stringBuilder.toString());
            }
        }
    }
}
