package programmers;

public class NumberBaseball {
    public static void main(String[] args) {
        NumberBaseball numberBaseball = new NumberBaseball();

        int[][] baseball = {
                {123, 1, 1},
                {356,1,0},
                {327,2,0},
                {489,0,1}
        };
        int answer = numberBaseball.solution(baseball);
        System.out.println(answer);
    }

    public int solution(int[][] baseball) {
        int answer = 0;

        int ball = 0, strike = 0;

        boolean isNum = true;

        for (int i=100; i<1000; i++) {
            isNum = true;
            int h = i / 100;
            int t = (i / 10) % 10;
            int o = i % 10;
            if ((t != 0 && o != 0) && (h != t && h != o && t != o)) {

                for (int j = 0; j < baseball.length; j++) {
                    ball = 0;
                    strike = 0;
                    int num = baseball[j][0];

                    int num_h = num / 100;
                    int num_t = (num / 10) % 10;
                    int num_o = num % 10;

                    // 스트라이크 검사
                    if (h == num_h) {
                        strike++;
                    }
                    if (t == num_t) {
                        strike++;
                    }
                    if (o == num_o) {
                        strike++;
                    }

                    //볼 검사
                    if (h == num_t || h == num_o) {
                        ball++;
                    }

                    if (t == num_h || t == num_o) {
                        ball++;
                    }

                    if (o == num_h || o == num_t) {
                        ball++;
                    }

                    //
                    if (strike != baseball[j][1] || ball != baseball[j][2]) {
                        isNum = false;
                    }
                }

                if (isNum) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
