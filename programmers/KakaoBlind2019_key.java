package programmers.KakaoBlind2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KakaoBlind2019_key {
    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};
        int answer = solution(relation);
        System.out.println(answer);
    }

    static List<Integer> bitSet = new ArrayList<>();
    static int rowCount;
    static int columnCount;

    static private int find = 0;
    static private String[][] table;
    static private ArrayList<Integer> keyList = new ArrayList<>();

    public static int solution(String[][] relation) {
        columnCount = relation[0].length;
        rowCount = relation.length;
        table = relation;

        int count = 0;

        for (int bitMask = 0; bitMask < (1 << columnCount); bitMask++) {

            if(isSubKey(bitMask) == true)
                continue;

            if(isUnique(bitMask)) {
                count++;
                keyList.add(bitMask);
                //System.out.println(Integer.toBinaryString(bitMask));
            }

        }

        System.out.println(keyList);
        return count;
    }

    private static boolean isUnique(int bitMask) {
        HashSet<String> checkKeySet = new HashSet<>();
        StringBuilder sb = new StringBuilder(128);

        if(bitMask == 0)
            return false;

        for (int r = 0; r < rowCount; r++) {
            sb.setLength(0);

            for (int c = 0; c < columnCount; c++) {

                if( (bitMask & (1 << c)) != 0) {
                    sb.append(table[r][c]);
                }

            }

            String key = sb.toString();

            if(checkKeySet.contains(key) == false) {
                checkKeySet.add(key);
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isSubKey(int bitMask) {

        for (Integer subKey : keyList) {
            if( (bitMask & subKey) >= subKey) {
                return true;
            }
        }

        return false;
    }

}