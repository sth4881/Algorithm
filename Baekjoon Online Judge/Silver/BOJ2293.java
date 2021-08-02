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
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			
			int[] dp = new int[k+1];
			dp[0] = 1; // 동전을 아예 사용하지 않는 경우도 경우의 수라고 생각한다.
			for(int i=0; i<n; i++) {
				for(int j=arr[i]; j<=k; j++) { // 사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우를 제외하기 위해서 j값을 매번 i번째 동전으로 초기화
					dp[j] += dp[j-arr[i]]; // dp[j]는 첫번째부터 j번째까지의 동전을 사용했을 때의 합이 k원이 되도록 만드는 경우의 수이다.
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
