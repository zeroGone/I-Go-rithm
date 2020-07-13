package programmers;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(new 멀쩡한사각형().solution(100000000, 90000009));
        System.out.println(new 멀쩡한사각형().solution(2, 5));
        System.out.println(new 멀쩡한사각형().solution(3, 3));
        System.out.println(new 멀쩡한사각형().solution(4, 12));

    }

    public long solution(int w, int h) {
        long sum = ((long) w * (long) h);
        if (w == h) {
            return sum - w;
        }

        int gcd = gcd(w, h);

        return sum - (w / gcd + h / gcd - 1);
    }

    public int gcd(int a,int b){
        if(a % b == 0)
            return b;
        return gcd(b,a%b);
    }
}
