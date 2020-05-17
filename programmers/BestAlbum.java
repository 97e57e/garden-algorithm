package programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbum ba = new BestAlbum();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = ba.solution(genres, plays);

        for (int i : answer) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Integer>> genreMap = new HashMap<>();

        int listSize = plays.length;

        for (int i=0; i<listSize; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        for (String genre : map.keySet()) {
            Map<String, List<Integer>> tmpMap = new HashMap<>();
            genreMap.put(genre, new ArrayList<>());
        }

        for (int i=0; i<listSize; i++) {
            genreMap.get(genres[i]).add(i);
        }

        for (String genre : genreMap.keySet()) {
            Collections.sort(genreMap.get(genre), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (plays[o1] == plays[o2]) {
                        return o1 - o2;
                    } else if (plays[o1] > plays[o2]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        System.out.println("genreMap : " + genreMap);
        System.out.println("map : " + map);

        List<Integer> answerList = new ArrayList<>();

        for (int i=0; i<map.size(); i++) {
            List<Integer> tmpList = genreMap.get(keySetList.get(i));
            answerList.add(tmpList.get(0));
            if (tmpList.size()==1) continue;
            answerList.add(tmpList.get(1));
        }

        System.out.println(answerList);
        answer = new int[answerList.size()];

        for (int i=0; i<answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
