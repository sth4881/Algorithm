package com.algorithm.baekjoon;

import java.io.*;

public class BOJ2193 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 입력
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n+1];
            dp[1] = 1;
            for(int i=2; i<=n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            // 출력
            bw.write(dp[n]+"\n");
            bw.close();
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}