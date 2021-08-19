package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ2294 {
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
			dp[0] = 0;
			for(int i=1; i<=k; i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				int min = Integer.MAX_VALUE; // 동전 개수의 최소값을 구하기 위한 변수 min
				
				for(int j=0; j<n; j++) {
					if(i>=coin[j]) {
						dp[i]++;
						dp[i] += dp[i-coin[j]];
					}
				}
				
				for(int tmp=0; tmp<list.size(); tmp++)
					if(list.get(tmp)<min) min = list.get(tmp); // 동전을 최소로 사용하는 경우로 갱신
				dp[i] = min; // 동전을 최소로 사용하는 경우를 대입
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
