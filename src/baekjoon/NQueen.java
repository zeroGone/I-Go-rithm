package baekjoon;

import java.util.Scanner;

// TODO: 2020-05-10 다시 풀어볼것
public class NQueen {

    static int N;
    static boolean[] checkCol = new boolean[15];
    static boolean[] checkLeft = new boolean[30];
    static boolean[] checkRight = new boolean[30];
    static boolean[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        a = new boolean[N][N];
        System.out.println(calc(0));
    }

    static boolean check(int row, int col){
        if(checkCol[col]) return false;
        if(checkLeft[row+col]) return false;
        if(checkRight[row-col+N]) return false;
        return true;
    }

    static int calc(int row){
        if(row == N) return 1;
        int sum = 0;
        for(int col = 0; col<N; col++){
            if(check(row, col)){
                checkLeft[row+col] = true;
                checkRight[row-col+N] = true;
                checkCol[col] = true;
                a[row][col] = true;
                sum +=  calc(row+1);
                checkLeft[row+col] = false;
                checkRight[row-col+N] = false;
                checkCol[col] = false;
                a[row][col] = false;
            }
        }
        return sum;
    }
}
