package programmers;

import java.util.ArrayList;
import java.util.List;

public class 단체사진찍기 {

    public static void main(String[] args) {
        System.out.println(new 단체사진찍기().solution(0, new String[]{
                "N~F=0", "R~T>2"
        }));

        System.out.println(new 단체사진찍기().solution(0, new String[]{
                "M~C<2", "C~M>1"
        }));
    }

    List<String> list = new ArrayList<>();
    public int solution(int n, String[] data) {
        char[] arr = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        permutation(arr, 0, 8);

        int answer = 0;

        for(String string : list){
            boolean check = true;

            for(String d : data){
                char c = d.charAt(3);
                int result = Math.abs(string.indexOf( d.charAt(0)) - string.indexOf(d.charAt(2)));
                int distance = d.charAt(4) - 47;

                if(c == '=' && result != distance){
                    check = false;
                    break;
                }else if(c == '<' && result >= distance){
                    check = false;
                    break;
                }else if(c == '>' && result <= distance){
                    check = false;
                    break;
                }
            }

            if(check){
                answer++;
            }
        }

        return answer;
    }

    void permutation(char[] arr, int depth, int r) {
        if (depth == r) {
            StringBuilder builder = new StringBuilder();
            for(char c : arr) builder.append(c);
            list.add(builder.toString());
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, r);
            swap(arr, depth, i);
        }
    }

    void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

}
