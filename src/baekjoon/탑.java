package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] top = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) top[i] = Integer.parseInt(st.nextToken());

        Stack<Top> stack = new Stack<>();
        int[] output = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            int value = top[i];

            while(!stack.isEmpty()){
                Top temp = stack.peek();
                if(value > temp.getValue()){
                    output[temp.getIndex()] = i+1;
                    stack.pop();
                }else{
                    break;
                }
            }

            stack.add(new Top(i, value));
        }

        StringBuilder builder = new StringBuilder();
        for(int i: output)
            builder.append(i+" ");


        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    static class Top {
        private final int index;
        private final int value;

        public Top(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
