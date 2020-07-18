package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();

        for(String s : record){
            String[] temp = s.split(" ");
            String id = temp[1];

            if(temp[0].equals("Change")) user.replace(id, temp[2]);
            else if(temp[0].equals("Enter")) user.put(id, temp[2]);
        }

        List<String> answer = new ArrayList<>();

        for(int i=0; i<record.length; i++){
            String[] strings = record[i].split(" ");

            if(strings[0].equals("Enter")){
                answer.add(user.get(strings[1])+"님이 들어왔습니다.");
            }else if(strings[0].equals("Leave")){
                answer.add(user.get(strings[1])+"님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[answer.size()]);
    }
}
