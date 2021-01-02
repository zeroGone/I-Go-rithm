package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCase = Integer.parseInt(reader.readLine());

            StringBuilder outputBuilder = new StringBuilder();

            for (int caseNumber = 1; caseNumber <= testCase; caseNumber += 1) {
                int n = Integer.parseInt(reader.readLine());

                Map<String, List<String>> clothes = new HashMap<>();

                for (int number = 1; number <= n; number += 1) {
                    String[] cloth = reader.readLine().split(" ");

                    if (!clothes.containsKey(cloth[1])) {
                        clothes.put(cloth[1], new ArrayList<>());
                    }
                    clothes.get(cloth[1]).add(cloth[0]);
                }

                int sum = 1;
                for (String s : clothes.keySet()) {
                    sum *= clothes.get(s).size() + 1;
                }
                outputBuilder.append(sum - 1).append("\n");
            }

            System.out.print(outputBuilder.deleteCharAt(outputBuilder.length() - 1).toString());
        }
    }
}