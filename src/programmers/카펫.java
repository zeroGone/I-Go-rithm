package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카펫 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 카펫().solution(5000, 2000000)));
        System.out.println(Arrays.toString(new 카펫().solution(8, 1)));
        System.out.println(Arrays.toString(new 카펫().solution(10, 2)));
        System.out.println(Arrays.toString(new 카펫().solution(24, 24)));

    }

    public int[] solution(int brown, int yellow) {
        int h = 1;
        List<Integer> height = new ArrayList<>();
        List<Integer> width = new ArrayList<>();
        while(yellow / h >= h){
            if(yellow % h  == 0){
                height.add(h);
                width.add(yellow/h);
            }

            h ++;
        }

        int[] answer = new int[2];

        for(int i=0; i<height.size(); i++){
            h = height.get(i);
            int w = width.get(i);

            if(((w+2)*2 + h*2) == brown){
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }
        System.out.println(Arrays.toString(width.toArray()));
        System.out.println(Arrays.toString(height.toArray()));
        return answer;
    }
}
