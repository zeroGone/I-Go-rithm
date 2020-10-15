package programmers;

public class 최고의집합 {
    public int[] solution(int n, int s) {
        if(n > s){
            return new int[]{-1};
        }

        int[] answer = new int[2];

        int value = s/n;

        for(int i=0; i<n; i++){
            answer[i] = value;
        }

        int temp = s - (value * n);

        int index = n-1;

        while(temp > 0){
            answer[index--] += 1;

            temp--;

            if(index == 0){
                index = n-1;
            }
        }
        return answer;
    }
}
