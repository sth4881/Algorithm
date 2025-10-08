package com.algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;

public class BOJ11057 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            // 첫번째 대괄호는 자릿수를 의미하고, 두번째 대괄호는 0부터 9까지의 숫자를 의미한다.
            // 따라서 오르막수가 인정되도록 숫자를 뒤에 이어붙인다고 생각하면서 점화식을 구해본다.
            long[][] dp = new long[n+1][10];
            Arrays.fill(dp[1], 1); // dp[1][0], dp[1][1], ... dp[1][9]는 모두 1

            // 숫자의 자릿수 i
            for(int i=2; i<=n; i++) {
                // 맨 앞에 오는 숫자 j
                for(int j=0; j<=9; j++) {
                    // j보다 크거나 같은 숫자 k
                    for(int k=9; k>=j; k--) {
                        dp[i][j] += dp[i-1][k]; // j로 시작하는 숫자가 맨 앞에 오는 경우, k로 시작하는 i-1자리 숫자의 개수를 모두 더한 결과가 j로 시작하는 i자리 숫자의 개수이다.
                        dp[i][j] %= 10007;
                    }
                }
            }

            long answer = 0;
            for(long item : dp[n]) {
                answer += item;
            }
            bw.write(answer%10007+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}