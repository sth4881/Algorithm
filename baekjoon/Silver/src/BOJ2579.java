package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 2579번 계단오르기 (Silver) */
public class BOJ2579 {
	public static void func(int[] cost, int n) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			if(n==1) bw.write(cost[1]+"\n"); // n이 1인 경우에 대한 예외처리
			else {
				int[] dp = new int[n+1];
				dp[1] = cost[1];
				dp[2] = cost[1]+cost[2]; // 두번째 계단까지는 연속으로 오를 수 있으므로 첫번째 계단과 두번째 계단을 더하면 된다.
				
				for(int i=3; i<=n; i++)
					dp[i] = Math.max(cost[i]+dp[i-2], cost[i]+cost[i-1]+dp[i-3]); // i번째 계단까지 올랐을 때 얻을 수 있는 최대 점수는
																								// i번째 계단의 점수 + i-2번째 계단까지 올랐을 때 얻을 수 있는 최대 점수와
																								// i번째 계단의 점수 + i-1번째 계단의 점수 + i-3번째 계단까지 올랐을 때 얻을 수 있는 최대 점수를
																								// 비교해서 더 큰 값을 최대 점수로 선택하면 된다.
				bw.write(dp[n]+"\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String tmp = br.readLine();
			int n = Integer.parseInt(tmp);
			int[] cost = new int[n+1];
			for(int i=1; i<n+1; i++) {
				tmp = br.readLine();
				cost[i] = Integer.parseInt(tmp);
			}
			func(cost, n);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	} 
}
