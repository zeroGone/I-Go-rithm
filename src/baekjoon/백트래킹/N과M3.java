package baekjoon.백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M3 {
    static BufferedWriter writer;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            solution(1, i , (i+1)+" ");
        }
        writer.flush();
        writer.close();
    }

    private static void solution(int num, int value, String output) throws IOException {
        if (num == M) writer.write(output.substring(0, output.length() - 1) + '\n');
        if (num >= M) return;

        for (int i = 0; i < N; i++) {
            solution(num+1, i,output + (i + 1) + " ");
        }
    }
}
