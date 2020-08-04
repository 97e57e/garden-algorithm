package kakao;

import java.util.*;

public class Pillar {
    // 14:22 시작
    // 15:50 실패 [잘못된 풀이를 깨달음]
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


    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        Set<Poll> pollSet = new HashSet<>();
        Set<Bo> boSet = new HashSet<>();

        for (int i=0; i<build_frame.length; i++) {
            int newY = build_frame[i][1];
            int newX = build_frame[i][0];
            int command = build_frame[i][3];
            if (build_frame[i][2] == 0){
                //기둥
                Poll poll = new Poll(newY, newX);
                if (command ==1) {
                    //기둥을 설치 한다.
                    if (newY == 0) {
                        // 바닥 이라면 그냥 설치
                        pollSet.add(poll);
                    } else {
                        //바닥이 아니라면
                        boolean isOk = false;
                        // 바로 아래에 기둥이 있다.
                        for (Poll poll1 : pollSet) {
                            if (poll1.y == newY - 1) isOk = true;
                        }
                        // 바로 아래에 보가 있다.
                        for (Bo bo : boSet) {
                            if ((bo.x == newX && bo.y == newY) ||
                                    (bo.x == newX-1 && bo.y == newY)) isOk = true;
                        }
                        // 그럼 설치
                        if (isOk) pollSet.add(poll);
                    }
                } else {
                    //기둥을 삭제한다.
                    boolean downPoll = false;
                    boolean upPoll = false;
                    boolean leftDownBo = false;
                    boolean rightDownBo = false;
                    boolean leftUpBo = false;
                    boolean rightUpBo = false;

                    boolean delete = true;

                    // 기둥 근처의 기둥을 조사
                    for (Poll poll1 : pollSet) {
                        if (poll1.y == newY - 1) downPoll = true;
                        if (poll1.y == newY + 1) upPoll = true;
                    }

                    // 기둥 근처의 보를 조사
                    for (Bo bo : boSet) {
                        if (bo.y == newY && bo.x == newX) rightDownBo = true;
                        if (bo.y == newY && bo.x == newX-1) leftDownBo = true;
                        if (bo.y == newY+1 && bo.x == newX) rightUpBo = true;
                        if (bo.y == newY+1 && bo.x == newX-1) leftUpBo = true;
                    }

                    // 아래 기둥이 없는데 보도 없으면 삭제 불가
                    if (((!leftDownBo && !rightDownBo) && !downPoll) && (newY != 0)){
                        delete = false;
                    } else if (!upPoll && ((leftUpBo && !rightUpBo) || (!leftUpBo && rightUpBo))){
                        // 위에 기둥이 없는데 보가 한쪽만 있다면 삭제 불가
                        delete = false;
                    }
                    if (delete) pollSet.remove(poll);
                }

            } else {
                //보
                Bo bo = new Bo(newY, newX);
                if (command ==1) {
                    boolean leftBo = false;
                    boolean rightBo = false;
                    boolean leftUpPoll = false;
                    boolean rightUpPoll = false;
                    boolean leftDownPoll = false;
                    boolean rightDownPoll = false;

                    // 보를 설치

                    // 보 검사
                    for (Bo bo1 : boSet) {
                        if (bo1.y == newY && bo1.x == newX - 1) leftBo = true;
                        if (bo1.y == newY && bo1.x == newX + 1) rightBo = true;
                    }

                    // 기둥 검사
                    for (Poll poll : pollSet) {
                        if (poll.x == newX && poll.y == newY) leftUpPoll = true;
                        if (poll.x == newX && poll.y == newY-1) leftDownPoll = true;
                        if (poll.x == newX + 1 && poll.y == newY) rightUpPoll = true;
                        if (poll.x == newX + 1 && poll.y == newY-1) rightDownPoll = true;
                    }

                    boolean isOk = false;

                    // 왼쪽이나 오른쪽 모두에 기동 혹은 보가 있다면
                    if (leftDownPoll) isOk = true;
                    if (rightDownPoll) isOk = true;
                    if (leftBo && rightBo) isOk = true;

                    if (isOk) boSet.add(bo);
                } else {
                    boolean leftBo = false;
                    boolean rightBo = false;
                    boolean leftUpPoll = false;
                    boolean rightUpPoll = false;
                    boolean leftDownPoll = false;
                    boolean rightDownPoll = false;

                    boolean delete = true;
                    // 보를 삭제
                    for (Bo bo1 : boSet) {
                        if (bo1.y == newY && bo1.x == newX - 1) rightBo = true;
                        if (bo1.y == newY && bo1.x == newX + 1) leftBo = true;
                    }

                    // 기둥 검사
                    for (Poll poll : pollSet) {
                        if (poll.x == newX && poll.y == newY) leftUpPoll = true;
                        if (poll.x == newX && poll.y == newY-1) leftDownPoll = true;
                        if (poll.x == newX + 1 && poll.y == newY) rightUpPoll = true;
                        if (poll.x == newX + 1 && poll.y == newY-1) rightDownPoll = true;
                    }

                    if (leftUpPoll && (!leftDownPoll && !leftBo)) delete = false;
                    if (rightUpPoll && (!rightDownPoll && rightBo)) delete = false;
                    if (!leftUpPoll && !leftDownPoll && !rightUpPoll && !rightDownPoll) delete = false;

                    if (delete) boSet.remove(bo);
                }
            }
        }
        List<Poll> pollList = new ArrayList<>(pollSet);
        List<Bo> boList = new ArrayList<>(boSet);

        answer = new int[boList.size() + pollSet.size()][3];

        for (int i=0; i<pollList.size(); i++) {
            Poll p = pollList.get(i);
            answer[i][0] = p.x;
            answer[i][1] = p.y;
            answer[i][2] = 0;
        }
        for (int i=pollList.size(); i<boList.size() + pollList.size(); i++) {
            Bo b = boList.get(i - pollList.size());
            answer[i][0] = b.x;
            answer[i][1] = b.y;
            answer[i][2] = 1;
        }

        Arrays.sort(answer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return o1[2] - o2[2];
                    } else {
                        return o1[1] - o2[1];
                    }
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        return answer;
    }

    // 바닥을 기준으로
    class Poll {
        int y;
        int x;

        public Poll(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Poll poll = (Poll) o;
            return y == poll.y &&
                    x == poll.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

    // 왼쪽을 기준으로
    class Bo {
        int y;
        int x;

        public Bo(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Bo bo = (Bo) o;
            return y == bo.y &&
                    x == bo.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
