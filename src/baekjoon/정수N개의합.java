package baekjoon;

public class 정수N개의합 {
    public long sum(int[] a) {
        return solution(a, 0, a.length - 1);
    }

    private long solution(int[] array, int start, int end) {
        if (start >= end) {
            return array[start];
        }

        int middle = (start + end) / 2;

        return solution(array, start, middle) + solution(array, middle + 1, end);
    }
}