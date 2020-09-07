package baekjoon;

import java.util.Scanner;

public class 저항 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        builder.append(color(scanner.next()));
        builder.append(color(scanner.next()));
        long num = Long.parseLong(builder.toString()) * (long) Math.pow(10, color(scanner.next()));
        System.out.print(num);
    }

    private static int color(String color) {
        int num = -1;
        switch (color) {
            case "black":
                num = 0;
                break;
            case "brown":
                num = 1;
                break;
            case "red":
                num = 2;
                break;
            case "orange":
                num = 3;
                break;
            case "yellow":
                num = 4;
                break;
            case "green":
                num = 5;
                break;
            case "blue":
                num = 6;
                break;
            case "violet":
                num = 7;
                break;
            case "grey":
                num = 8;
                break;
            case "white":
                num = 9;
        }
        return num;
    }
}
