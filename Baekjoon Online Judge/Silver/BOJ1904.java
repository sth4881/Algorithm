package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1904 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			if(n==1) bw.write(1%15746+"\n");
			else if(n==2) bw.write(2%15746+"\n");
			else {
				int[] dp = new int[n+1];
				dp[1] = 1; dp[2] = 2;
				for(int i=3; i<=n; i++) {
					dp[i] = (dp[i-2] + dp[i-1])%15746;
				}
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
