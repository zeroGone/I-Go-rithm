package programmers.greedy;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;

        boolean[] reserver = new boolean[n];
        for (int i : reserve) reserver[i - 1] = true;

        for (int i = 0; i < lost.length; i++) {
            int loster = lost[i] - 1;

            if (reserver[loster])
                reserver[loster] = false;
            else if (loster - 1 >= 0 && reserver[loster - 1])
                reserver[loster - 1] = false;
            else if (loster + 1 < n && reserver[loster + 1]) {
                if (i + 1 < lost.length && (loster + 1 == (lost[i + 1] - 1))) answer--;
                else reserver[loster + 1] = false;
            } else answer--;
        }

        return answer;
    }
}
