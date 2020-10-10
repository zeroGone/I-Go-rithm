package mystudy.insertionsort;

import java.util.Arrays;

/*
삽입정렬
이미 정렬된 i개의 원소를 가진 배열에서 하나의 원소를 더하여 i+1개의 배열을 만드는 과정 반복
i+1번째의 원소를 i개의 원소를 가진 정렬된 배열에서 적당한 위치로 끼워넣음
버블정렬과 선택정렬은 N개의 배열에서 시작하지만
삽입정렬은 1개의 배열부터 시작
수행시간은 O(N^2)
*/
public class Main {

    static int[] array = {9, 1, 6, 8, 4, 3, 2, 0};

    public static void main(String[] args) {
        insertionSort();
    }

    //TODO : 외웠냐
    static void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int loc = i - 1;
            int newItem = array[i];
            while (loc >= 0 && newItem < array[loc]) {
                array[loc + 1] = array[loc];
                loc--;
            }

            array[loc + 1] = newItem;
            System.out.println(Arrays.toString(array));
        }
    }
}
