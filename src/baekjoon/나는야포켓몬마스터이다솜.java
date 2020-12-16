package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] NM = reader.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            Map<Integer, String> poketmonList = new HashMap<>();
            Map<String, Integer> poketmonMap = new HashMap<>();
            for (int number = 1; number <= N; number += 1) {
                String poketmon = reader.readLine();

                poketmonList.put(number, poketmon);
                poketmonMap.put(poketmon, number);
            }

            StringBuilder outputBuilder = new StringBuilder();
            for (int number = 1; number <= M; number += 1) {
                String question = reader.readLine();

                try {
                    int poketmonNumber = Integer.parseInt(question);
                    outputBuilder.append(poketmonList.get(poketmonNumber)).append("\n");
                } catch (NumberFormatException numberFormatException) {
                    outputBuilder.append(poketmonMap.get(question)).append("\n");
                }
            }
            System.out.print(outputBuilder.deleteCharAt(outputBuilder.length() - 1).toString());
        }
    }
}