package programmers;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if( arr.length == 1 ) return new int[]{-1};


        int min = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[min] > arr[i]) min = i;
        }

        for(int i = min; i+1<arr.length; i++){
            arr[i] = arr[i+1];
        }

        int[] answer = new int[arr.length-1];

        for(int i=0; i<answer.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}
