package boj_code_plus;

import java.util.Scanner;

public class Q1107 {
    static int INIT_CHANNEL = 100;
    static boolean[] remote;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // true 이면 고장난 버튼
        remote = new boolean[10];

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i=0; i<M; i++) {
            int num = sc.nextInt();
            remote[num] = true;
        }

        int answer = solve(N);
        System.out.println(answer);
    }

    public static int solve(int N) {
        int answer = 0;
        int tmpAnswer = 0;

        // 100 이면 바로 이동 가능
        if (N == INIT_CHANNEL) return answer;

        // 먼저 + - 만으로 갈 수 있는 횟수를 구한다.
        if (N < INIT_CHANNEL) tmpAnswer = INIT_CHANNEL - N;
        if (N > INIT_CHANNEL) tmpAnswer = N - INIT_CHANNEL;


        // 바로 이동 가능 하면 숫자를 눌러 이동 가능한 것과 +,- 만으로 가는것 중 비교 해서 간다.
        if (isRight(N)) {
            return Math.min(channelCount(N), tmpAnswer);
        }

        int upChannel = Integer.MAX_VALUE;
        int downChannel = Integer.MAX_VALUE;

        // 채널을 내려 가며
        int channel = N-1;
        while(channel >= 0) {
            // 바로 이동 할 수 있는 가장 가까운 채널
            if (isRight(channel)) {
                downChannel =channelCount(channel) + (N - channel);
                break;
            }
            channel--;
        }

        // 채널을 올려 가며
        channel = N+1;
        while(channel <= 1000000) {
            // 바로 이동 할 수 있는 가장 가까운 채널
            if (isRight(channel)) {
                upChannel = channelCount(channel) + Math.abs(channel - N);
                break;
            }
            channel++;
        }

        answer = Math.min(Math.min(upChannel, downChannel), tmpAnswer);

        return answer;
    }

    // 해당 채널을 숫자로 눌러서 갈 수 있는지?
    private static boolean isRight(int channel) {
        if (channel == 0) {
            if (remote[0]) {
                return false;
            } else {
                return true;
            }
        }
        while(channel > 0) {
            // 고장난 버튼이면
            if (remote[channel % 10]) return false;
            channel /= 10;
        }
        return true;
    }

    // 채널의 자릿수
    public static int channelCount(int channel) {
        if (channel< 10) return 1;

        int count = 0;
        while(channel > 0) {
            channel /= 10;
            count ++;
        }
        return count;
    }
}
