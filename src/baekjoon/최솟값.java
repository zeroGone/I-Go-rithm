package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[] values = new int[N];
            for (int index = 0; index < N; index += 1) {
                values[index] = Integer.parseInt(reader.readLine());
            }

            MinValue minValueTree = makeTree(values, 0, N - 1);

            StringBuilder outputBuilder = new StringBuilder();
            for (int number = 1; number <= M; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int min = getMin(minValueTree, Integer.parseInt(stringTokenizer.nextToken()) - 1, Integer.parseInt(stringTokenizer.nextToken()) - 1);

                outputBuilder.append(min).append("\n");
            }
            System.out.print(outputBuilder.deleteCharAt(outputBuilder.length()-1).toString());
        }
    }

    private static MinValue makeTree(int[] values, int start, int end) {
        if (start >= end) {
            MinValue minValue = new MinValue(start, start);
            minValue.value = values[start];
            return minValue;
        }

        MinValue minValue = new MinValue(start, end);

        int middle = (start + end) / 2;
        MinValue left = makeTree(values, start, middle);
        MinValue right = makeTree(values, middle + 1, end);

        minValue.value = Math.min(left.value, right.value);
        minValue.left = left;
        minValue.right = right;
        return minValue;
    }

    private static int getMin(MinValue value, int start, int end) {
        if (start > value.end || end < value.start) {
            return Integer.MAX_VALUE;
        }
        if (start == value.start && end == value.end) {
            return value.value;
        }

        int middle = (value.start + value.end) / 2;

        if (middle < start) {
            return getMin(value.right, start, end);
        }
        if (middle > end) {
            return getMin(value.left, start, end);
        }

        return Math.min(getMin(value.left, start, middle), getMin(value.right, middle + 1, end));
    }

    private static class MinValue {
        private final int start;
        private final int end;
        private int value;
        private MinValue left;
        private MinValue right;

        public MinValue(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}