package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 절댓값힙 {
    private static final int POP = 0;
    private static StringBuilder outputBuilder = new StringBuilder();
    private static Queue<Number> numbers = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            for (int operation = 0; operation < N; operation += 1) {
                int x = Integer.parseInt(reader.readLine());

                if (x == POP) {
                    if (numbers.isEmpty()) {
                        outputBuilder.append(0).append("\n");
                    } else {
                        outputBuilder.append(numbers.poll().getValue()).append("\n");
                    }
                } else {
                    numbers.add(new Number(x));
                }
            }

            System.out.print(outputBuilder.toString());
        }
    }
}

class Number implements Comparable<Number> {
    private final int value;
    private final int absoluteValue;

    public Number(int value) {
        this.value = value;
        absoluteValue = Math.abs(value);
    }

    public int getAbsoluteValue() {
        return absoluteValue;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Number o) {
        if (absoluteValue < o.getAbsoluteValue()) {
            return -1;
        } else if (absoluteValue > o.getAbsoluteValue()) {
            return 1;
        } else {
            return value - o.getValue();
        }
    }
}