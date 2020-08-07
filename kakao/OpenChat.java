package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChat {
    // 15:57 시작
    public static void main(String[] args) {
        OpenChat openChat = new OpenChat();

        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] solution = openChat.solution(record);

        for (String s : solution) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] record) {
        String[] answer= {};
        List<String> userEntrance = new ArrayList<>();

        Map<String, String> userInfo = new HashMap<>();

        for (String s : record) {
            StringBuilder sb = new StringBuilder();

            String behavior = s.split(" ")[0];
            String uId = s.split(" ")[1];
            String userName;

            // 최초 입장 유저 userInfo에 유저 등록
            if (!userInfo.containsKey(uId)) {
                userName = s.split(" ")[2];
                userInfo.put(uId, userName);
            }

            // 입, 퇴장 행위 기록
            if (behavior.equals("Enter") || behavior.equals("Leave")) {
                sb.append(behavior);
                sb.append(" ");
                sb.append(uId);
                userEntrance.add(sb.toString());
            }

            // 나갔다가 닉네임을 바꿔 들어온 경우
            if (behavior.equals("Enter")) {
                userName = s.split(" ")[2];

                if (userInfo.containsKey(uId) && !userInfo.get(uId).equals(userName)) {
                    userInfo.replace(uId, userName);
                }

            }

            if (behavior.equals("Change")) {
                userName = s.split(" ")[2];
                userInfo.replace(uId, userName);
            }
        }
        answer = new String[userEntrance.size()];

        for (int i=0; i<userEntrance.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String userBehavior = userEntrance.get(i);
            String behavior = userBehavior.split(" ")[0];
            String uId = userBehavior.split(" ")[1];
            String userName = userInfo.get(uId);

            sb.append(userName);
            sb.append("님이 ");

            if (behavior.equals("Enter")) {
                sb.append("들어왔습니다.");
            } else if (behavior.equals("Leave")) {
                sb.append("나갔습니다.");
            }

            answer[i] = sb.toString();
        }
        return answer;
    }
}
