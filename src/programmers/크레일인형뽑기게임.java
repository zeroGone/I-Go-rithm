package programmers;


import java.util.Stack;

public class 크레일인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for(int i=0; i<board.length; i++){
                if(board[i][move-1] != 0){
                    if(!stack.isEmpty()){
                        int pop = stack.peek();
                        if(board[i][move-1] == pop){
                            stack.pop();
                            answer+=2;
                        }
                        else stack.add(board[i][move-1]);
                    }else stack.add(board[i][move-1]);
                    board[i][move-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}
