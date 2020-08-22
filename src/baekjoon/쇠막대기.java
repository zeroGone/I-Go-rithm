package baekjoon;

import java.util.Scanner;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char pre = input.charAt(0);
        int stick = 1;
        int sum = 0;
        for (int i = 1; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '(')
                stick++;
            else {
                stick--;
                sum += pre == '(' ? stick : 1;
            }
            pre = now;
        }

        System.out.print(sum);
    }
}
