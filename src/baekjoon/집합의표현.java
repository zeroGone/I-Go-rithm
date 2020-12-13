package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {
    private static final int SUM_OPERATION = 0;
    private static final int VALIDATION = 1;

    private static int[] parentIndex;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());

            parentIndex = new int[n + 1];
            for (int number = 0; number <= n; number += 1) {
                parentIndex[number] = number;
            }

            StringBuilder output = new StringBuilder();

            for (int number = 1; number <= m; number += 1) {
                stringTokenizer = new StringTokenizer(reader.readLine());

                int operation = Integer.parseInt(stringTokenizer.nextToken());
                int a = Integer.parseInt(stringTokenizer.nextToken());
                int b = Integer.parseInt(stringTokenizer.nextToken());

                if (operation == SUM_OPERATION) {
                    makeSumSet(a, b);
                } else if (operation == VALIDATION) {
                    if (validateSameSet(a, b)) {
                        output.append("YES").append("\n");
                    } else {
                        output.append("NO").append("\n");
                    }
                }
            }

            System.out.print(output.deleteCharAt(output.length() - 1).toString());
        }
    }

    private static void makeSumSet(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        parentIndex[b] = a;
    }

    private static int findParent(int index) {
        if (parentIndex[index] == index) {
            return index;
        } else {
            return findParent(parentIndex[index]);
        }
    }

    private static boolean validateSameSet(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        return parentIndex[a] == parentIndex[b];
    }
}
