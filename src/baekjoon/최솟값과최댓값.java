package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최솟값과최댓값 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int N = Integer.parseInt(stringTokenizer.nextToken());
            int M = Integer.parseInt(stringTokenizer.nextToken());

            int[] numbers = new int[N];
            for (int index = 0; index < N; index += 1) {
                numbers[index] = Integer.parseInt(reader.readLine());
            }

            Segment minSegmentTree = makeSegmentTree(true, numbers, 0, N - 1);
            Segment maxSegmentTree = makeSegmentTree(false, numbers, 0, N - 1);

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < M; i++) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(stringTokenizer.nextToken()) - 1;
                int b = Integer.parseInt(stringTokenizer.nextToken()) - 1;

                int min = getValue(true, minSegmentTree, a, b);
                int max = getValue(false, maxSegmentTree, a, b);

                builder.append(min).append(" ").append(max).append("\n");
            }

            System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
        }
    }

    private static int getValue(boolean isMin, Segment segment, int start, int end) {
        if (segment.end < start || segment.start > end) {
            if (isMin) {
                return Integer.MAX_VALUE;
            } else {
                return -Integer.MAX_VALUE;
            }
        }
        if (segment.start == start && segment.end == end) {
            return segment.value;
        }

        int middle = (segment.start + segment.end) / 2;

        if (middle < start) {
            return getValue(isMin, segment.right, start, end);
        }
        if (middle > end) {
            return getValue(isMin, segment.left, start, end);
        }

        if (isMin) {
            return Math.min(getValue(isMin, segment.left, start, middle), getValue(isMin, segment.right, middle + 1, end));
        } else {
            return Math.max(getValue(isMin, segment.left, start, middle), getValue(isMin, segment.right, middle + 1, end));
        }
    }

    private static Segment makeSegmentTree(boolean isMin, int[] numbers, int start, int end) {
        if (start >= end) {
            Segment segment = new Segment(start, start);
            segment.value = numbers[start];
            return segment;
        }

        Segment segment = new Segment(start, end);

        int middle = (start + end) / 2;
        Segment left = makeSegmentTree(isMin, numbers, start, middle);
        Segment right = makeSegmentTree(isMin, numbers, middle + 1, end);

        segment.left = left;
        segment.right = right;

        if (isMin) {
            segment.value = Math.min(left.value, right.value);
        } else {
            segment.value = Math.max(left.value, right.value);
        }

        return segment;
    }

    static class Segment {
        int start;
        int end;
        int value;
        Segment left;
        Segment right;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}