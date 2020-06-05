package programmers;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    public static void main(String[] args) {
        Stock stock = new Stock();
        int[] stocks = {1, 2, 3, 2, 3};
        int[] answer = stock.solution(stocks);

        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            int count =0;
            for (int j=i+1; j<prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
