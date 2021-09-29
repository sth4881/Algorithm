package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2293 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);
			
			int[] coin = new int[k];
			for(int i=0; i<n; i++)
				coin[i] = Integer.parseInt(br.readLine());
			
			int[] dp = new int[k+1];
			dp[0] = 1;
			for(int i=0; i<n; i++) { // 동전 N개에 대해서
				for(int j=1; j<=k; j++) { // 1부터 K까지의 경우에 대해서
					if(j>=coin[i]) dp[j] += dp[j-coin[i]]; // i번째 동전이 가치 j와 값이 같거나 작은 경우, 둘의 차를 뺐을 때까지의 경우의 수를 대입
				}
			}		
			
			bw.write(dp[k]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}