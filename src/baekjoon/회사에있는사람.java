package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<String> enter = new ArrayList<>();
        List<String> leave = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("enter")) enter.add(name);
            else leave.add(name);
        }
        reader.close();

        enter.sort(Collections.reverseOrder());
        leave.sort(Collections.reverseOrder());

        StringBuilder builder = new StringBuilder();
        int j = 0;
        for (int i = 0; i < enter.size(); i++) {
            String name = enter.get(i);
            if (j >= leave.size() || !name.equals(leave.get(j))) builder.append(name).append("\n");
            else  j++;
        }

        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
