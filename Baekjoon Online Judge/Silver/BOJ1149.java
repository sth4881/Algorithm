package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1149 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n+1][3];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				dp[i][0] = Integer.parseInt(tmp[0]);
				dp[i][1] = Integer.parseInt(tmp[1]);
				dp[i][2] = Integer.parseInt(tmp[2]);
			}
			
			// 알고리즘
			for(int i=0; i<n; i++) {
				dp[i+1][0] += Math.min(dp[i][1], dp[i][2]); // i+1번째 집을 R로 칠하는데 필요한 비용은 i번째 집을 G와 B 중에서 적은 비용으로 칠하는 비용과 같음
				dp[i+1][1] += Math.min(dp[i][0], dp[i][2]); // i+1번째 집을 G로 칠하는데 필요한 비용은 i번째 집을 R과 B 중에서 적은 비용으로 칠하는 비용과 같음
				dp[i+1][2] += Math.min(dp[i][0], dp[i][1]); // i+1번째 집을 B로 칠하는데 필요한 비용은 i번째 집을 R과 G 중에서 적은 비용으로 칠하는 비용과 같음
			}
			
			int result = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]); // 모든 집을 앞뒤의 색과 겹치지 않게 칠하는 최소 비용 
			bw.write(result+"\n");
			bw.close();			
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
