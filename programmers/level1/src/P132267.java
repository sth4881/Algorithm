/* 프로그래머스 콜라 문제 (Level 1) */
class Solution {
    /* 빈 병 a 당 받을 수 있는 콜라 개수 b, 가지고 있는 빈 병 개수 n */
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cur = n;
        while(cur>=a) { // 빈 병 a개를 주고 콜라를 받을 수 있을 때
            answer += cur/a*b; // 빈 병 a개를 주고 콜라 b병을 받은 총 콜라 병 수
            cur = cur/a*b + cur%a; // 콜라를 먹고 생긴 빈 병 개수 cur/a*b + 조건 미충족으로 남은 빈 병 개수 cur%a
        }
        return answer;
    }
}