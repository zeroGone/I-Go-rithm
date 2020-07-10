package programmers;

public class 비밀지도 {

    private boolean check(int a, int b){
        if((a % 2 ==0)&&(b%2==0)||(a%2 == 1) && (b%2 == 1)) return true;
        else return false;
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            int a = arr1[i];
            int b = arr2[i];

            StringBuilder builder = new StringBuilder();
            while(a / 2 != 0 && b / 2 != 0){
                if(check(a, b)) builder.insert(0, " ");
                else builder.insert(0, "#");
                if(a != 0) a /= 2;
                if(b != 0) b /= 2;
            }

            answer[i] = builder.toString();
        }
        return answer;
    }
}
