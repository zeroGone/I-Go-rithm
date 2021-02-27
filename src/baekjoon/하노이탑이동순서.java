package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 하노이탑이동순서 {
    private static final List<int[]> moves = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        hanoi(N, 1, 2, 3);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(moves.size()).append("\n");

        for (int[] move : moves) {
            stringBuilder.append(move[0]).append(" ").append(move[1]).append("\n");
        }

        System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
    }

    private static void hanoi(int n, int from, int by, int to) {
        if (n == 1) {
            moves.add(new int[]{from, to});
        } else {
            hanoi(n - 1, from, to, by);
            moves.add(new int[]{from, to});
            hanoi(n - 1, by, from, to);
        }
    }
}
