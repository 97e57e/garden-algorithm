package programmers.KakaoWinter2019;

import java.util.*;

public class KakaoWinter2 {
    //5:05
    public static void main(String[] args) {

        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        int[] arr = solution(s);
//        for (int a : arr) {
//            System.out.println(a);
//        }
    }

    public static int[] solution(String s) {
        int[] answer;
        s = s.substring(1, s.length() -1);
        s = s.replace("},", "} ");
        s = s.replace("{", "");
        s = s.replace("}", "");

        String[] tuples = s.split(" ");

        List<String> tupleList = new ArrayList<>();

        for(int i=0; i<tuples.length; i++) {
            tupleList.add(tuples[i]);
        }
        Collections.sort(tupleList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        List<Integer> result = new ArrayList<>();
        for (String t : tupleList) {
            String[] items = t.split(",");
            for (String item : items) {
                result.add(Integer.parseInt(item));
            }
        }

        answer = new int[tupleList.size()];
        List<Integer> answerList = new ArrayList<>();
        for (int i=0; i<result.size(); i++) {
            if (answerList.contains(result.get(i))) continue;

            answerList.add(result.get(i));
        }
        System.out.println(answerList);

        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
