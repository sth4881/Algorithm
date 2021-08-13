package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_Lesson_2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				for(int j=0; j<input.length; j++) {
					dp[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for(int i=1; i<n; i++)
				dp[i][0] += dp[i-1][0];
			for(int j=1; j<n; j++)
				dp[0][j] += dp[0][j-1];
			
			for(int i=1; i<n; i++) {
				for(int j=1; j<n; j++) {
					dp[i][j] += Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
			
			bw.write(dp[n-1][n-1]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
