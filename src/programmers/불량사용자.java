package programmers;

import java.util.*;

public class 불량사용자 {
    public static void main(String[] args) {
        System.out.println(new 불량사용자().solution(new String[]{
                "frodo", "fradi", "crodo", "abc123", "frodoc"
        }, new String[]{"fr*d*", "abc1**"}));

        System.out.println(new 불량사용자().solution(new String[]{
                "frodo", "fradi", "crodo", "abc123", "frodoc"
        }, new String[]{"*rodo", "*rodo", "******"}));

        System.out.println(new 불량사용자().solution(new String[]{
                "fi", "fo", "fx"
        }, new String[]{"f*", "f*", "f*"}));
    }

    private final Set<String> stringSet = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        solution(user_id, banned_id, 0, new ArrayList<>(), new boolean[banned_id.length]);
        return stringSet.size();
    }

    private void solution(String[] user_id, String[] banned_id, int userIndex, List<String> bans, boolean[] isBan) {
        if (userIndex >= user_id.length) {
            for (boolean ban : isBan) {
                if (!ban) {
                    return;
                }
            }

            Collections.sort(bans);
            StringBuilder stringBuilder = new StringBuilder();
            for (String ban : bans) {
                stringBuilder.append(ban);
            }
            stringSet.add(stringBuilder.toString());
            return;
        }

        String userId = user_id[userIndex];
        for (int banIndex = 0; banIndex < banned_id.length; banIndex += 1) {
            String banId = banned_id[banIndex];

            if (!isBan[banIndex] && isSame(userId, banId)) {
                bans.add(userId);
                isBan[banIndex] = true;
                solution(user_id, banned_id, userIndex + 1, bans, isBan);
                isBan[banIndex] = false;
                bans.remove(userId);
            }
        }

        solution(user_id, banned_id, userIndex + 1, bans, isBan);
    }

    private boolean isSame(String id, String ban) {
        if (id.length() != ban.length()) {
            return false;
        }

        for (int index = 0; index < id.length(); index += 1) {
            if (ban.charAt(index) == '*') {
                continue;
            }
            if (ban.charAt(index) != id.charAt(index)) {
                return false;
            }
        }
        return true;
    }
}
