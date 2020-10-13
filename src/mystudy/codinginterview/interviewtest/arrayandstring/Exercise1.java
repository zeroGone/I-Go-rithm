package mystudy.codinginterview.interviewtest.arrayandstring;

import java.util.Arrays;

/* 136p
 * 문제 : 문자열이 주어졌을 때, 중복되는 문자가 있는지 확인하는 함수를 작성하시오.
 * 주의사항 : 자료구조 사용 X
 * */
public class Exercise1 {

    //아스키코드만 확인한다고 하였을때
    public boolean checkForRepeatedCharacter(String string) {
        boolean[] arrayForCharacter = new boolean[126];

        for (int index = 0; index < string.length(); index++) {
            int character = string.charAt(index);

            if (arrayForCharacter[character]) {
                return true;
            }

            arrayForCharacter[character] = true;
        }

        return false;
    }
}
