package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ12852 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            // n을 1로 만드는 방법에 포함되어 있는 숫자를 출력하기 위한 리스트
            List<Integer> list = new ArrayList<>();
            list.add(n);

            // DP
            int[] dp = new int[n+1]; // dp[i] : 숫자 i를 1로 만들기 위해 필요한 최소 연산 횟수
            for(int i=2; i<=n; i++) {
                int a = (i%3==0) ? dp[i/3] : Integer.MAX_VALUE; // i를 3으로 나누는 경우에 필요한 최소 연산 횟수
                int b = (i%2==0) ? dp[i/2] : Integer.MAX_VALUE; // i를 2로 나누는 경우에 필요한 최소 연산 횟수
                int c = dp[i-1]; // i에서 1을 빼는 경우에 필요한 최소 연산 횟수
                dp[i] = Math.min(a, Math.min(b, c)) + 1; // 위의 값들을 비교해서 도출된 최소 연산 횟수 + 1
            }

            // 구현
            int target = n;
            for(int i=n-1; i>0; i--) {
                // 현재 숫자를 3으로 나눴을 때 i거나, 2로 나눴을 때 i거나, 1을 뺐을 때 i인 경우에 대해서
                if((target%3==0 && target/3==i) || (target%2==0 && target/2==i) || target-1==i) {
                    // n에서 시작하는 target을 1로 만들기 위해 필요한 최소 연산 횟수가 dp[i]+1이라면 리스트에 i를 추가 및 다음 target을 i로 변경
                    if(dp[target] == dp[i]+1) {
                        list.add(i);
                        target = i;
                    }
                }
            }

            bw.write(dp[n]+"\n");
            for(int item : list) {
                bw.write(item+" ");
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}