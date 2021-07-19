package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9251 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			char[] a = br.readLine().toCharArray(); // 알파벳을 하나씩 비교하기 위해서 char[]로 변경
			char[] b = br.readLine().toCharArray(); // 알파벳을 하나씩 비교하기 위해서 char[]로 변경
			
			int[][] dp = new int[a.length+1][b.length+1]; // 공집합을 표현하기 위해서 인덱스를 한 줄씩 추가
			for(int i=1; i<=a.length; i++) {
				for(int j=1; j<=b.length; j++) {
					if(a[i-1] == b[j-1]) { // i-1번째 문자와 j-1번째 알파벳이 서로 같다면
						dp[i][j] = dp[i-1][j-1] + 1; // 알파벳이 공통으로 존재하므로 이전 dp 배열에 1을 더해서 현재 dp 배열을 만듦
					} else { // i-1번째 문자와 j-1번째 알파벳이 서로 다르다면 
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); // dp[i-1][j]와 dp[i][j-1]을 비교 
					}
				}
			}
			
			bw.write(dp[a.length][b.length]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
