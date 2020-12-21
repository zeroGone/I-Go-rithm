package programmers;

public class 풍선터트리기 {
    public static void main(String[] args) {
        System.out.println(new 풍선터트리기().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }

    public int solution(int[] a) {
        if (a.length <= 2) {
            return a.length;
        }

        int answer = 0;

        int leftMinValue = 1000000000;
        int rightMinValue = 1000000000;

        for (int index = 0; index < a.length; index += 1) {
            if (a[index] < leftMinValue) {
                answer += 1;
                leftMinValue = a[index];
            }

            if (a[a.length - index - 1] < rightMinValue) {
                answer += 1;
                rightMinValue = a[a.length - index - 1];
            }

            if (leftMinValue == rightMinValue) {
                break;
            }
        }

        if (leftMinValue == rightMinValue) {
            return answer - 1;
        } else {
            return answer;
        }
    }
}