package programmers;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int[] priorities = {1, 1, 1, 1, 1};
        int location = 2;
        int answer = printer.solution(priorities, location);
        System.out.println(answer);
    }

    public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<priorities.length; i++) {
            priorityQueue.offer(priorities[i]);
        }

        while(!priorityQueue.isEmpty()) {
            for (int i=0; i<priorities.length; i++) {
                if(priorities[i]==priorityQueue.peek()) {
                    if (i == location) {
                        return answer;
                    }
                    priorityQueue.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}
