package baekjoon;

import java.util.Scanner;

public class 연속구간 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        for (int number = 1; number <= 3; number += 1) {
            String word = scanner.next();

            int max = 0;
            char previousCharacter = ' ';
            int nowCharacterNumber = 0;

            for (int index = 0; index < word.length(); index += 1) {
                char numberCharacter = word.charAt(index);

                if (previousCharacter == numberCharacter) {
                    nowCharacterNumber += 1;
                } else {
                    if (max < nowCharacterNumber) {
                        max = nowCharacterNumber;
                    }
                    previousCharacter = numberCharacter;
                    nowCharacterNumber = 1;
                }
            }
            if (max < nowCharacterNumber) {
                max = nowCharacterNumber;
            }

            stringBuilder.append(max).append("\n");
        }

        System.out.print(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());
    }
}
