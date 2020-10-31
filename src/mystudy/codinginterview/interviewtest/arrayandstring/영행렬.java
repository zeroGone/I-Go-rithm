package mystudy.codinginterview.interviewtset.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 138p 1.9
 * 문제 : M X N 행렬이 있다. 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열을 모든 원소들을 0으로 바꾸어라
 * */
public class 영행렬 {
	
	public static void main(String[] args) {
		영행렬 main = new 영행렬();
		System.out.println(Arrays.deepToString(main.solution(new int[][] {
			{123,5,6,7,1},
			{1, 123,3,5,7},
			{1,0,3,4,5},
			{2,2,2,2,0},
			{5,5,55,5,5}
		})));
	}
	
	public int[][] solution(int[][] matrix){
		List<Integer[]> zeroList = searchZero(matrix);
		
		for(Integer[] zeroIndex : zeroList) {
			toZeroMatrix(matrix, zeroIndex[0], zeroIndex[1]);
		}
		
		return matrix;
	}
	
	private void toZeroMatrix(int[][] matrix, int y, int x) {
		for(int i=0; i<matrix[y].length; i++) {
			matrix[y][i] = 0;
		}
		
		for(int i=0; i<matrix.length; i++) {
			matrix[i][x] = 0;
		}
	}
	
	private List<Integer[]> searchZero(int[][] matrix){
		List<Integer[]> zeroList = new ArrayList<>();

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(matrix[i][j]==0) {
					zeroList.add(new Integer[] {i,j});
				}
			}
		}
		
		return zeroList;
	}
}
