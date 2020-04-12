package programmers;

import java.util.Arrays;

public class 전화번호목록 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"12","123","1235","567","88"}));
    }

    private static boolean check(Long small, Long big){
        String a = small.toString();
        String b = big.toString();
        System.out.println(a+" "+b);
        return b.substring(0,a.length()).equals(a);
    }

    public static boolean solution(String[] phone_book) {
        Long[] numbers = new Long[phone_book.length];
        for(int i=0; i<numbers.length; i++) numbers[i]=Long.parseLong(phone_book[i]);
        Arrays.sort(numbers);
        boolean answer = true;

        out:
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(check(numbers[i],numbers[j])){
                    answer = false;
                    break out;
                }
            }
        }

        return answer;
    }
}
