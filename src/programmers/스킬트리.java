package programmers;


public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String s : skill_trees) {
            boolean[] visit = new boolean[skill.length()];
            boolean check = false;
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                boolean start = false;
                for (int j = skill.length()-1; j >= 0; j--) {
                    if (start && !visit[j]) {
                        check = true;
                        break;
                    }

                    if (now == skill.charAt(j)) {
                        visit[j] = true;
                        start = true;
                    }
                }
            }

            if(!check){
                answer++;
            }
        }

        return answer;
    }
}
