package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 가운데를말해요 {
    private static final Queue<Integer> minValues = new PriorityQueue<>(Collections.reverseOrder());
    private static final Queue<Integer> maxValues = new PriorityQueue<>();

    private static int minValuesNumber = 0;
    private static int maxValuesNumber = 0;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            StringBuilder outputBuilder = new StringBuilder();
            for (int number = 1; number <= N; number += 1) {
                add(Integer.parseInt(reader.readLine()));
                setBalance();
                outputBuilder.append(minValues.peek()).append("\n");
            }

            System.out.print(outputBuilder.deleteCharAt(outputBuilder.length() - 1).toString());
        }
    }

    private static void add(int value) {
        if (isValuesEvenNumber()) {
            minValues.offer(value);
            minValuesNumber += 1;
        } else {
            maxValues.offer(value);
            maxValuesNumber += 1;
        }
    }

    private static void setBalance() {
        if (minValues.isEmpty() || maxValues.isEmpty()) {
            return;
        }

        if (minValues.peek() > maxValues.peek()) {
            int maxValue = minValues.poll();
            int minValue = maxValues.poll();

            minValues.offer(minValue);
            maxValues.offer(maxValue);
        }
    }

    private static boolean isValuesEvenNumber() {
        return (minValuesNumber + maxValuesNumber) % 2 == 0;
    }
}
