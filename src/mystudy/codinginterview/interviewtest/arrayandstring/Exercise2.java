package mystudy.codinginterview.interviewtest.arrayandstring;

import java.util.HashMap;
import java.util.Map;

/* 136p 1.2
 * 문제 : 문자열 두 개가 서로 순열 관계인지 확인
 * */
public class Exercise2 {

    public boolean isPermutation(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for(int indexStr1 = 0; indexStr1 < str1.length(); indexStr1++){
            char charInStr1 = str1.charAt(indexStr1);

            if(characterIntegerMap.containsKey(charInStr1)){
                characterIntegerMap.put(charInStr1, characterIntegerMap.get(charInStr1));
            }else{
                characterIntegerMap.put(charInStr1, 1);
            }
        }

        for(int indexStr2 = 0; indexStr2 < str2.length(); indexStr2++){
            char charInStr2 = str2.charAt(indexStr2);

            if(characterIntegerMap.containsKey(charInStr2)){

                if(characterIntegerMap.get(charInStr2) == 0){
                    return false;
                }else{
                    characterIntegerMap.put(charInStr2, characterIntegerMap.get(charInStr2)-1);
                }

            }else{
                return false;
            }
        }

        return true;
    }

}
