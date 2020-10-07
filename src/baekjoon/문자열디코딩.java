package baekjoon;

public class 문자열디코딩 {
    public static void main(String[] args) {
        System.out.println(new 문자열디코딩().solution("ABCDEFG"));
        System.out.println(new 문자열디코딩().solution("A1B10C2D4EFG5"));
    }

    public String solution(String s){
        return solution(s, 1, new StringBuilder(), new StringBuilder(), s.charAt(0));
    }

    public String solution(String s, int index, StringBuilder builder, StringBuilder number, char pre){
        if(index == s.length()){
            builder.append(numberFormat(pre, number));
            return builder.toString();
        }

        char c = s.charAt(index);
        if(Character.isDigit(c)) number.append(c);
        else{
            builder.append(numberFormat(pre, number));
            number.delete(0, number.length());
            pre = c;
        }

        return solution(s, index+1, builder, number, pre);
    }

    public String numberFormat(char c, StringBuilder number){
        String s = number.toString();
        if(s.length() == 0) return Character.toString(c);
        else{
            StringBuilder builder = new StringBuilder();
            int n = Integer.parseInt(s);
            for(int i=0; i<n; i++) builder.append(c);
            return builder.toString();
        }
    }
}

