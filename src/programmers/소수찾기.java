package programmers;

public class 소수찾기 {
    public static void main(String[] args) {

        System.out.println(solution( 200));
    }


    public static int solution(int n) {
        int answer = 0;
        boolean[] check = new boolean[n+1];

        for(int i = 2; i*i<=n; i++){
            if(!check[i]){
                for(int j = i*i; j<=n; j+=i){
                    check[j] = true;
                }
            }
        }

        for(int i=2; i<=n; i++){
            if(!check[i]) answer++;
        }

        return answer;
    }
}
