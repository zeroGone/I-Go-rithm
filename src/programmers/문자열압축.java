package programmers;

import java.util.Arrays;

public class 문자열압축 {

    public static void main(String[] args) {
//        System.out.println(solution("aabbaccc"));
//        System.out.println(solution("abcabcdede"));
        System.out.println(solution("a"));

    }

    public static int solution(String s) {
        int answer = s.length() == 1 ? 1 : Integer.MAX_VALUE;

        for(int i=1; i<=s.length()/2; i++){

            int index = 0;
            String[] a = new String[s.length()%i==0 ? s.length()/i : s.length()/i +1];
            for(int j=0; j<s.length(); j+=i){
                if(j+i<s.length()) a[index++] = s.substring(j, j+i);
                else a[index++] = s.substring(j);
            }//

            index = 1;
            String pre = a[0];
            StringBuilder builder = new StringBuilder();
            for(int j=1; j<a.length; j++){
                String str = a[j];
                if(pre.equals(str)){
                    index ++;
                }else{
                    if(index == 1){
                        builder.append(pre);
                    }else{
                        builder.append(index +pre);
                        index = 1;
                    }
                }

                pre = str;
            }

            if(index == 1){
                builder.append(pre);
            }else{
                builder.append(index +pre);
            }

            if(builder.toString().length() < answer) answer = builder.toString().length();
        }
        return answer;
    }
}
