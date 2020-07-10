package programmers;

public class 콜라츠추측 {
    public static void main(String[] args) {
        System.out.println(new 콜라츠추측().solution(626331));
    }
    public int solution(int num) {
        int answer = 0;
        long n = num;
        while(n != 1 && answer < 500){
            if(n % 2 ==0) n/=2;
            else n = n * 3 +1;
            answer++;
        }
        return answer < 500 ? answer : -1;
    }
}
