package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나는요리사다 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] score = new int[5];
        for (int i = 0; i < 5; i++) {
            String[] strings = reader.readLine().split(" ");
            for (int j = 0; j < 4; j++) score[i] += Integer.parseInt(strings[j]);
        }

        int index = 0;
        for (int i = 1; i < 5; i++) {
            if (score[index] < score[i]) index = i;
        }

        System.out.print(index+1 + " " + score[index]);
    }
}
