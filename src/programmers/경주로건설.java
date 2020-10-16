package programmers;

import java.util.Arrays;
class 경주로건설 {
    public int solution(int[][] board) {
        costMap = new int[board.length][board.length];

        for(int index = 0; index < costMap.length; index++){
            Arrays.fill(costMap[index], Integer.MAX_VALUE);
        }

        dfs(board, 'd', 0, 0, 0);
        dfs(board, 's', 0, 0, 0);

        return costMap[board.length-1][board.length-1];
    }

    private int[][] costMap;

    private void dfs(int[][] board, char direction, int x, int y, int cost){
        if(cost > costMap[y][x]){
            return;
        }

        costMap[y][x] = cost;
        if(x == board.length - 1 && y == board.length - 1){
            return;
        }

        if(x + 1 < board.length && board[y][x+1] != 1 && cost < costMap[y][x+1]){//오른쪽
            if(direction == 'd'){
                dfs(board, 'd', x+1, y, cost+100);
            }else{
                dfs(board, 'd', x+1, y, cost+600);
            }
        }

        if(y + 1 < board.length && board[y+1][x] != 1 && cost < costMap[y+1][x]){//아래
            if(direction == 's'){
                dfs(board, 's', x, y+1, cost+100);
            }else{
                dfs(board, 's', x, y+1, cost+600);
            }
        }

        if(x - 1 >= 0 && board[y][x-1] != 1 && cost < costMap[y][x-1]){//왼
            if(direction == 'a'){
                dfs(board, 'a', x-1, y, cost+100);
            }else{
                dfs(board, 'a', x-1, y, cost+600);
            }
        }

        if(y - 1 >= 0 && board[y-1][x] != 1 && cost < costMap[y-1][x]){//위
            if(direction == 'w'){
                dfs(board, 'w', x, y-1, cost+100);
            }else{
                dfs(board, 'w', x, y-1, cost+600);
            }
        }
    }
}
