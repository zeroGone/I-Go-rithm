package programmers;

import java.util.LinkedList;

public class 프린터 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));

    }

    public static int solution(int[] priorities, int location) {

        LinkedList<Integer> q = new LinkedList<>();

        for(int i=0; i<priorities.length; i++){
            q.add(i);
        }

        int answer = 0;
        while(!q.isEmpty()){
            int value = q.poll();

            boolean check = true;
            for(int i:q){
                if( priorities[value] < priorities[i]){
                    q.add(value);
                    check = false;
                    break;
                }
            }
            if (check ){
                answer++;
                if (value == location) break;
            }
        }

        return answer;
    }
}
