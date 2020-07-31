package kakao;

public class StringCompression {
    // 12:45 시작
    // 13:23 종료
    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();

        String s = "ababcdcdababcdcd";

        int solution = stringCompression.solution(s);

        System.out.println(solution);
    }

    static int min = Integer.MAX_VALUE;
    public int solution(String s) {
        int stringLen = s.length();

        for (int i=1; i<=stringLen/2; i++) {
            StringBuilder sb = new StringBuilder();
            int stringDup = 1;
            String subString = s.substring(0, i);
            String prevString = subString;

            int namuji = stringLen%i;
            for (int j=i; j<stringLen - namuji; j +=i) {
                subString = s.substring(j, j+i);
                if(subString.equals(prevString)) {
                    // 이전 스트링과 같으면
                    stringDup ++;
                } else {
                    // 이전 스트링과 다르면
                    if (stringDup != 1) {
                        sb.append(Integer.toString(stringDup));
                        stringDup = 1;
                    }
                    sb.append(prevString);
                }
                prevString = subString;

            }
            if (stringDup != 1) {
                sb.append(Integer.toString(stringDup));
            }
            sb.append(prevString);

            if (namuji != 0) {
                sb.append(s.substring(stringLen - namuji - 1, stringLen - 1));
            }
            System.out.println(sb.toString());

            min = Math.min(sb.toString().length(), min);
        }

        if (min == Integer.MAX_VALUE) min = stringLen;

        return min;
    }
}
