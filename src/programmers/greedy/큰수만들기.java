package programmers.greedy;

public class 큰수만들기 {
    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
    }

    public static String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);
        int index;

        for(int i=0; i<k; i++){
            index = builder.length()-1;
            for(int j=0; j<index; j++){
                if(builder.charAt(j) < builder.charAt(j+1)){
                    index = j;
                    break;
                }
            }
            builder.deleteCharAt(index);
        }
        return builder.toString();
    }
}
