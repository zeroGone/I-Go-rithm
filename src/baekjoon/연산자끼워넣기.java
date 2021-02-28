package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    private static int maxValue = -Integer.MAX_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            int[] values = new int[N];

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            for (int index = 0; index < N; index += 1) {
                values[index] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringTokenizer = new StringTokenizer(reader.readLine());
            int[] operators = new int[4];

            for (int index = 0; index < operators.length; index += 1) {
                operators[index] = Integer.parseInt(stringTokenizer.nextToken());
            }

            solution(values, operators, 0, values[0]);

            System.out.println(maxValue);
            System.out.print(minValue);
        }
    }

    private static void solution(int[] values, int[] operators, int valueIndex, int sum) {
        if (valueIndex + 1 >= values.length) {
            if (sum > maxValue) {
                maxValue = sum;
            }
            if (sum < minValue) {
                minValue = sum;
            }
            return;
        }

        for (int index = 0; index < operators.length; index += 1) {
            if (operators[index] > 0) {
                operators[index] -= 1;
                solution(values, operators, valueIndex + 1, Operator.calculate(sum, values[valueIndex + 1], index));
                operators[index] += 1;
            }
        }
    }

    enum Operator {
        PLUS(0),
        MINUS(1),
        MULTIPLY(2),
        DIVIDE(3);

        private final int value;

        Operator(int value) {
            this.value = value;
        }

        private static int calculate(int value1, int value2, int operatorValue) {
            if (MINUS.value == operatorValue) {
                return value1 - value2;
            }
            if (MULTIPLY.value == operatorValue) {
                return value1 * value2;
            }
            if (DIVIDE.value == operatorValue) {
                return value1 / value2;
            }
            return value1 + value2;
        }
    }
}
