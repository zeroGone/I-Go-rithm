package programmers;

public class 다트게임 {
    public int solution(String dartResult) {
        int[] score = new int[3];
        boolean[] star = new boolean[3];

        int index = -1;
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);

            if(Character.isDigit(c)){
                if(dartResult.charAt(i+1) == '0') {
                    score[++index] = 10;
                    i+=1;
                }
                else score[++index] = c - 48;
            }else{
                if(c == 'D'){
                    score[index] = (int)Math.pow(score[index], 2);
                }else if(c == 'T'){
                    score[index] = (int)Math.pow(score[index], 3);
                }else if(c == '#'){
                    score[index] = -score[index];
                }else if(c == '*'){
                    if(index == 0) score[0] = score[0] * 2;
                    else{
                        score[index] = score[index] *= 2;
                        score[index-1] = score[index-1] *= 2;
                    }
                    star[index] = true;
                }
            }
        }

        int answer = 0;
        for(int i: score) answer+=i;
        return answer;
    }
}
