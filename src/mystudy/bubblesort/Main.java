package mystudy.bubblesort;

import java.util.Arrays;

/*
 * 버블정렬
 * 가장 큰 수를 옮기는 방법이 다를 뿐 선택정렬과 비슷하다
 * N개의 원소를 가진 배열에서 이웃하는 원소들을 비교하여 바꾸어 나간다
 * 수행시간은 O(N^2)
 * */
public class Main {

    static int[] array = {9, 1, 6, 8, 4, 3, 2, 0};


    public static void main(String[] args) {
        bubbleSort();
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort() {
        for (int i = array.length-1; i>=0; i--){
            boolean sorted = true; // 정렬이 되어있을 때 불필요한 반복을 검사
            for(int j = 0; j<i; j++){
                if(array[j]>array[j+1]){
                    //swap
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    sorted = false;
                }
            }
            if(sorted) break;
        }
    }
}
