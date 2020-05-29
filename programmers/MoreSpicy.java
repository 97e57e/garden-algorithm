package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        MoreSpicy moreSpicy = new MoreSpicy();

        int[] scoville = {1};
        int k=1;

        int answer = moreSpicy.solution(scoville, k);
        System.out.println(answer);
    }

    // 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
    public int solution(int[] scoville, int K) {
        if (scoville == null || scoville.length == 0) return -1;
        if (K ==0) return 0;
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : scoville) {
            queue.offer(i);
        }

        // q의 맨 앞이 k보다 작으면 합치라
        while(queue.size() != 1 && queue.peek().intValue() < K) {
            queue.offer(queue.poll() + queue.poll()*2);
            answer++;
        }

        if (queue.poll() < K) {
            answer = -1;
        }

        return answer;
    }
}
