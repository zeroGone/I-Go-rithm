package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ABC {

    static int[] array = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = reader.readLine().split(" ");
        array[0] = Integer.parseInt(temp[0]);
        array[1] = Integer.parseInt(temp[1]);
        array[2] = Integer.parseInt(temp[2]);

        if (array[0] > array[1]) swap(0, 1);
        if (array[0] > array[2]) swap(0, 2);
        if (array[1] > array[2]) swap(1, 2);

        String str = reader.readLine();

        for (int i = 0; i < 3; i++) {
            if (str.charAt(i) == 'A') {
                System.out.print(array[0] + " ");
            } else if (str.charAt(i) == 'B') {
                System.out.print(array[1] + " ");
            } else {
                System.out.print(array[2] + " ");
            }
        }
    }

    static void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
