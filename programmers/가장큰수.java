package programmers;

import java.util.*;

public class 가장큰수 {
    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};

        String answer = solution(input);
        System.out.println(answer);

    }

    public static String solution(int[] input) {
        String[] nums = new String[input.length];

        for (int i=0; i<input.length; i++) {
            nums[i] = String.valueOf(input[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if (nums[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
