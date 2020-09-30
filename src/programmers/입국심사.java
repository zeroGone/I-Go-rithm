package programmers;


public class 입국심사 {
    public static void main(String[] args) {
//        int[] a = new int[100000];
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random() * 1000000000);
//        }
//        System.out.println(new 입국심사().solution(1000000000, a));

        System.out.println(new 입국심사().solution(6, new int[]{7,10}));
//        System.out.println(new 입국심사().solution(10, new int[]{2,3,4,5}));
    }

    public long solution(int n, int[] times) {
        long answer = 0;

        boolean[] check = new boolean[n];

        int pre = 0;
        check[pre] = true;
        answer+=times[pre];
        for (int i = 0; i < n; i++) {
            int min = -1;
            for (int j = 0; j < times.length; j++) {
                if(!check[j]){
                    if(min == -1 || times[min] > times[j]) min = j;
                }
            }
            int examineMin = Integer.MAX_VALUE;
            int examineMinIndex = -1;
            for (int j = 0; j < times.length; j++) {
                if(check[j]){
                    if(times[j] < examineMin){
                        examineMin = times[j];
                        examineMinIndex = j;
                    }
                }
            }

            int value = 0;
            int index = 0;

            if(examineMinIndex == -1){
                value = times[min];
                index = min;
            }else if(min == -1){
                value = examineMin;
                index = examineMinIndex;
            }else{
                if(times[min] < examineMin){
                    value = times[min];
                    index = min;
                }else{
                    value = examineMin;
                    index = examineMinIndex;
                }
            }

            System.out.println(value + " " +index);

            answer+=value;
            check[pre] = false;
            check[index] = true;
            pre = index;
        }

        return answer;
    }
}
