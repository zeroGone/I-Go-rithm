package programmers;

public class 신규아이디추천 {
    public static void main(String[] args) {
        System.out.println(new 신규아이디추천().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new 신규아이디추천().solution("z-+.^."));
        System.out.println(new 신규아이디추천().solution("=.="));
        System.out.println(new 신규아이디추천().solution("123_.def"));
    }

    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = filtCharacters(new_id);
        new_id = replaceDots(new_id);
        new_id = replaceDot(new_id);
        new_id = checkEmpty(new_id);
        new_id = checkIsLongLength(new_id);
        return checkIsShortLength(new_id);
    }

    private String filtCharacters(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : id.toCharArray()) {
            if (isPossibleCharacter(character)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    private String replaceDots(String id) {
        while (id.contains("..")) {
            id = id.replace("..", ".");
        }
        return id;
    }

    private String replaceDot(String id) {
        if (!id.isEmpty() && id.charAt(0) == '.') {
            id = id.substring(1);
        }
        if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') {
            id = id.substring(0, id.length() - 1);
        }
        return id;
    }

    private String checkEmpty(String id) {
        if (id.length() == 0) {
            return "a";
        }
        return id;
    }

    private String checkIsLongLength(String id) {
        if (id.length() >= 16) {
            return replaceDot(id.substring(0, 15));
        } else {
            return id;
        }
    }

    private String checkIsShortLength(String id) {
        if (id.length() <= 2) {
            StringBuilder stringBuilder = new StringBuilder(id);
            while (stringBuilder.length() < 3) {
                stringBuilder.append(id.charAt(id.length() - 1));
            }
            return stringBuilder.toString();
        }
        return id;
    }

    private boolean isPossibleCharacter(char character) {
        if (Character.isLowerCase(character)) {
            return true;
        }
        if (Character.isDigit(character)) {
            return true;
        }
        return character == '-' || character == '_' || character == '.';
    }
}
