package programmers;

import java.util.Arrays;
import java.util.Comparator;

class 실패율 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 실패율().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3} )));
        System.out.println(Arrays.toString(new 실패율().solution(5, new int[]{4,4,4,4,4} )));

    }
    public int[] solution(int N, int[] stages) {
        Stage[] stage = new Stage[N];
        for(int i=0; i<N; i++){
            stage[i] = new Stage(i);
        }

        for(int i:stages){
            if(i <= N ) stage[i-1].addPlayer();
        }

        int sum = 0;
        for(Stage s : stage){
            s.setFail(stages.length - sum);
            sum += s.getPlayer();
        }

        Arrays.sort(stage, new Comparator<Stage>() {
            @Override
            public int compare(Stage s1, Stage s2) {
                if(s1.getFail() < s2.getFail()) return 1;
                else if(s1.getFail() > s2.getFail()) return -1;
                else return 0;
            }
        });

        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            answer[i] = stage[i].getIndex();
        }
        return answer;
    }

    class Stage{
        private int player;
        private int index;
        private double fail;

        public Stage(int index){
            this.index = index + 1;
            this.player = 0;
            this.fail = 0.0;
        }

        public void addPlayer(){
            this.player+=1;
        }

        public int getPlayer(){
            return this.player;
        }

        public void setFail(int player){
            this.fail = (double)this.player / player;
        }

        public double getFail(){
            return this.fail;
        }

        public int getIndex(){
            return this.index;
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "player=" + player +
                    ", index=" + index +
                    ", fail=" + fail +
                    '}';
        }
    }
}
