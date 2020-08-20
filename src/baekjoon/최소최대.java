package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최소최대 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String[] strings = reader.readLine().split(" ");
        long min = 1000001;
        long max = -1000001;
        for(String s : strings){
            long value = Long.parseLong(s);
            if(value < min) min = value;
            if(value > max) max = value;
        }

        System.out.print(min+" "+max);
    }
}
