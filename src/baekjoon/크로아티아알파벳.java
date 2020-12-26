package baekjoon;

import java.util.Scanner;

public class 크로아티아알파벳 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();
        int number = 0;
        int index = 0;

        while (index < word.length()) {
            number += 1;

            if (checkDZN(word, index)) {
                index += 3;
                continue;
            }

            if (checkCroatianAlphabet(word, index)) {
                index += 2;
            } else {
                index += 1;
            }
        }

        System.out.print(number);
    }

    private static boolean checkDZN(String word, int index) {
        if (index + 2 >= word.length()) {
            return false;
        }

        if (index + 1 >= word.length()) {
            return false;
        }

        String subString = word.substring(index, index + 3);
        return subString.equals(CroatianAlphabet.DZN.getValue());
    }

    private static boolean checkCroatianAlphabet(String word, int index) {
        if (index + 1 >= word.length()) {
            return false;
        }

        return CroatianAlphabet.isContain(word.substring(index, index + 2));
    }
}

enum CroatianAlphabet {
    CN("c="),
    CM("c-"),
    DZN("dz="),
    DM("d-"),
    LJ("lj"),
    NJ("nj"),
    SN("s="),
    ZN("z=");

    private final String value;

    CroatianAlphabet(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    static boolean isContain(String word) {
        for (CroatianAlphabet alphabet : CroatianAlphabet.values()) {
            if (alphabet.value.equals(word)) {
                return true;
            }
        }
        return false;
    }
}