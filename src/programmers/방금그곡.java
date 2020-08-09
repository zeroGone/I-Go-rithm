package programmers;

import java.util.ArrayList;
import java.util.List;

public class 방금그곡 {

    public static void main(String[] args) {
//        System.out.println(new 방금그곡().solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(new 방금그곡().solution("C#", new String[]{"12:00,12:01,HELLO,C#C", "13:00,13:01,WORLD,C#C#C#C#C#"}));

    }

    public String solution(String m, String[] musicinfos) {
        List<Music> list = new ArrayList<>();

        for (String musicinfo : musicinfos) {
            String[] strings = musicinfo.split(",");
            int[] start = timeDivision(strings[0]);
            int[] end = timeDivision(strings[1]);
            int time = (end[0] - start[0]) * 60 + end[1] - start[1];

            Music now = new Music(time, strings[2], strings[3]);

            List<String> melody = convertStringList(m);

            if (containsStringListCheck(now.getInfo(), melody)) list.add(now);
        }

        System.out.println(list);

        if (list.size() == 0) return "(None)";
        else {
            list.sort((o1, o2) -> Integer.compare(o2.getPlayTime(), o1.getPlayTime()));
            return list.get(0).getName();
        }
    }

    private boolean containsStringListCheck(List<String> music, List<String> m) {
        StringBuilder builder = new StringBuilder();
        for (String s : m) {
            builder.append(s);
        }
        String value = builder.toString();

        int i = 0;
        while(i < music.size()){
            if(i + m.size() > music.size()) break;
            builder.delete(0, builder.length());
            for (int j = i; j < i + m.size(); j++) {
                builder.append(music.get(j));
            }
            System.out.println(builder.toString());
            if (value.equals(builder.toString())) return true;
            i++;
        }

        return false;
    }

    private List<String> convertStringList(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) list.add(Character.toString(c));
            else list.set(list.size() - 1, list.get(list.size() - 1) + c);
        }
        return list;
    }

    class Music {
        private final String name;
        private final List<String> info;
        private final int playTime;

        public String getName() {
            return name;
        }

        public List<String> getInfo() {
            return info;
        }

        public int getPlayTime() {
            return playTime;
        }

        public Music(int time, String name, String info) {
            this.playTime = time;
            this.name = name;
            this.info = convertStringList(info);

            int size = this.info.size();
            for (int i = size; i < time; i++) {
                this.info.add(this.getInfo().get(i % size));
            }
            while (this.info.size() != this.playTime) {
                this.info.remove(this.info.size() - 1);
            }
        }

        @Override
        public String toString() {
            return "Music{" +
                    "name='" + name + '\'' +
                    ", info=" + info +
                    ", playTime=" + playTime +
                    '}';
        }
    }

    private int[] timeDivision(String time) {
        String[] strings = time.split(":");
        int[] times = new int[2];
        times[0] = Integer.parseInt(strings[0]);
        times[1] = Integer.parseInt(strings[1]);
        return times;
    }
}
