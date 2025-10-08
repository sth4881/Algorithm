package com.baekjoon;

import java.util.Scanner;

/* 백준 1932번 정수삼각형 (Silver) */
public class BJ1932 {
	public static void func(int n, int[][] arr) {
		int[][] dp = new int[n][]; // dp 배열 선언
		for(int i=0; i<n; i++) {
			dp[i] = new int[i+1]; // 가변 배열 생성
		}
		dp[0][0] = arr[0][0]; // 0번째 줄에는 값이 존재하지 않으므로 0으로 초기화
		
		// 무작정 최대값을 가지는 원소를 택한다고 해서
		// n-1번째 원소의 경로까지 더했을 때 최대값을 도출하지 않으므로
		// 최대값을 갖지 않는 다른 경로들도 모두 포함해서 계산해줘야한다.
		//
		// 처음부터 i번째 원소까지의 합을 구하는 과정은 i번째 원소의 값을 더해주고
		// i-1번째 원소 중에서 왼쪽 대각선에 위치한 원소와 오른쪽 대각선에 위치한 원소를 비교해서
		// 더 큰 값을 더해줘야하므로 Math.max(dp[i-1][왼쪽 대각선 원소],  dp[i-1][오른쪽 대각선 원소])를 더해줘야한다.
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) dp[i][j] = dp[i-1][j] + arr[i][j]; // 삼각형의 왼쪽 변에 위치한 경우에 대한 예외 처리
				else if(j==i) dp[i][j] = dp[i-1][j-1] + arr[i][j]; // 삼각형의 오른쪽 변에 위치한 경우에 대한 예외 처리
				else dp[i][j] = Math.max(dp[i-1][j-1],  dp[i-1][j]) + arr[i][j];
			}
		}
		
		// 마지막 줄의 원소들 중에서 최대값 찾기
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++)
			if(dp[n-1][i] > max) max = dp[n-1][i];
		System.out.println(max);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][];
		for(int i=0; i<n; i++) {
			arr[i] = new int[i+1]; // 가변 배열 생성
			for(int j=0; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		func(n, arr);
	}
}
