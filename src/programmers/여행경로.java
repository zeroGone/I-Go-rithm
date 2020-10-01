package programmers;

import java.util.*;
public class 여행경로 {
    public static void main (String[] args){
        System.out.println(Arrays.toString(new 여행경로().solution(new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
        })));
        System.out.println(Arrays.toString(new 여행경로().solution(new String[][]{
                {"ICN", "A"}, {"ICN", "A"}, {"A", "ICN"}
        })));
//
        System.out.println(Arrays.toString(new 여행경로().solution(new String[][]{
                {"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}
        })));

        System.out.println(Arrays.toString(new 여행경로().solution(new String[][]{
                { "ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
        })));

    }

    public String[] solution(String[][] tickets) {
        Map<String, Edge> map = new HashMap<>();
        for(int i=0; i<tickets.length; i++){
            String[] ticket = tickets[i];
            if(map.containsKey(ticket[0])){
                map.get(ticket[0]).addVertex(ticket[1]);
            }else{
                Edge edge = new Edge();
                edge.addVertex(ticket[1]);
                map.put(ticket[0], edge);
            }
        }
        size = tickets.length;

        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs(map, "ICN", 0, list);

        String[] ans = new String[answer.size()];
        for(int i=0; i<ans.length; i++) ans[i] = answer.get(i);
        return ans;
    }

    List<String> answer;
    int size;
    private void dfs(Map<String, Edge> map, String start, int depth, List<String> list){
        if(size == depth){
            if(answer != null){
                for(int i=0; i<list.size(); i++){
                    int compare = answer.get(i).compareTo(list.get(i));
                    if (compare < 0) break;
                    else if (compare > 0){
                        answer = list;
                        break;
                    }
                }
            }else {
                answer = list;
            }
            return;
        }

        if(map.containsKey(start)){
            List<Vertex> vertexList = map.get(start).getVertexList();
            for(Vertex vertex : vertexList){
                if(!vertex.isVisit()){
                    vertex.setVisit(true);
                    list.add(vertex.getDest());
                    dfs(new HashMap<>(map), vertex.getDest(), depth+1, new ArrayList<>(list));
                    list.remove(list.size()-1);
                    vertex.setVisit(false);
                }
            }
        }
    }

    class Edge{
        private final List<Vertex> vertexList;

        public Edge() {
            this.vertexList = new ArrayList<>();
        }

        public List<Vertex> getVertexList() {
            return vertexList;
        }

        public void addVertex(String dest){
            this.vertexList.add(new Vertex(dest));
        }
    }

    class Vertex{
        private final String dest;
        private boolean visit;

        public Vertex(String dest) {
            this.dest = dest;
        }

        public boolean isVisit(){
            return this.visit;
        }

        public void setVisit(boolean visit){
            this.visit = visit;
        }

        public String getDest() {
            return dest;
        }
    }



}
