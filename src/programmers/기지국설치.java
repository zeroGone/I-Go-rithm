package programmers;

public class 기지국설치 {
    public static void main(String[] args) {
        System.out.println(new 기지국설치().solution(11, new int[]{4, 11}, 1));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int index = 1;
        int station = 0;

        while (index <= n) {
            if (station < stations.length && index >= stations[station] - w) {
                index = stations[station] + w + 1;
                station++;
            } else {
                index += w * 2 + 1;
                answer += 1;
            }
        }
        return answer;
    }
}