package programmers.KakaoBlind2018;

import java.util.ArrayList;
import java.util.List;

public class KakaoBlind2018_secret_map {
    // 7:20 시
    // 7:32 시
    // 걸린시간 : 12분
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = solution(n, arr1, arr2);

//        for (String a : answer) {
//            System.out.println(a);
//        }

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer;
        List<String> map1 = new ArrayList<>();
        List<String> map2 = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

        for (int i=0; i<arr1.length; i++) {
            String map = Integer.toBinaryString(arr1[i]);
            if (map.length() != n) {
                StringBuilder sb = new StringBuilder();
                sb.append(map);
                while (sb.length() != n) {
                    sb.insert(0, '0');
                }
                map = sb.toString();
            }
            map1.add(map);
        }

        for (int i=0; i<arr2.length; i++) {
            String map = Integer.toBinaryString(arr2[i]);
            if (map.length() != n) {
                StringBuilder sb = new StringBuilder();
                sb.append(map);
                while (sb.length() != n) {
                    sb.insert(0, '0');
                }
                map = sb.toString();
            }
            map2.add(map);
        }

        for (int i=0; i<map1.size(); i++) {
            String m1 = map1.get(i);
            String m2 = map2.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<m1.length(); j++) {
                if(m1.charAt(j) == '1' || m2.charAt(j) == '1') {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            answerList.add(sb.toString());
        }
        answer = answerList.toArray(new String[answerList.size()]);
        return answer;
    }
}
