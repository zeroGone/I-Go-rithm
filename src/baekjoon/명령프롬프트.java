package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String[] strings = new String[N];
        for(int i=0; i<N; i++) strings[i] = reader.readLine();

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<strings[0].length(); i++){
            boolean check = false;
            char c = strings[0].charAt(i);
            for(int j=1; j<N; j++){
                if(c != strings[j].charAt(i)){
                    check = true;
                    break;
                }
            }
            if(check) builder.append('?');
            else builder.append(c);
        }

        System.out.print(builder.toString());
    }
}
