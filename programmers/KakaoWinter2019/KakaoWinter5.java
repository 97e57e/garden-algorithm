package programmers.KakaoWinter2019;

public class KakaoWinter5 {
    // 5:43 시
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        long answer = solution(stones, k);
        System.out.println(answer);
    }

    public static long solution(int[] stones, int k) {
        long answer = 0;

        long start = 0;
        long end = Long.MAX_VALUE;

        while(start <= end) {
            long mid = (start+end) / 2;

            if (check(stones, k, mid)) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public static boolean check(int[] stones, int k, long mid) {
        int position = -1;
        for (int i=0; i<stones.length; i++) {
            if (stones[i] - mid +1>0) {
                if (i-position>k) return false;
                position = i;
            }
        }

        if (stones.length-position>k) return false;

        return true;
    }
}
