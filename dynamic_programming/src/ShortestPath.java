package com.algorithm.dp;

import java.util.Scanner;

public class ShortestPath {
	// m x n ���ڸ� �ִܰŸ��� ���� ����� ��
	// = (m-1 x n�� �ִܰŸ��� ���� ����� ��) + (m x n-1�� �ִܰŸ��� ���� ����Ǽ�)
	// DP�� �̿��Ͽ� �ڵ带 ¥��  if~else ������ ����Ǵ� Ƚ���� ���� for���� ���ؼ� m*n�� ���
	// ���� ����Ǵ� �ð����⵵�� O(mn)
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
		System.out.println(m + "X" + n + "�� ���ڸ� �ִܰŸ��� ����� �� ����� �� : " + func(m, n));
		return;
	}
}
