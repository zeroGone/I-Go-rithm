package programmers;

public class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            int sum = i;
            for(int j = i+1; sum + j <= n; j++){
                sum += j;
            }

            if(sum == n) answer++;
        }
        return answer;
    }
}
