package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11726 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine()); // 입력
			long[] dp = new long[n+1];
			dp[0] = 1; // 원래 경우의 수는 0이지만, 편의상 1로 초기화
			dp[1] = 1; // 직사각형의 크기가 2x1인 경우, 경우의 수는 1
			if(n==1) { // n=1인 경우
				bw.write(dp[1]%10007+"\n");
				bw.close();
			} else { // n=2 이상인 경우
				for(int i=2; i<=n; i++) {
					dp[i] = dp[i-1] + dp[i-2]; // i번째 경우의 수는 i-1번째 경우의 수와 i-2번째 경우의 수를 합한 결과임을 알 수 있음 
					dp[i] %= 10007; //안 넣어주면 틀렸다고 나와서 추가
				}
				bw.write(dp[n]+"\n");
				bw.close();
			}
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
