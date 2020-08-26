package kakao;

import java.util.*;

public class CandidateKey {
    // 14: 25 시작
    // 15: 10 종료
    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();

        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        int solution = candidateKey.solution(relation);

        System.out.println("solution = " + solution);
    }

    static int col;
    static int row;
    static boolean[] visited;
    static Set<List<Integer>> candidateKeySet = new HashSet<>();

    public int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        visited = new boolean[col];

        for (int i=1; i<=col; i++) {
            List<Integer> keyList = new ArrayList<>();
            permu(relation, keyList, i, 0);
        }

        return candidateKeySet.size();
    }

    public void permu(String[][] relation, List<Integer> keyList, int count, int idx) {
        if (keyList.size() == count) {
            if(checkSuper(relation, keyList)) {
                for (List<Integer> integers : candidateKeySet) {
                    if (keyList.containsAll(integers)) {
                        return;
                    }
                }
                List<Integer> candidate = new ArrayList<>(keyList);
                candidateKeySet.add(candidate);
            }
            return;
        }

        for (int i=idx; i<col; i++) {
            if (!visited[i]) {
                visited[i] = true;
                keyList.add(i);
                permu(relation, keyList, count, i + 1);
                keyList.remove(keyList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public boolean checkSuper(String[][] relation, List<Integer> keyList) {
        Set<List<String>> keySet = new HashSet<>();
        for (int i=0; i<row; i++) {
            List<String> superKey = new ArrayList<>();
            for (int j=0; j<keyList.size(); j++) {
                superKey.add(relation[i][keyList.get(j)]);
            }
            keySet.add(superKey);
        }

        if (keySet.size() != row) {
            return false;
        }

        return true;
    }
}
