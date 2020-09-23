package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(new N으로표현().solution(9, 32000));
    }

    public int solution(int N, int number) {
        solution(N, number, 0, 0);
        return answer;
    }

    int answer = -1;

    private void solution(int N, int number, int count, int value){
        if(count < 9){
            if(value == number && (answer == -1 || answer > count)){
                answer = count;
                return;
            }

            int temp = N;
            for(int i=1; i<9-count; i++){
                solution(N, number, count + i, value+temp);
                solution(N, number, count + i, value-temp);
                solution(N, number, count + i, value*temp);
                solution(N, number, count + i, value/temp);
                temp = temp*10 + N;
            }
        }
    }
}
