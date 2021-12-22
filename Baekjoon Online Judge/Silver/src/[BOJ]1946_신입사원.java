package com.algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1946 {
    static class Applicant implements Comparable<Applicant> {
        int document;
        int interview;
        public Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
        @Override
        public int compareTo(Applicant o) {
            return this.document - o.document;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            ArrayList<Applicant> list = new ArrayList<>();
            ArrayList<Integer> answer = new ArrayList<>();

            int t = Integer.parseInt(br.readLine());
            for(int i=0; i<t; i++) {
                int n = Integer.parseInt(br.readLine());
                for(int j=0; j<n; j++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int document = Integer.parseInt(st.nextToken());
                    int interview = Integer.parseInt(st.nextToken());
                    list.add(new Applicant(document, interview));
                }

                int cnt = 1;
                int min = Integer.MAX_VALUE;
                // 신입사원들을 서류심사 성적순으로 정렬
                Collections.sort(list);
                for(int j=1; j<list.size(); j++) {
                    int target = list.get(j).interview;
                    // target 보다 서류심사를 잘 본 지원자들 중에서 면접심사 순위가 가장 높은 사람을 min으로 갱신
                    min = Math.min(min, list.get(j-1).interview);
                    // target과 min을 비교해서 target의 면접심사 순위가 더 높으면 cnt 1 증가
                    if(target<min) cnt++;
                }
                answer.add(cnt);
                list.clear();
            }

            for(int item : answer)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}