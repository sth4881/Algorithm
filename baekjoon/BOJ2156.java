package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2156 {
	public static void func(int[] arr, int n) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			if(n==1) bw.write(arr[0]+"\n");
			else if(n==2) bw.write(arr[0]+arr[1]+"\n");
			else {
				int[] dp = new int[n];
				dp[0] = arr[0]; 
				dp[1] = dp[0] + arr[1];
				dp[2] = Math.max(dp[0]+arr[2], arr[1]+arr[2]);
				dp[2] = Math.max(dp[2], dp[1]);
				
				for(int i=3; i<n; i++) {
					dp[i] = Math.max(arr[i]+dp[i-2], arr[i]+arr[i-1]+dp[i-3]); // i번째 포도주까지 최대로 시식하는 경우는
																						  // i번째 포도주 + i-2번째 포도주까지 최대로 시식하는 경우와
																						  // i번째 포도주 + i-1번째 포도주 + i-3번째 포도주까지 최대로 시식하는 경우를 비교해서
																						  // 값이 더 큰 경우를 택하면 된다.
					dp[i] = Math.max(dp[i], dp[i-1]); // 하지만 포도주를 2회 연속으로 마시지 않거나 마지막 포도주를 마시지 않는 경우를 고려해줘야 하므로
															 // i번째 포도주까지 최대로 시식하는 경우와 i번째 포도주까지 최대로 시식하는 경우 중에서 더 큰 값을 선택해야 한다.
				}
				bw.write(dp[n-1]+"\n");
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
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				tmp = br.readLine();
				arr[i] = Integer.parseInt(tmp);
			}
			func(arr, n);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
