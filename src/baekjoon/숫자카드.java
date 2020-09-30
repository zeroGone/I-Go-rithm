package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] card = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());

        System.out.println(Arrays.toString(card));
        StringBuilder builder = new StringBuilder();
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = card.length - 1;

            while (start <= end) {
                int middleIndex = (end + start) / 2;
                int middle = card[middleIndex];

                if (middle > n) {
                    end = middleIndex - 1;
                } else if (middle < n) {
                    start = middleIndex + 1;
                } else {
                    break;
                }
            }

            builder.append(start <= end ? 1 : 0).append(" ");
        }

        System.out.print(builder.deleteCharAt(builder.length() - 1).toString());
    }
}
