package boj_code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        // L 커서를 왼쪽 으로
        // D 커서를 오른쪽 으로
        // B 커서 왼쪽에 있는 문자를 삭제함
        // P $	$라는 문자를 커서 왼쪽에 추가함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input 받기
        String s = st.nextToken();
        int M = Integer.parseInt(br.readLine());

        // 컨테이너 만들기
        List<Character> linkedList = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            linkedList.add(s.charAt(i));
        }

        ListIterator<Character> iter = linkedList.listIterator(linkedList.size());

        // 로직
        int size = s.length();
        int cursorPointer = size;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if (command == 'L') {
                // 커서 왼쪽 으로 옮기기
                if (iter.hasPrevious()) iter.previous();
            } else if (command == 'D') {
                // 커서 오른쪽으로 옮기기
                if (iter.hasNext()) iter.next();
            } else if (command == 'B') {
                // 지우기
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else {
                // 추가
                char character = st.nextToken().charAt(0);
                iter.add(character);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character character : linkedList) {
            sb.append(character);
        }

        System.out.println(sb.toString());
    }
}
