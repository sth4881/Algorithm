package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 1010번 다리놓기 (Silver) */
public class BOJ1010 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			// 알고리즘에 사용할 팩토리얼을 dp 배열로 초기화
			double[] dp = new double[30];
			dp[0] = 1; dp[1] = 1;
			for(int i=2; i<30; i++)
				dp[i] = dp[i-1] * i;
			
			int testcase = Integer.parseInt(br.readLine());
			int[] ans = new int[testcase];
			for(int i=0; i<testcase; i++) {
				String[] tmp = br.readLine().split(" ");
				int n = Integer.parseInt(tmp[0]);
				int m = Integer.parseInt(tmp[1]);
				
				// 알고리즘(순서를 고려하지 않고, 이전에 선택한 사이트를 다시 선택하지 못하는 조합을 사용)
				ans[i] = (int) Math.round(dp[m] / (dp[m-n] * dp[n])); // Math.round()를 이용하여 버림 대신 반올림 사용
			}
			
			for(int i=0; i<ans.length; i++)
				bw.write(ans[i]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
