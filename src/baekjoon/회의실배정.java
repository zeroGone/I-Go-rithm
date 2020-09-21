package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] conferences = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            conferences[i][0] = start;
            conferences[i][1] = end;
        }

        Arrays.sort(conferences, (o1, o2) -> {
            if (o1[1] > o2[1]) return 1;
            else if (o1[1] < o2[1]) return -1;
            else {
                if (o1[0] > o2[0]) return 1;
                else if (o1[0] < o2[0]) return -1;
                return 0;
            }
        });

        int num = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if(end<=conferences[i][0]){
                end = conferences[i][1];
                num++;
            }
        }
        System.out.print(num);
    }
}
