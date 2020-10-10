package mystudy.quicksort;

import java.util.Arrays;
import java.util.Random;

/*
 * 퀵정렬
 * 1. 배열에서 하나의 원소를 고른다. 선택된 원소를 Pivot 이라 한다.
 * 2. Pivot을 기준으로 Pivot 보다 작은 영역과 큰 영역을 분할하고 정렬한다.
 * 3. 정렬된 두 영역에서 피벗에 넣고 재귀로 반복한다.
 * 평균 수행시간 : O(NlogN), 최악 : O(N^2)
 * */

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; ++i) array[i] = random.nextInt(20);
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = partition(array, start, end);
            quickSort(array, start, middle - 1);
            quickSort(array, middle + 1, end);
        }
    }

    static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index1 = start - 1;

        for (int index2 = start; index2 < end; index2++) {
            if (array[index2] <= pivot) swap(array, ++index1, index2);
        }
        swap(array, ++index1, end);
        return index1;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
