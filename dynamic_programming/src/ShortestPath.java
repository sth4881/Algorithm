package com.algorithm.dp;

import java.util.Scanner;

public class ShortestPath {
	// m x n 격자를 최단거리로 가는 경우의 수
	// = (m-1 x n를 최단거리로 가는 경우의 수) + (m x n-1를 최단거리로 가는 경우의수)
	// DP를 이용하여 코드를 짜면  if~else 구문이 실행되는 횟수는 이중 for문에 의해서 m*n에 비례
	// 따라서 도출되는 시간복잡도는 O(mn)
	public static int func(int m, int n) {
		int[][] arr = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i==0 || j==0) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		return arr[m][n];
	}
	public static void main(String[] args) {
		int m, n;
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		System.out.println(m + "X" + n + "의 격자를 최단거리로 통과할 때 경우의 수 : " + func(m, n));
		return;
	}
}
