package com.baekjoon;

import java.util.Scanner;

public class BJ1149 {
	public static void func(int n, int[][] arr) {
		int[][] dp = new int[n+1][3]; // dp�迭 ����
		for(int i=1; i<=n; i++) {
			// ������ �ּ� ����� ������ ���� ������ ĥ�Ѵٰ� �ؼ�
			// n��° ������ ��ĥ���� �� �ּ� ����� ������� �����Ƿ�
			// �ּ� ����� ���� �ʴ� �ٸ� ���鵵 ��� �����ؼ� ����ؾ��Ѵ�.
			//
			// ó������ i��° ������ ��ĥ�ϴ� ����� i��° ���� ��ĥ�ϴ� ����� �����ְ�
			// i-1��° �� �߿��� ���� ����� ��ġ�� �ʴ� ���� ��ĥ���� �������� ��� ����� ��������Ѵ�.
			// �� �� ����� ��ġ�� �ʴ� �� �߿��� ����� �� ���� ��� ���� �����ؾ��ϹǷ�
			// Math.min( dp[i-1][���� ĥ�� �� �ִ� ���� ������ �ƴ� ��1], dp[i-1][���� ĥ�� �� �ִ� ���� ������ �ƴ� ��2] )�� ��������Ѵ�.
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
