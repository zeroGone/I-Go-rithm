package programmers;

public class 방금그곡 {

    public static void main(String[] args) {
        System.out.println(new 방금그곡().solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public String solution(String m, String[] musicinfos) {
        for (int i = 0; i < musicinfos.length; i++) {
            String[] strings = musicinfos[i].split(",");
            int[] start = timeDivision(strings[0]);
            int[] end = timeDivision(strings[1]);

            int time = start[0] < end[0] ? end[1] + 60 - start[1] : end[1] - start[1];
            StringBuilder builder = new StringBuilder();
            String info = strings[3];
            int index = 0;
            for (int j = 0; j < time; j++) {
                char c = info.charAt(index);
                builder.append(c);
                if(!Character.isAlphabetic(c)) j--;
                index = index == info.length() - 1 ? 0 : index + 1;
            }

            System.out.println(builder.toString()+" "+time+" "+m);
            if (builder.toString().contains(m)) return strings[2];
        }
        return "`(None)`";
    }

    private int[] timeDivision(String time) {
        String[] strings = time.split(":");
        int[] times = new int[2];
        times[0] = Integer.parseInt(strings[0]);
        times[1] = Integer.parseInt(strings[1]);
        return times;
    }
}
