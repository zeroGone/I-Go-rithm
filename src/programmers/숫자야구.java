package programmers;


import java.util.ArrayList;
import java.util.List;

public class 숫자야구 {
    public static void main(String[] args) {
        int[][] b = new int[][]{
                {123, 1, 1},
                {356, 1, 0},
                {327, 2, 0},
                {489, 0, 1},
                {987, 0, 0}
        };

        System.out.println(new 숫자야구().solution(b));

    }

    public int solution(int[][] baseball) {
        boolean[] check = new boolean[987 - 123 + 1];
        for(int i=123; i<=987; i++){
            if(i%10 == 0 || i/10%10 ==0) check[i] = true;
            else if(i/100 == i/10%10) check[i] = true;
            else if(i/100 == i%10) check[i] = true;
            else if(i/10%10 == i%10) check[i] = true;
        }

        for (int i = 0; i < baseball.length; i++) {
            int num = baseball[i][0];
            int strike = baseball[i][1];
            int ball = baseball[i][2];
            for (int n = 123; n <= 987; n++) {
                if(check[n-123]) continue;
                int[] temp = check(num, n);
                if (strike != temp[0] || ball != temp[1]) check[n - 123] = true;
            }

        }
        int answer = 0;
        for (boolean b : check) if (!b) answer++;
        return answer;
    }

    private int[] check(int num1, int num2) {
        int[] answer = new int[2];
        int h1 = num1 / 100;
        int t1 = num1 / 10 % 10;
        int o1 = num1 % 10;
        int h2 = num2 / 100;
        int t2 = num2 / 10 % 10;
        int o2 = num2 % 10;
        if (h1 == h2) answer[0]++;
        if (h1 == t2 || h1 == o2) answer[1]++;
        if (t1 == t2) answer[0]++;
        if (t1 == h2 || t1 == o2) answer[1]++;
        if (o1 == o2) answer[0]++;
        if (o1 == h2 || o1 == t2) answer[1]++;
        return answer;
    }
}
