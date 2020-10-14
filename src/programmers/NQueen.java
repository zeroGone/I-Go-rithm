package programmers;

public class NQueen {
    public static void main(String[] args) {
        System.out.println(new NQueen().solution(5));
    }

    public int solution(int n) {
        return solution(new int[n][n], n-1);
    }

    private int solution(int[][] board, int index) {
        if (index == 0) {
            int number = 0;

            for (int horizonIndex = 0; horizonIndex < board[0].length; horizonIndex++) {
                if (board[index][horizonIndex] == 0) {
                    number ++;
                }
            }

            return number;
        }

        int answer = 0;

        for (int horizonIndex = 0; horizonIndex < board[0].length; horizonIndex++) {
            if (board[index][horizonIndex] == 0) {
                attackAreaOfQueen(board, index, horizonIndex, true);
                answer += solution(board, index - 1);
                attackAreaOfQueen(board, index, horizonIndex, false);
            }
        }

        return answer;
    }

    private void attackAreaOfQueen(int[][] board, int index, int horizonIndex, boolean value) {
        if(value){
            board[index][horizonIndex]++;
        }else if(board[index][horizonIndex] != 0){
            board[index][horizonIndex]--;
        }

        int left = horizonIndex;
        int right = horizonIndex;

        while (index > 0) {
            index--;

            if(value){
                board[index][horizonIndex]++;
            }else if(board[index][horizonIndex] != 0){
                board[index][horizonIndex]--;
            }

            if (left > 0) {
                left--;
                if(value){
                    board[index][left]++;
                }else if(board[index][left] != 0){
                    board[index][left]--;
                }
            }

            if (right < board.length - 1) {
                right++;
                if(value){
                    board[index][right]++;
                }else if(board[index][right] != 0){
                    board[index][right]--;
                }
            }
        }
    }
}
