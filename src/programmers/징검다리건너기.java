package programmers;

public class 징검다리건너기 {
    public static void main(String[] args) {
        System.out.println(new 징검다리건너기().solution(new int[]{
                2, 4, 5, 3, 2, 1, 4, 2, 5, 1
        }, 3));
    }

    public int solution(int[] stones, int k) {
        int start = 1;
        int end = 200000000;
        int min = 0;

        while (start < end) {
            int middle = (start + end) / 2;

            int number = 0;
            boolean isCrossAble = true;

            for (int stone : stones) {
                if (stone < middle) {
                    if (++number == k) {
                        isCrossAble = false;
                        break;
                    }
                } else {
                    number = 0;
                }
            }

            if (isCrossAble) {
                if (min < middle) {
                    min = middle;
                }
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return min;
    }

//    public int solution(int[] stones, int k) {
//        int[] stonesArray = new int[k];
//        for (int index = 0; index < k; index += 1) {
//            stonesArray[index] = stones[index];
//        }
//
//        int recentMaxValue = solution(stones, 0, k - 1);
//        int min = recentMaxValue;
//
//        for (int index = k; index < stones.length; index += 1) {
//            int value = pop(stonesArray);
//            stonesArray[stonesArray.length - 1] = stones[index];
//
//            if (recentMaxValue == value) {
//                recentMaxValue = solution(stonesArray, 0, k - 1);
//
//                if (recentMaxValue < min) {
//                    min = recentMaxValue;
//                }
//            }
//        }
//
//        return min;
//    }
//
//    private int pop(int[] stones) {
//        int value = stones[0];
//        for (int index = 0; index < stones.length - 1; index += 1) {
//            stones[index] = stones[index + 1];
//        }
//        return value;
//    }
//
//    private int solution(int[] stones, int start, int end) {
//        if (start >= end) {
//            return stones[start];
//        }
//
//        int middle = (start + end) / 2;
//        return Math.max(solution(stones, start, middle), solution(stones, middle + 1, end));
//    }
}
