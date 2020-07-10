package programmers;

public class 최대공약수와최대공배수 {
    public int[] solution(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);

        int[] answer = new int[2];
        for(int i = 1; i<= min; i++){
            if( min % i == 0 && max % i == 0) answer[0] = i;
        }

        answer[1] = answer[0] * (min / answer[0]) * (max / answer[0]);
        return answer;
    }
}
