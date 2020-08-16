package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윷놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] nums = new int[3][4];

        for (int i = 0; i < 3; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                nums[i][j] = Integer.parseInt(line[j]);
            }
        }

        reader.close();
        char[] output = new char[3];
        for(int i=0; i<3; i++){
            int f = 0;
            for(int j=0; j<4; j++){
                if(nums[i][j] == 1) f++;
            }

            if(f == 0) output[i] = 'D';
            else if(f == 1) output[i] = 'C';
            else if(f == 2) output[i] = 'B';
            else if(f == 3) output[i] = 'A';
            else output[i] = 'E';
        }

        StringBuilder builder = new StringBuilder();
        for(char c : output){
            builder.append(c).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
