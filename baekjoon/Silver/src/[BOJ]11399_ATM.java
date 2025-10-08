package com.algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] dp = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            // 입력받은 대기시간을 오름차순으로 정렬
            Arrays.sort(arr);
            dp[0] = arr[0];
            for(int i=1; i<n; i++) {
                dp[i] += dp[i-1] + arr[i];
            }

            int sum = 0;
            for(int item : dp)
                sum += item;
            bw.write(sum+"\n");
            bw.close();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}