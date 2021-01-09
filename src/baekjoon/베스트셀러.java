package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 베스트셀러 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        Map<String, Integer> books = new HashMap<>();

        for (int number = 1; number <= N; number += 1) {
            String book = scanner.next();

            if (books.containsKey(book)) {
                books.put(book, books.get(book) + 1);
            } else {
                books.put(book, 1);
            }
        }

        String answer = null;
        int maxNumber = 0;

        for (String book : books.keySet()) {
            if (books.get(book) > maxNumber) {
                answer = book;
                maxNumber = books.get(book);
            }
            if (books.get(book) == maxNumber && book.compareTo(answer) < 0) {
                answer = book;
            }
        }

        System.out.print(answer);
    }
}