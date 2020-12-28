package com.baekjoon;

import java.util.Scanner;

public class BOJ1003 {
	/*
	public static void func(int[] arr, int n, int max) {
		int[][] dp = new int[2][max+1];
		dp[0][0] = 1; // �׽�Ʈ ���̽��� 0�� �� 0�� ��� Ƚ��
		dp[0][1] = 0; // �׽�Ʈ ���̽��� 1�� �� 0�� ��� Ƚ��
		dp[1][0] = 0; // �׽�Ʈ ���̽��� 0�� �� 1�� ��� Ƚ��
		dp[1][1] = 1; // �׽�Ʈ ���̽��� 1�� �� 1�� ��� Ƚ��
		for(int i=2; i<=max; i++) {
			dp[0][i] = dp[0][i-2] + dp[0][i-1]; // �׽�Ʈ ���̽��� i�� �� 0�� ��� Ƚ�� = �׽�Ʈ ���̽��� i-1�� �� 0�� ��� Ƚ�� + �׽�Ʈ ���̽��� i-2�� �� 0�� ��� Ƚ��
			dp[1][i] = dp[1][i-2] + dp[1][i-1]; // �׽�Ʈ ���̽��� i�� �� 1�� ��� Ƚ�� = �׽�Ʈ ���̽��� i-1�� �� 1�� ��� Ƚ�� + �׽�Ʈ ���̽��� i-2�� �� 1�� ��� Ƚ��
		}
		for(int i=0; i<n; i++) {
			System.out.println(dp[0][arr[i]]+" "+dp[1][arr[i]]);
		}
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int input = sc.nextInt();
			int[][] dp = new int[2][input+1];
			if(input==0) System.out.println(1+" "+0);
			else if(input==1) System.out.println(0+" "+1);
			else {
				dp[0][0] = 1;
				dp[0][1] = 0;
				dp[1][0] = 0;
				dp[1][1] = 1;
				for(int j=2; j<=input; j++) {
					dp[0][j] = dp[0][j-1] + dp[0][j-2];
					dp[1][j] = dp[1][j-1] + dp[1][j-2];
				}
				System.out.println(dp[0][input]+" "+dp[1][input]);
			}
		}
	}
	
	/*public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) max = arr[i];
		}
		func(arr, n, max);
	}*/
}