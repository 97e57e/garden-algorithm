package programmers.KakaoWinter2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KakaoWinter3 {
    // 6:00 시 시
    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int answer = solution(user_id, banned_id);
        System.out.println("answer = " + answer);
    }
    static boolean[] checked;
    public static int solution(String[] user_id, String[] banned_id) {
        int answer;

        Set<Set<String>> matchedSet = new HashSet<>();
        boolean[] visited = new boolean[user_id.length];

        permu(matchedSet, visited, user_id, banned_id, 0);

        answer = matchedSet.size();
        return answer;
    }

    public static void permu(Set<Set<String>> matchedSet, boolean[] visited, String[] user_id, String[] banned_id, int idx) {
        if (idx >= banned_id.length) {
            Set<String> newSet = new HashSet<>();
            for (int i=0; i<visited.length; i++) {
                if (visited[i]) newSet.add(user_id[i]);
            }
            matchedSet.add(newSet);
            return;
        }


        for (int i=0; i<user_id.length; i++) {
            if (!visited[i] && (user_id[i].length() == banned_id[idx].length())) {
                boolean flag = true;
                for (int z=0; z<user_id[i].length(); z++) {
                    if (banned_id[idx].charAt(z) == '*') continue;
                    if (banned_id[idx].charAt(z) != user_id[i].charAt(z)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    visited[i] = true;
                    permu(matchedSet, visited, user_id, banned_id, idx + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
