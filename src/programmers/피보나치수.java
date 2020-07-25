package programmers;

public class 피보나치수 {
    public int solution(int n) {
        int[] check = new int[n + 1];
        check[1] = 1;
        check[2] = 1;
        for(int i=3; i<=n; i++){
            check[i] = (check[i-2] + check[i-1]) %1234567;
        }
        return check[n];
    }
}
