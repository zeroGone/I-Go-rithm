package programmers;

public class 네트워크 {

    public static void main(String[] args) {
        System.out.println(new 네트워크().solution(3, new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        }));
    }

    private boolean[] check;

    public int solution(int n, int[][] computers) {
        check = new boolean[n];
        int answer = 0;

        for(int i=0; i<computers.length; i++){
            if(!check[i]){
                answer++;
                check[i] = true;
                dfs(computers, i);

            }
        }
        return answer;
    }

    private void dfs(int[][] computers, int index){
        for(int i=0 ; i<computers[index].length; i++){
            if(computers[index][i] == 1 && !check[i]){
                check[i] = true;
                dfs(computers, i);
            }
        }
    }
}
