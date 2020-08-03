package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchLyrics {
    // 16:25 시작
    // 16:55 1차 종료 [효율성 2개 통과 X]
    public static void main(String[] args) {
        SearchLyrics searchLyrics = new SearchLyrics();

        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] solution = searchLyrics.solution(words, queries);
        for (int i : solution) {
            System.out.println(i);
        }


    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Map<Integer, List<String>> stringMap = new HashMap<>();

        // make container
        for (int i=0; i<words.length; i++) {
            int key = words[i].length();
            List<String> stringList;

            if (stringMap.containsKey(key)) {
                // 있으면
                stringList = stringMap.get(key);
                stringList.add(words[i]);
            } else {
                // 없으면
                stringList = new ArrayList<>();
                stringList.add(words[i]);
            }
            stringMap.put(key, stringList);
        }

        for(int i=0; i<queries.length; i++) {
            String query = queries[i];
            int count = 0;
            for (int z=0; z<query.length(); z++) {
                if (query.charAt(z) == '?') count++;
            }
            if (stringMap.get(query.length()) == null) {
                answer[i] = 0;
            } else {
                List<String> strList = stringMap.get(query.length());
                if (count == query.length()) {
                    answer[i] = strList.size();
                    continue;
                }

                int tmp = 0;
                for (String s : strList) {
                    if (isMatch(s, query, count)) tmp++;
                }
                answer[i] = tmp;
            }
        }

        return answer;
    }

    public boolean isMatch(String s, String q, int count) {
        int first = q.indexOf('?');

        if (first == 0) {
            if (q.substring(count, q.length()).equals(s.substring(count, q.length()))) return true;
        } else {
            if (q.substring(0, q.length() - count).equals(s.substring(0, q.length() - count))) return true;
         }

        return false;
    }
}
