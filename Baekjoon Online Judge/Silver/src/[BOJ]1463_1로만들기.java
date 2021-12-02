package com.algorithm.baekjoon;

import java.io.*;

public class BOJ1463 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 입력
            int n = Integer.parseInt(br.readLine());

            if(n==1) bw.write(0+"\n");
            else if(n==2 || n==3) bw.write(1+"\n");
            else {
                // 선언 & 생성
                int[] dp = new int[n+1];
                dp[2] = 1; dp[3] = 1;

                // DP
                for(int i=4; i<=n; i++) {
                    // i가 3으로 나누어 떨어지고 2로 나누어 떨어지면
                    if(i%3==0 && i%2==0) dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1])+1;

                    // i가 3으로 나누어 떨어지고 2로는 나누어 떨어지지 않으면
                    else if(i%3==0) dp[i] = Math.min(dp[i/3], dp[i-1])+1;

                    // i가 2로 나누어 떨어지고 3으로는 나누어 떨어지지 않으면
                    else if(i%2==0) dp[i] = Math.min(dp[i/2], dp[i-1])+1;

                    // i가 3으로 나누어 떨어지지 않고 2로도 나누어 떨어지지 않으면
                    else dp[i] = dp[i-1]+1;
                }

                // 출력
                bw.write(dp[n]+"\n");
            }
            bw.close();
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}