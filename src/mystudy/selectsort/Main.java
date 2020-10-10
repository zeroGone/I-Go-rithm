package mystudy.selectsort;

import java.util.Arrays;

/*
선택정렬
1. N 개의 원소를 가진 배열에서 가장 큰 원소를 찾는다
2. 가장 마지막 인덱스의 원소와 자리를 바꾼다
3. 가장 큰 원소는 자기 자리를 찾았으므로 신경 쓰지 않는다
4. 나머지 원소들로 같은 작업을 반복

수행 시간 : 모든 경우 O(n^2)
*/
public class Main {
    public static void main(String[] args) {
        int[] array = {9, 1, 6, 8, 4, 3, 2, 0};

        for(int i=array.length-1; i>=0; i--){
            int maxIndex = i;
            for(int j=0; j<i; j++){
                if(array[maxIndex]<array[j]) maxIndex=j;
            }

            int temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;

            System.out.println(Arrays.toString(array));
        }
    }
}
