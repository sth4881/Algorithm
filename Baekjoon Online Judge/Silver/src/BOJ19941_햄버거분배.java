package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19941 {
    private static int N, K;
    private static char[] chars;
    private static List<Integer> list;
    private static boolean check(int idx) {
        return (idx>=0 && idx<N) && chars[Math.abs(idx)]=='H';
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            chars = br.readLine().toCharArray();
            for(int i=0; i<chars.length; i++) {
                if(chars[i]=='P') list.add(i);
            }

            int cnt = 0;
            for(int person : list) {
                // 핵심 : 첫번째 사람부터 본인의 위치를 기준으로 최대 K만큼 떨어져 있는 햄버거를 왼쪽에서 오른쪽까지 탐색 + 가장 멀리 떨어진 햄버거를 먹기
                for(int i=K; i>=-K; i--) {
                    // person-i의 위치에 햄버거가 있는지 확인
                    if(check(person-i)) {
                        chars[person-i] = 'X'; // 햄버거를 먹었으면 해당 위치를 X로 변경
                        cnt++;
                        break;
                    }
                }
            }

            bw.write(cnt+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}