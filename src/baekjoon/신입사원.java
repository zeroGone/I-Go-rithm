package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for (int a = 0; a < T; a++) {
            int N = Integer.parseInt(reader.readLine());
            int[][] employee = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                employee[j][0] = Integer.parseInt(st.nextToken());
                employee[j][1] = Integer.parseInt(st.nextToken());
            }


            Arrays.sort(employee, (o1, o2) -> o1[0] < o2[0] ? -1 : 1);

            int num = 1;

            int min = employee[0][1];
            for(int i=1; i<N; i++){
                if(min > employee[i][1]) {
                    num++;
                    min = employee[i][1];
                }
            }

            builder.append(num).append("\n");
        }

        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
