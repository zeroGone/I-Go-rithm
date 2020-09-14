package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String string = "";

        while((string = reader.readLine()) != null) {
            int[] number = new int[4];
            for(int i=0; i<string.length(); i++){
                char c = string.charAt(i);
                if(Character.isUpperCase(c)) number[1]++;
                else if(Character.isLowerCase(c)) number[0]++;
                else if(Character.isDigit(c)) number[2]++;
                else number[3]++;
            }
            StringBuilder temp = new StringBuilder();
            for(int i=0; i<3; i++) temp.append(number[i]).append(" ");
            builder.append(temp.append(number[3]).toString()).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
