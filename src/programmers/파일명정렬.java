package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 파일명정렬().solution(
                new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}
        )));
    }

    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();

        for (String s : files) {
            int[] index = new int[2];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                if (index[0] == 0 && Character.isDigit(c)) {
                    index[0] = i;
                } else if (index[0] != 0 && index[1] == 0 && !Character.isDigit(c)) {
                    index[1] = i;
                }
            }
            if (index[1] == 0) index[1] = s.length();
            File file = new File(s.substring(0, index[0]),
                    s.substring(index[0], index[1]),
                    s.substring(index[1]));
            list.add(file);
        }

        Collections.sort(list, (File f1, File f2) -> {
                    String h1 = f1.getHead().toUpperCase();
                    String h2 = f2.getHead().toUpperCase();

                    if(!h1.equals(h2)){
                        return h1.compareTo(h2);
                    }else{
                        int n1 = Integer.parseInt(f1.getNumber());
                        int n2 = Integer.parseInt(f2.getNumber());

                        if(n1 != n2){
                            return n1 > n2 ? 1 : - 1;
                        }
                    }

                    return 0;
                }
        );

        for(int i=0; i< files.length; i++){
            files[i] = list.get(i).toString();
        }
        return files;
    }

    class File {
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public String getHead() {
            return head;
        }

        public String getNumber() {
            return number;
        }


        @Override
        public String toString() {
            return head+number+tail;
        }
    }
}
