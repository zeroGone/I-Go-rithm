package programmers;

public class 최댓값과최솟값 {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        String[] strings = s.split(" ");
        for(String string : strings){
            int value = Integer.parseInt(string);
            if(value < min) min = value;
            if(value > max) max = value;
        }
        return min+" "+max;
    }
}
