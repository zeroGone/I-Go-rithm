package Study.MergeSort;

/*
병합정렬
1. N개의 원소를 가진 배열을 반으로 나눈다
2. 전반부와 후반부를 정렬하여 병합한다
3. 전반부와 후반부를 정렬할때에도 반으로 나눈다음 정렬해서 병합한다 (재귀)
수행시간 : O(NlogN)
 */

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 1, 6, 8, 4, 3, 2, 0};
        mergeSort(array, 0, array.length-1 );
        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int[] array, int start, int end){
        if(start<end){
            int middle = (start+end)/2;
            mergeSort(array, start, middle);
            mergeSort(array, middle+1, end);
            merge(array, start, middle, end);
        }
    }

    //TODO : 외웠냐
    static void merge(int[] array, int start, int middle, int end){
        int index1 = start;
        int index2 = middle+1;

        int[] temp = new int[end - start + 1];
        int i = 0;
        while(index1 <= middle && index2 <= end){
            if(array[index1]<array[index2]) temp[i++]=array[index1++];
            else temp[i++]=array[index2++];
        }

        while (index1<=middle) temp[i++] = array[index1++];
        while (index2<=end) temp[i++] = array[index2++];

        for(i=0;i<temp.length; i++){
            array[start+i]=temp[i];
        }
    }
}
