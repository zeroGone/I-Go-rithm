package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NotCuteCute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int num = 0;
        for(int i=0; i<N; i++){
            if(Integer.parseInt(reader.readLine()) == 1) num++;
        }

        if(num > N - num) System.out.print("Junhee is cute!");
        else System.out.print("Junhee is not cute!");
    }
}
