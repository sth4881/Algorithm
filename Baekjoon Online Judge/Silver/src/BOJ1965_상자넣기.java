package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

/**
 * 접근 및 풀이방법
 * LIS (최장 증가 수열)
 * 첫번째부터 i번째 전 원소까지 탐색하면서 최대값을 갱신하는 원리
 */
public class BOJ1965 {
    private static int N;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N+1];
            Arrays.fill(dp, 1);

            int max = 0;
            for(int i=2; i<=N; i++) {
                for(int j=1; j<i; j++) {
                    if(arr[i]>arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1); // 로직을 'dp[i] = dp[j]+1'처럼 구성하는 경우, dp[i]가 최대값인 경우가 사라질 가능성 존재
                    }
                }
                max = Math.max(max, dp[i]); // max를 사용하지 않고, 맨 뒤 값을 출력하는 경우 잘못된 답이 출력되는 반례 존재 (ex. 1 7 8 9 5)
            }

            bw.write(max+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}