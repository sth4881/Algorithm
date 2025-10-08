package com.baekjoon;

import java.util.Scanner;

/* ���� 1932�� �����ﰢ�� (Silver) */
public class BJ1932 {
	public static void func(int n, int[][] arr) {
		int[][] dp = new int[n][]; // dp �迭 ����
		for(int i=0; i<n; i++) {
			dp[i] = new int[i+1]; // ���� �迭 ����
		}
		dp[0][0] = arr[0][0]; // 0��° �ٿ��� ���� �������� �����Ƿ� 0���� �ʱ�ȭ
		
		// ������ �ִ밪�� ������ ���Ҹ� ���Ѵٰ� �ؼ�
		// n-1��° ������ ��α��� ������ �� �ִ밪�� �������� �����Ƿ�
		// �ִ밪�� ���� �ʴ� �ٸ� ��ε鵵 ��� �����ؼ� ���������Ѵ�.
		//
		// ó������ i��° ���ұ����� ���� ���ϴ� ������ i��° ������ ���� �����ְ�
		// i-1��° ���� �߿��� ���� �밢���� ��ġ�� ���ҿ� ������ �밢���� ��ġ�� ���Ҹ� ���ؼ�
		// �� ū ���� ��������ϹǷ� Math.max(dp[i-1][���� �밢�� ����],  dp[i-1][������ �밢�� ����])�� ��������Ѵ�.
		for(int i=1; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) dp[i][j] = dp[i-1][j] + arr[i][j]; // �ﰢ���� ���� ���� ��ġ�� ��쿡 ���� ���� ó��
				else if(j==i) dp[i][j] = dp[i-1][j-1] + arr[i][j]; // �ﰢ���� ������ ���� ��ġ�� ��쿡 ���� ���� ó��
				else dp[i][j] = Math.max(dp[i-1][j-1],  dp[i-1][j]) + arr[i][j];
			}
		}
		
		// ������ ���� ���ҵ� �߿��� �ִ밪 ã��
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
			arr[i] = new int[i+1]; // ���� �迭 ����
			for(int j=0; j<=i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		func(n, arr);
	}
}
