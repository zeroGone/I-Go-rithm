package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 팰린드롬수 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder builder = new StringBuilder();

            String word = reader.readLine();
            while (!"0".equals(word)) {
                if (isPalindrome(word, 0, word.length() - 1)) {
                    builder.append("yes");
                } else {
                    builder.append("no");
                }
                builder.append("\n");
                word = reader.readLine();
            }
            System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
        }
    }

    private static boolean isPalindrome(String word, int left, int right) {
        if (left > right) {
            return true;
        }
        if (word.charAt(left) != word.charAt(right)) {
            return false;
        }
        return isPalindrome(word, left + 1, right - 1);
    }
}
