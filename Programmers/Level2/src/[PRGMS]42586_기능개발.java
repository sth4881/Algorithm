package com.algorithm.programmers;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class PRGMS42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        while(true) {
            // 하루에 배포한 작업의 수를 세기 위한 변수 cnt
            int cnt = 0;
            // idx번째 기능부터 마지막 기능까지
            for(int i=idx; i<progresses.length; i++)
                // 각각의 기능이 100 미만이면 진행률 증가
                if(progresses[i]<100) progresses[i] += speeds[i];
            // 오늘 하루동안 idx번째 기능부터 마지막 기능까지
            // 각각의 진행률이 100 이상이면 cnt, idx 증가
            while(idx<progresses.length && progresses[idx]>=100) {
                cnt++;
                idx++;
            }
            // 배포한 기능이 있으면 리스트에 추가
            if(cnt>0) list.add(cnt);
            // 모든 작업을 진행하면 반복문 탈출
            if(idx==progresses.length) break;
        }
        // 리스트를 배열로 바꿔서 반환
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}