package programmers;

public class N개의최소공배수 {

    public static void main(String[] args) {
        System.out.println(new N개의최소공배수().solution(new int[]{10,20,30}));
    }
    public int solution(int[] arr) {
        int pre = arr[0];
        for(int i=1; i<arr.length; i++){
            int max = Math.max(pre, arr[i]);
            int min = Math.min(pre, arr[i]);
            pre = max * min / gcd(max, min);
        }
        return pre;
    }

    private int gcd(int a, int b){
        return a % b == 0 ? b : gcd(b, a%b);
    }
}
