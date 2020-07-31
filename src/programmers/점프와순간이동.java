package programmers;

public class 점프와순간이동 {
    public static void main(String[] args) {
        System.out.println(new 점프와순간이동().solution(5000));
    }

    public int solution(int n) {
        int num = 0;
        while(n != 0){
            if(n%2 == 0) n/=2;
            else{
                num++;
                n-=1;
            }
        }
        return num;
    }
}
