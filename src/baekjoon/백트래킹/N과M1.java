package baekjoon.백트래킹;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M1 {
    static BufferedWriter writer;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            boolean[] check = new boolean[N];
            check[i] = true;
            solution(check, 1, (i + 1) + " ");
        }

        writer.flush();
        writer.close();
    }

    private static void solution(boolean[] check, int now, String output) throws IOException {
        if (now == M) writer.write(output.substring(0, output.length() - 1) + '\n');
        if (now >= M) return;

        for (int i = 0; i < N; i++) {
            if (!check[i]) {
                boolean[] c = new boolean[N];
                for(int j=0; j<N; j++) if(check[j]) c[j] = true;
                c[i] = true;
                solution(c, now + 1, output + (i + 1) + " ");
            }

        }
    }
}
