package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {
    private static final int UPDATE = 1;

    private static Part segmentTree;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());

            int[] numbers = new int[N];
            for (int index = 0; index < N; index++) {
                numbers[index] = Integer.parseInt(reader.readLine());
            }

            segmentTree = makeSegmentTree(numbers, 0, numbers.length - 1);

            StringBuilder outputBuilder = new StringBuilder();
            for (int number = 1; number <= M + K; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

                if (a == UPDATE) {
                    update(segmentTree, b, Long.parseLong(stringTokenizer.nextToken()));
                } else {
                    outputBuilder.append(sum(segmentTree, b, Integer.parseInt(stringTokenizer.nextToken()) - 1)).append('\n');
                }
            }

            System.out.print(outputBuilder.deleteCharAt(outputBuilder.length() - 1).toString());
        }
    }

    private static Part makeSegmentTree(int[] values, int start, int end) {
        if (start >= end) {
            return new Part(start, start, values[start]);
        }

        int middle = (start + end) / 2;

        Part left = makeSegmentTree(values, start, middle);
        Part right = makeSegmentTree(values, middle + 1, end);

        return new Part(start, end, left.sum + right.sum, left, right);
    }

    private static void update(Part part, int number, long value) {
        if (part.start == number && part.end == number) {
            part.sum = value;
            return;
        }

        int middle = (part.start + part.end) / 2;

        if (middle >= number) {
            update(part.left, number, value);
        } else {
            update(part.right, number, value);
        }

        part.sum = part.left.sum + part.right.sum;
    }

    private static long sum(Part part, int start, int end) {
        if (part.start > end || part.end < start) {
            return 0;
        }

        if (part.start == start && part.end == end) {
            return part.sum;
        }

        int middle = (part.start + part.end) / 2;

        if (middle > end) {
            return sum(part.left, start, end);
        }

        if (middle < start) {
            return sum(part.right, start, end);
        }

        return sum(part.left, start, middle) + sum(part.right, middle + 1, end);
    }

    static class Part {
        int start;
        int end;
        long sum;
        Part left;
        Part right;

        Part(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        Part(int start, int end, long sum, Part left, Part right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }
}