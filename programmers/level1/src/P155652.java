import java.util.*;

class Solution {
    /* 프로그래머스 둘만의 암호 (Level 1) */    
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()) {
            int count = 0;
            int idx = index;
            while(count < idx) { // index만큼 이동할 때까지 반복
                if(c == 'z') {
                    c = 'a'; // 현재 문자가 'z'인 경우 뒤로 이동 시 'a'로 변환
                } else {
                    c += 1; // 이외 문자는 +1 해서 다음 알파벳으로 변환
                }
                if(skip.contains(String.valueOf(c))) {
                    idx++; // skip에 포함되는 문자를 만나면 이동하는 횟수 1 증가
                }
                count++; // 한 번씩 뒤로 갈 때마다 1 증가
            }
            sb.append(String.valueOf(c));
        }
        
        return sb.toString();
    }
}