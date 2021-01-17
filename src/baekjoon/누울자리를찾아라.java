package baekjoon;

import java.util.Scanner;

public class 누울자리를찾아라 {
    private static final char LUGGAGE = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        String[] rooms = new String[N];
        for (int index = 0; index < N; index += 1) {
            rooms[index] = scanner.next();
        }

        int horizontal = 0;
        int vertical = 0;

        for (int index = 0; index < N; index += 1) {
            horizontal += getHorizontalNumber(rooms[index], 0, 0);
            vertical += getVerticalNumber(rooms, index, 0, 0);
        }
        System.out.print(horizontal + " " + vertical);
    }

    private static int getHorizontalNumber(String room, int index, int number) {
        if (index >= room.length()) {
            if (number >= 2) {
                return 1;
            } else {
                return 0;
            }
        }

        if (room.charAt(index) == '.') {
            return getHorizontalNumber(room, index + 1, number + 1);
        }

        if (number >= 2) {
            return getHorizontalNumber(room, index + 1, 0) + 1;
        } else {
            return getHorizontalNumber(room, index + 1, 0);
        }
    }

    private static int getVerticalNumber(String[] rooms, int horizontalIndex, int index, int number) {
        if (index >= rooms.length) {
            if (number >= 2) {
                return 1;
            } else {
                return 0;
            }
        }

        if (rooms[index].charAt(horizontalIndex) == '.') {
            return getVerticalNumber(rooms, horizontalIndex, index + 1, number + 1);
        }

        if (number >= 2) {
            return getVerticalNumber(rooms, horizontalIndex, index + 1, 0) + 1;
        } else {
            return getVerticalNumber(rooms, horizontalIndex, index + 1, 0);
        }
    }
}