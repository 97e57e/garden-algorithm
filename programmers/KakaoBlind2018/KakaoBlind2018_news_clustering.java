package programmers.KakaoBlind2018;

import java.util.*;

public class KakaoBlind2018_news_clustering {
    // 6:43 시
    // 7:13 시
    // 걸린시간 : 30분
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";

        int answer = solution(str1, str2);

        System.out.println(answer);
    }

    public static int solution(String str1, String str2) {
        if (str1.length() ==0 && str2.length()==0) return 1;
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        boolean[] checkStr1 = new boolean[str1.length()];
        boolean[] checkStr2 = new boolean[str2.length()];

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i=0; i<str1.length(); i++) {
            if ('a' <= str1.charAt(i) && str1.charAt(i) <= 'z'){
                checkStr1[i] = true;
            }
        }
        for (int i=0; i<str2.length(); i++) {
            if ('a' <= str2.charAt(i) && str2.charAt(i) <= 'z'){
                checkStr2[i] = true;
            }
        }

        for (int i=0; i<str1.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if (checkStr1[i] && checkStr1[i+1]) {
                sb.append(str1.charAt(i));
                sb.append(str1.charAt(i+1));
                map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        for (int i=0; i<str2.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if (checkStr2[i] && checkStr2[i+1]) {
                sb.append(str2.charAt(i));
                sb.append(str2.charAt(i+1));
                map2.put(sb.toString(), map2.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        if (map1.size()==0 && map2.size()==0) return 65536;

        Map<String, Integer> gyo = new HashMap<>();
        Map<String, Integer> hap = new HashMap<>();

        for (String st : map1.keySet()) {
            if (map2.containsKey(st)) {
                gyo.put(st, Math.min(map1.get(st), map2.get(st)));
                hap.put(st, Math.max(map1.get(st), map2.get(st)));
            } else {
                hap.put(st, map1.get(st));
            }
        }

        for (String st : map2.keySet()) {
            if (map1.containsKey(st)) {
                gyo.put(st, Math.min(map1.get(st), map2.get(st)));
                hap.put(st, Math.max(map1.get(st), map2.get(st)));
            } else {
                hap.put(st, map2.get(st));
            }
        }

        int gyozip = 0;
        for (int i : gyo.values()) {
            gyozip += i;
        }

        int hapzip = 0;
        for (int i : hap.values()) {
            hapzip += i;
        }


        double a =  (double) gyozip / (double)hapzip;

        answer = (int)(a * 65536);

        return answer;
    }
}
