package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 소수찾기2 {
    public static void main(String[] args) {
        System.out.println(solution("7843"));
    }

    static List<Integer> list = new ArrayList<>();

    public static int solution(String numbers) {

        for(int i=1; i<numbers.length(); i++){
            comb(numbers, new boolean[numbers.length()], 0, numbers.length(), i);
        }
        perm(numbers, new boolean[numbers.length()], new StringBuilder(), 0);

        Collections.sort(list, Collections.reverseOrder());

        boolean[] check = new boolean[list.get(0)+1];

        for(int i=2; (i*i)<check.length; i++){
            if(!check[i]){
                for(int j = i*i; j< check.length; j+=i){
                    check[j] = true;
                }
            }
        }
        int answer = 0;

        for(int i=2; i<check.length; i++){
            if(!check[i] && list.contains(i)){
                System.out.println(i);
                answer++;
            }
        }
        return answer;
    }


    private static void perm(String numbers, boolean[] visit, StringBuilder builder, int depth){
        if(depth == numbers.length()){
            int value = Integer.parseInt(builder.toString());
            if(!list.contains(value)) list.add(value);
        }

        for(int i=0; i<numbers.length(); i++){
            if(!visit[i]){
                visit[i] = true;
                builder.append(numbers.charAt(i));
                perm(numbers, visit, builder, depth+1);
                builder.deleteCharAt(depth);
                visit[i] = false;
            }
        }
    }

    private static void comb(String numbers, boolean[] visit, int start, int n, int r){
        if(r == 0){
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<visit.length; i++){
                if(visit[i]) builder.append(numbers.charAt(i));
            }
            perm(builder.toString(), new boolean[numbers.length()], new StringBuilder(), 0);
        }
        for(int i=start; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                comb(numbers, visit, i+1, n, r-1);
                visit[i] = false;
            }
        }
    }
}
