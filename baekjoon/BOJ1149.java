package com.baekjoon;

import java.util.Scanner;

public class BJ1149 {
	public static void func(int n, int[][] arr) {
		int[][] dp = new int[n+1][3]; // dp배열 생성
		for(int i=1; i<=n; i++) {
			// 무작정 최소 비용을 가지는 집의 색깔을 칠한다고 해서
			// n번째 집까지 색칠했을 때 최소 비용이 도출되지 않으므로
			// 최소 비용을 갖지 않는 다른 집들도 모두 포함해서 계산해야한다.
			//
			// 처음부터 i번째 집까지 색칠하는 비용은 i번째 집을 색칠하는 비용을 더해주고
			// i-1번째 집 중에서 현재 색깔과 겹치지 않는 집을 색칠했을 때까지의 드는 비용을 더해줘야한다.
			// 이 때 색깔과 겹치지 않는 집 중에서 비용이 더 적게 드는 집을 선택해야하므로
			// Math.min( dp[i-1][현재 칠할 수 있는 집의 색깔이 아닌 것1], dp[i-1][현재 칠할 수 있는 집의 색깔이 아닌 것2] )을 더해줘야한다.
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		System.out.println( Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]) );
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			for(int j=0; j<3; j++)
				arr[i][j] = sc.nextInt();
		}
		func(n, arr);
	}
}
