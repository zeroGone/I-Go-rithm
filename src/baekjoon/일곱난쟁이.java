package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 일곱난쟁이 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] heights = new int[9];

        List<Integer> dwarf = new ArrayList<>();

        for(int i=0; i<heights.length; i++){
            heights[i] = Integer.parseInt(reader.readLine());
            dwarf.add(heights[i]);
        }

        loop:
        for(int i=0; i<heights.length; i++){
            for(int j=i+1; j<heights.length; j++){

                int sum = 0;

                for(int index = 0; index<heights.length; index++){
                    if(index != i && index != j){
                        sum+=heights[index];
                    }
                }

                if(sum == 100){
                    dwarf.remove(j);
                    dwarf.remove(i);
                    break loop;
                }
            }
        }

        Collections.sort(dwarf);

        for (int d : dwarf){
            System.out.println(d);
        }

    }


}
