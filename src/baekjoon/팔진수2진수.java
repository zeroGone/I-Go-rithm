package baekjoon;

import java.util.Scanner;

public class 팔진수2진수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if(input.equals("0")){
            System.out.print(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        String[] number = new String[]{
                "000", "001", "010", "011", "100", "101", "110", "111"
        };
        builder.append(number[input.charAt(0) - 48]);
        builder.delete(0, builder.indexOf("1"));

        for(int i=1; i<input.length(); i++)
            builder.append(number[input.charAt(i)-48]);

        System.out.print(builder.toString());
    }
}
