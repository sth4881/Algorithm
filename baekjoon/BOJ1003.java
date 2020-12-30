package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1003 {
	public static void func(int[] arr, int n, int max) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int[][] dp = new int[2][max+1];
			dp[0][0] = 1; // 테스트 케이스가 0일 때 0의 출력 횟수
			dp[0][1] = 0; // 테스트 케이스가 1일 때 0의 출력 횟수
			dp[1][0] = 0; // 테스트 케이스가 0일 때 1의 출력 횟수
			dp[1][1] = 1; // 테스트 케이스가 1일 때 1의 출력 횟수
			for(int i=2; i<=max; i++) {
				dp[0][i] = dp[0][i-2] + dp[0][i-1]; // 테스트 케이스가 i일 때 0의 출력 횟수 = 테스트 케이스가 i-1일 때 0의 출력 횟수 + 테스트 케이스가 i-2일 때 0의 출력 횟수
				dp[1][i] = dp[1][i-2] + dp[1][i-1]; // 테스트 케이스가 i일 때 1의 출력 횟수 = 테스트 케이스가 i-1일 때 1의 출력 횟수 + 테스트 케이스가 i-2일 때 1의 출력 횟수
			}
			for(int i=0; i<n; i++) {
				bw.write(dp[0][arr[i]]+" "+dp[1][arr[i]]+"\n");
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
			String input = br.readLine();
			int n = Integer.parseInt(input);
			int[] arr = new int[n];
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				String tmp = br.readLine();
				arr[i] = Integer.parseInt(tmp);
				if(max < arr[i]) max = arr[i];
			}
			func(arr, n, max);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}