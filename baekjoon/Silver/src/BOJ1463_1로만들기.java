package com.algorithm.baekjoon;

import java.io.*;

public class BOJ1463 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            // DP
            int[] dp = new int[n+1]; // dp[i] : 숫자 i를 1로 만들기 위해 필요한 최소 연산 횟수
            for(int i=2; i<=n; i++) {
                int a = (i%3==0) ? dp[i/3] : Integer.MAX_VALUE; // i를 3으로 나누는 경우에 필요한 최소 연산 횟수
                int b = (i%2==0) ? dp[i/2] : Integer.MAX_VALUE; // i를 2로 나누는 경우에 필요한 최소 연산 횟수
                int c = dp[i-1]; // i에서 1을 빼는 경우에 필요한 최소 연산 횟수
                dp[i] = Math.min(a, Math.min(b, c)) + 1; // 위의 값들을 비교해서 도출된 최소 연산 횟수 + 1
            }

            bw.write(dp[n]+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}