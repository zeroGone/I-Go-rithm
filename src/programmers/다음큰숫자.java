package programmers;

public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(new 다음큰숫자().solution(78));
    }

    public int solution(int n) {

        int answer = 0;
        int num = check(n, 0);
        for(int i = n+1; i<=1000000; i++){
            int temp = check(i, 0);
            if(num == temp){
                answer = i;
                break;
            }
        }
        return answer;
    }

    private int check(int n, int num){
        if(n % 2 == 1) num++;

        if( n / 2 == 0 ) return num;

        return check(n/2, num);
    }

}
