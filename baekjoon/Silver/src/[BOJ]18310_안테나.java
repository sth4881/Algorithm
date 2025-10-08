package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ18310 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                list.add(input);
            }

            // 오름차순으로 정렬
            Collections.sort(list);
            // 무조건 가운데 집이 다른 모든 집들과의 거리가 최소
            bw.write(list.get((n-1)/2) + "\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}