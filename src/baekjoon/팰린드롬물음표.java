package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 팰린드롬물음표 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());
            int[] values = new int[N];

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int index = 0; index < N; index += 1) {
                values[index] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int[][] palindromes = new int[N + 1][N + 1];

            for (int start = 0; start < N; start += 1) {
                for (int end = start + 1; end < N; end += 1) {
                    if (isPalindrome(values, start, end)) {
                        palindromes[start + 1][end + 1] = 1;
                    }
                }
                palindromes[start + 1][start + 1] = 1;
            }

            int M = Integer.parseInt(reader.readLine());
            StringBuilder stringBuilder = new StringBuilder();
            for (int number = 1; number <= M; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());
                stringBuilder.append(palindromes[a][b]).append("\n");
            }

            System.out.print(stringBuilder.toString());
        }
    }

    private static boolean isPalindrome(int[] values, int start, int end) {
        while (start < end) {
            if (values[start] != values[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
