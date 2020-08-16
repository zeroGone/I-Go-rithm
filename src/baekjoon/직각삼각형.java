package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        while(true){
            String[] input = reader.readLine().split(" ");
            int[] n = new int[3];

            boolean check = true;
            for(int i=0; i< input.length; i++){
                int value = Integer.parseInt(input[i]);
                if(value != 0) check = false;
                n[i] = value;
            }

            if(check) break;

            Arrays.sort(n);

            if(n[0]*n[0] + n[1]*n[1] == n[2]*n[2]) builder.append("right\n");
            else builder.append("wrong\n");
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
