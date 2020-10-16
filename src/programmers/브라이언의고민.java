package programmers;

public class 브라이언의고민 {
    public String solution(String sentence) {
        int index = 0;

        StringBuilder builder = new StringBuilder();

        while (index < sentence.length()) {

            char character = sentence.charAt(index);

            if (character >= 97 && character <= 122) {

                int lastIndexOfLowerCase = sentence.lastIndexOf(character);

                int lowerCaseNumber = 1;

                while(index < lastIndexOfLowerCase){

                    char nextCharacter = sentence.charAt(index);

                    if(character == nextCharacter){
                        lowerCaseNumber++;
                    }else{
                        builder.append(nextCharacter);
                    }

                    index++;
                }

                if(lowerCaseNumber == 1){

                }else{

                }
            }else{
                builder.append(character);
            }

            index++;
        }

        return builder.toString();
    }
}
