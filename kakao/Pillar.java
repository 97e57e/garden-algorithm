package kakao;

public class Pillar {
    // 14:22 시작
    // 15:50 실패 [잘못된 풀이를 깨달음]
    
    // 14:00 시작
    // 15:06 종료 [정답]
    public static void main(String[] args) {
        Pillar pillar = new Pillar();

//        int n = 5;
//        int[][] build_frame = {
//                {1, 0, 0, 1},
//                {1, 1, 1, 1},
//                {2, 1, 0, 1},
//                {2, 2, 1, 1},
//                {5, 0, 0, 1},
//                {5, 1, 0, 1},
//                {4, 2, 1, 1},
//                {3, 2, 1, 1},
//        };
        int n = 5;
        int[][] build_frame = {
                {0, 0, 0, 1},
                {2, 0, 0, 1},
                {4, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {2, 1, 1, 1},
                {3, 1, 1, 1},
                {2, 0, 0, 0},
                {1, 1, 1, 0},
                {2, 2, 0, 1}
        };


        int[][] solution = pillar.solution(n, build_frame);

        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }
    }

    static int[][][] map;
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        int boCount = 0;
        int pollCount = 0;
        map = new int[101][101][2]; //[][][0]은 기둥 [][][1]은 보

        for (int i=0; i<build_frame.length; i++) {
            int command = build_frame[i][3];

            int newY = build_frame[i][1];
            int newX = build_frame[i][0];

            if (build_frame[i][2] == 0){
                //기둥
                if (command ==1) {
                   //기둥 설치
                    if (canPoll(newY, newX)) {
                        map[newY][newX][0] = 1;
                        pollCount++;
                    }
                } else {
                    //기둥을 삭제한다.
                    if (map[newY][newX][0] == 1) {
                        map[newY][newX][0] = 0;
                        pollCount--;
                        if (!check()){
                            map[newY][newX][0] = 1;
                            pollCount++;
                        }
                    }

                }
            } else {
                //보
                if (command ==1) {
                    // 보를 설치
                    if (canBo(newY, newX)) {
                        boCount++;
                        map[newY][newX][1] = 1;
                    }
                } else {
                    // 보를 삭제
                    if (map[newY][newX][1] == 1) {
                        map[newY][newX][1] = 0;
                        boCount--;
                        if (!check()) {
                            boCount++;
                            map[newY][newX][1] = 1;
                        }
                    }
                }
            }
        }
        // 기둥과 보의 수만큼 answer 배열 생성
        answer = new int[pollCount+boCount][3];
        int answerIdx = 0;

        // 오름차순 순서에 맞게 변
        for (int j=0; j<map.length; j++) {
            for (int i=0; i<map.length; i++) {
                //
                if (map[i][j][0] == 1) {
                    answer[answerIdx][0] = j;
                    answer[answerIdx][1] = i;
                    answer[answerIdx][2] = 0;
                    answerIdx ++;
                }

                if (map[i][j][1] == 1) {
                    answer[answerIdx][0] = j;
                    answer[answerIdx][1] = i;
                    answer[answerIdx][2] = 1;
                    answerIdx ++;
                }
            }
        }

        return answer;
    }

    // 한쪽 끝 부분이 기둥 위에 있거나, 양쪽 끝 부분이 다른 보 연결되어야 한다.
    private boolean canBo(int newY, int newX) {
        if (newY-1>=0 && (map[newY-1][newX][0] == 1 || map[newY-1][newX+1][0] == 1)) return true;

        if (newX-1>=0 && map[newY][newX-1][1] == 1 && map[newY][newX+1][1] == 1) return true;

        return false;
    }

    // 맵 전체를 돌며 기둥과 보가 유효 한지 검
    private boolean check() {
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map.length; j++) {
                if (map[i][j][0] == 1) {
                    //기둥
                    if (!canPoll(i,j)) return false;
                }
                if (map[i][j][1] == 1) {
                    // 보
                    if (!canBo(i, j)) return false;
                }
            }
        }
        return true;
    }

    private boolean canPoll(int newY, int newX) {
        // 바닥
        if (newY == 0) return true;
        // 바로 아래 기둥
        if(map[newY-1][newX][0] == 1) return  true;
        // 바로 아래 오른쪽 보
        if(map[newY][newX][1] == 1) return true;
        // 바로 아래 왼쪽 보
        if(newX-1>=0 && map[newY][newX-1][1] == 1) return true;

        return false;
    }

    public void print(int[][][] a) {
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a.length; j++) {
                System.out.print(a[i][j][0] + " ");
            }
            System.out.println(" ");
        }
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a.length; j++) {
                System.out.print(a[i][j][1] + " ");
            }
            System.out.println(" ");
        }
    }
}
