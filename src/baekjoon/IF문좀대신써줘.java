package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IF문좀대신써줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] limitName = new String[N];
        long[] limitValue = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            limitName[i] = st.nextToken();
            limitValue[i] = Long.parseLong(st.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            long input = Long.parseLong(reader.readLine());
            for (int j = 0; j < N; j++) {
                if(input<=limitValue[j]){
                    builder.append(limitName[j]).append("\n");
                    break;
                }
            }
        }

        System.out.print(builder.deleteCharAt(builder.length()-1).toString());
    }
}
