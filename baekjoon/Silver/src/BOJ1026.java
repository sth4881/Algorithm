package com.algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 백준 1026번 보물 (Silver) */
public class BOJ1026 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                a.add(Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens())
                b.add(Integer.parseInt(st.nextToken()));
            
            // 리스트 a를 오름차순으로 정렬
            Collections.sort(a);
            int idx = 0;
            for(int i=0; i<a.size(); i++) {
                int max = Integer.MIN_VALUE;
                for(int j=0; j<b.size(); j++) {
                    // 리스트 b의 원소 중에서 최대값과 그 값을 가리키는 인덱스를 가져옴
                    if(max < b.get(j)) {
                        max = b.get(j);
                        idx = j;
                    }
                }
                // 리스트 a에서 현재 i가 가리키는 값과 최대값을 곱해서 리스트의 원소를 갱신
                a.set(i, a.get(i)*max);
                // 최대값은 사용되었으므로 리스트 b에서 제거
                b.remove(idx);
            }

            // 리스트 a의 모든 값을 더해주면 끝
            int sum = 0;
            for(int item : a)
                sum += item;
            bw.write(sum+"\n");
            bw.close();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}