package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 9095번 1, 2, 3 더하기 (Silver) */
public class BOJ9095 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++) {
				int n = Integer.parseInt(br.readLine());
				// n이 1인 경우
				if(n==1) {
					bw.write(1+"\n");
					continue;
				}
				// n인 2인 경우
				else if(n==2) {
					bw.write(2+"\n");
					continue;
				}
				// n이 3이상의 양수인 경우
				else {
					// DP
					int[] dp = new int[n+1];
					dp[0] = 1; dp[1] = 1; dp[2] = 2;
					for(int j=3; j<=n; j++)
						// j번째 DP는 이전 값 3개를 더한 것
						dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
					bw.write(dp[n]+"\n");
				}
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}