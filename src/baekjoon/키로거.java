package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class 키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int cursor = 0;
            LinkedList<Character> list = new LinkedList<>();
            String input = reader.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if (c == '<') cursor--;
                else if (c == '>') cursor++;
                else if (c == '-') {
                    cursor--;
                    if(cursor > -1) list.remove(cursor);
                } else {
                    list.add(cursor, c);
                    cursor++;
                }

                if(cursor < 0) cursor = 0;
                else if(cursor > list.size()) cursor--;
            }

            for(Character c : list) output.append(c);
            output.append("\n");
        }
        System.out.print(output.deleteCharAt(output.length()-1).toString());
        reader.close();
    }
}
