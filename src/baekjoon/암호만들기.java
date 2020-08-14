package baekjoon;

import java.io.*;
import java.util.Arrays;

public class 암호만들기 {
    static char[] chars;
    static BufferedWriter writer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");

        int L = Integer.parseInt(strings[0]);
        int C = Integer.parseInt(strings[1]);

        chars = new char[C];

        strings = reader.readLine().split(" ");
        for (int i = 0; i < C; i++) chars[i] = strings[i].charAt(0);
        Arrays.sort(chars);

        writer = new BufferedWriter(new OutputStreamWriter(System.out));


        solution("", L, C, 0);
        reader.close();
        writer.flush();
        writer.close();
    }

    private static void solution(String string, int L, int C, int index) throws IOException {
        if (string.length() == L && check(string)) writer.write(string + '\n');
        for (int i = index; i < C; i++) {
            solution(string + chars[i], L, C, i + 1);
        }
    }

    private static boolean check(String string) {
        boolean[] check = new boolean[3];

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') check[0] = true;
            else if (!check[1]) check[1] = true;
            else check[2] = true;
        }

        for (boolean c : check) if (!c) return false;
        return true;
    }
}
