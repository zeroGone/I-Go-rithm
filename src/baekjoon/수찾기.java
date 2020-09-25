package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] num = new long[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for(int i=0; i<N; i++) num[i] = Long.parseLong(st.nextToken());
        Arrays.sort(num);

        StringBuilder builder = new StringBuilder();
        int M = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        for(int i=0; i<M; i++){
            long value = Long.parseLong(st.nextToken());
            builder.append(binearySearch(num, value, 0, N-1)).append("\n");
        }
        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }

    private static int binearySearch(long[] num, long value, int start, int end){
        if(start > end) return 0;

        int middle = (start+end)/2;

        long middleValue = num[middle];
        if(middleValue == value) return 1;
        else if(middleValue < value) return binearySearch(num, value, middle+1, end);
        else return binearySearch(num, value, start, middle-1);
    }
}
