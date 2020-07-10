package programmers;

public class 하샤드수 {
    public boolean solution(int x) {
        int num = x;
        int sum = num % 10;
        while(num / 10 != 0){
            sum += num / 10 % 10;
            num/=10;
        }

        return x % sum == 0 ;
    }
}
