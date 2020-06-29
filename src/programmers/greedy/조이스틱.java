package programmers.greedy;


public class 조이스틱 {
    public static void main(String[] args) {
        System.out.println(solution("JJAJAAAAAAAAAAJ"));
    }

    public static int solution(String name) {
        int sum = 0;
        int index = -1;
        int num = 0;
        int temp1 = -1;
        int temp2 = 0;
        for (int i = 0; i < name.length(); i++) {
            char v = name.charAt(i);
            if (v == 'A') {
                if (temp2 == 0) temp1 = i;
                temp2++;
            } else {
                if (num < temp2) {
                    index = temp1;
                    num = temp2;
                }
                temp2 = 0;
            }
            sum += Math.min((v - (int) 'A'), ((int) 'Z' - v) + 1);
        }

        int dist = 0;
        if (index == -1){
            dist = Integer.MAX_VALUE;
        }else if (index == 0 || (index + num - 1) == name.length() - 1) {
            dist = name.length() - (num + 1);
        } else dist = Math.min((index - 1) * 2 + (name.length()-1 - (index + num - 1)), (name.length()-1 - (index + num - 1)) * 2 + (index - 1));

        sum += Math.min(dist, name.length() - 1);

        return sum;
    }
}
