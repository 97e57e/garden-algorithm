package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Camouflage {
    // 프로그래머스 해시 -> 위장 문제

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();

        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        int solution = camouflage.solution(clothes);
        System.out.println(solution);

    }

    public int solution(String[][] clothes) {
        int answer = 1;

        // container
        Map<String, List<String>> clothesMap = new HashMap<>();

        // iter
        for (String[] clothe : clothes) {
            if (clothesMap.containsKey(clothe[1])) {
                clothesMap.get(clothe[1]).add(clothe[0]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(clothe[0]);

                clothesMap.put(clothe[1], newList);
            }
        }

        // get Answer
        for (String key : clothesMap.keySet()) {
            answer *= clothesMap.get(key).size() + 1;
        }

        return answer - 1;
    }
}
