package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            Line[] lines = new Line[N];
            for (int index = 0; index < N; index += 1) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                lines[index] = new Line(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));
            }

            Arrays.sort(lines, Comparator.comparingInt(o -> o.start));

            int[] dp = new int[N];
            Arrays.fill(dp, 1);

            for (int startIndex = 0; startIndex < N; startIndex += 1) {
                for (int index = startIndex + 1; index < N; index += 1) {
                    if (lines[startIndex].target < lines[index].target) {
                        dp[index] = Math.max(dp[index], dp[startIndex] + 1);
                    }
                }
            }


            int max = 0;
            for (int maxLine : dp) {
                max = Math.max(max, maxLine);
            }

            System.out.print(N - max);
        }
    }

    static class Line {
        final int start;
        final int target;

        Line(int start, int target) {
            this.start = start;
            this.target = target;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "start=" + start +
                    ", target=" + target +
                    '}';
        }
    }
}
