package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Trucks {
    public static void main(String[] args) {
        Trucks trucks = new Trucks();
        int bridge_length = 10;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int answer = trucks.solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int currentWeight = 0;
        int time = 0;
        int truckIdx = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(truck_weights[truckIdx]);
        currentWeight += truck_weights[truckIdx++];
        time++;

        // 트럭 아직 다 안올라감
        while(!queue.isEmpty() && truckIdx < truck_weights.length) {
            // 트럭 올릴 수 있으면 올림
            int truck = truck_weights[truckIdx];
            if (currentWeight + truck <= weight) {
                queue.offer(truck);
                currentWeight += truck;
                truckIdx++;
                time++;
            } else {
                queue.offer(0);
                time++;
                // 다리가 꽉 안찼으면 채움
                while(queue.size() != bridge_length) {
                    time++;
                    queue.offer(0);
                }
            }
            if (queue.size()==bridge_length)
                currentWeight -= queue.poll();
        }

        // 트럭 다 올라감 + 가는중이면 0 으로 밀어줌
        while (queue.size() != bridge_length) {
            queue.offer(0);
            time++;
        }

        // 트럭 다 올라감 + 큐 꽉차있으면 빼줌.
        while(!queue.isEmpty() && currentWeight!=0) {
            currentWeight -= queue.poll();
            time++;
        }

        answer=time;
        return answer;
    }
}
