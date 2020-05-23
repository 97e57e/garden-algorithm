package programmers.KakaoBlind2018;

import java.util.ArrayList;
import java.util.List;

public class KakaoBlind2018_cache {
    // 8: 41
    // 8: 56
    // 걸린시간 15
    public static void main(String[] args) {
        int cacheSize = 2;
        String[] cities = {
                "Jeju", "Pangyo", "NewYork", "newyork"
        };
        int answer = solution(cacheSize, cities);
        System.out.println(answer);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> caches = new ArrayList<>();

        if (cacheSize == 0) return cities.length * 5;

        for (String city : cities) {
            if(caches.contains(city.toLowerCase())) {
                caches.remove(city.toLowerCase());
                caches.add(city.toLowerCase());
                answer++;
            } else {
                if (caches.size() == cacheSize) {
                    caches.remove(0);
                }
                caches.add(city.toLowerCase());
                answer+=5;
            }
        }
        return answer;
    }
}
