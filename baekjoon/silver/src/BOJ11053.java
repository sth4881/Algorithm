package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

/* 백준 11053번 가장 긴 증가하는 부분 수열 (Silver) */
public class BOJ11053 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[n+1];
            Arrays.fill(dp, 1); // i번째 숫자가 가장 작다고 가정할 때 초기 LIS는 1

            // ex. 1 2 1 3 2 5에서 기준이 되는 숫자가 '3'이라면, i는 4, j는 1, 2, 3이다.
            int max = 0;
            for(int i=2; i<=n; i++) { // 기준이 되는 숫자의 인덱스 i
                for(int j=1; j<i; j++) { // 기준이 되는 숫자 전까지 나열된 숫자들의 인덱스 j
                    if(arr[i] > arr[j]) { // 기준이 되는 숫자가 이전에 나열된 숫자보다 크다면
                        dp[i] = Math.max(dp[i], dp[j]+1); // i번째 LIS는 i번째 LIS와 j번째 LIS+1을 비교해서 더 큰 값으로 갱신
                    }
                }
                max = Math.max(max, dp[i]); // 맨 마지막에 오는 숫자가 낮은 축에 속하면, dp[N]은 정답이 될 수 없으므로 올바른 답을 구하기 위해서 max 사용 (ex. 1 2 3 4 5 1)
            }

            if(max==0) bw.write(1+"\n"); // 수열이 1이면 답이 1이 나와야 하는데 max가 0이 나와서...
            else bw.write(max+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}