package programmers;

//124나라의숫자
public class 나라의숫자 {
    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static String solution(int n) {
        if (n == 1) return "1";
        int[] number = new int[]{1, 2, 4};

        StringBuilder builder = new StringBuilder();
        builder.append(number[--n % 3]);

        while (n / 3 != 0) {
            n = n / 3 - 1;
            builder.insert(0, number[n % 3]);
        }

        return builder.toString();
    }
}
