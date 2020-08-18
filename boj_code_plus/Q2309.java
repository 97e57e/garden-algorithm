package boj_code_plus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GO_Q2309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] key = new int[9];

        for (int i=0; i<9; i++) {
            key[i] = sc.nextInt();
        }

        int totalKey = 0;
        for (int i=0; i<9; i++) {
            totalKey += key[i];
        }

        List<Integer> keyList = new ArrayList<>();
        boolean findAnswer = false;
        for (int i=0; i<8; i++) {
            if (findAnswer) break;
            for (int j=i+1; j<9; j++) {
                if (findAnswer) break;
                // 두 난장이를 뺐을 때 100이 되면?
                if (totalKey - (key[i] + key[j]) == 100) {
                    for (int z=0; z<9; z++) {
                        if (z != i && z != j) keyList.add(key[z]);
                    }
                    findAnswer = true;
                }
            }

        }

        // 정답 정렬
        Collections.sort(keyList);

        // 정답 출력
        for (Integer integer : keyList) {
            System.out.println(integer);
        }
    }
}
