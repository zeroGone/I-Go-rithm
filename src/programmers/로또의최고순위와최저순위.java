package programmers;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroNumber = (int) Arrays.stream(lottos).filter(lotto -> lotto == 0).count();
        int matchNumber = (int) Arrays.stream(lottos)
                .filter(lotto -> Arrays.stream(win_nums).filter(num -> num == lotto).findAny().isPresent())
                .count();

        return new int[]{getRank(matchNumber + zeroNumber), getRank(matchNumber)};
    }

    private int getRank(int matchNumber) {
        if (matchNumber == 6) {
            return 1;
        } else if (matchNumber == 5) {
            return 2;
        } else if (matchNumber == 4) {
            return 3;
        } else if (matchNumber == 3) {
            return 4;
        } else if (matchNumber == 2) {
            return 5;
        } else {
            return 6;
        }
    }
}

