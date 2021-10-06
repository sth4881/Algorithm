package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11053 {
	public static void func(int[] arr, int n) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int[] dp = new int[n];
			for(int i=0; i<n; i++)
				dp[i] = 1; // 자기자신 값으로부터의 거리는 1이므로 모든 값을 1로 초기화
			
			for(int i=1; i<n; i++) {
				int max = Integer.MIN_VALUE;
				for(int j=0; j<i; j++) { // 현재 값의 인덱스보다 값이 작은 인덱스의 값을 대상으로
					if(arr[i]>arr[j]) { // 그중에서 값의 크기가 현재 값보다 작은 값을 대상으로
						if(max<dp[j]) max = dp[j]; // 최대값을 도출
					}
				}
				if(max>0) dp[i] = max+1; // 도출한 최대값에 +1 해줘서 길이를 증가(모든 원소에 대해서 +1하면 안되므로 max>0을 조건으로 삽입)
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++)
				if(max<dp[i]) max = dp[i];
			bw.write(max+"\n");
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
			String[] tmparr = br.readLine().split(" ");
			
			int n = Integer.parseInt(tmp);
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(tmparr[i]);
			func(arr, n);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
