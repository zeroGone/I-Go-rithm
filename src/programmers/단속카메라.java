package programmers;

import java.util.Arrays;

public class 단속카메라 {

    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1]-o1[0] < o2[1]-o2[0]) return -1;
            else return 1;
        });

        int[] pre = routes[0];
        for(int i=1; i<routes.length; i++){
            if(!(routes[i][1] >= pre[1] && routes[i][0] <= pre[0])){
                answer++;
                pre = routes[i];
            }
        }
        System.out.println(Arrays.deepToString(routes));
        return answer;
    }
}
