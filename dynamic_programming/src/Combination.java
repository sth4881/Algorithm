package com.algorithm.dp;

import java.util.Scanner;

public class Combination {
	// nCk(n�� �߿��� k�� �̴� ����� ��)
	// = (n-1Ck-1(n�� �̴� ���)) + (n-1Ck(n�� ���� �ʰ� �ٸ��� �̴� ���))
	// if~else ������ ����Ǵ� Ƚ���� ���� for���� ���ؼ� n*k�� ���
	// ���� ����Ǵ� �ð����⵵�� O(nk)
	public static int func(int n, int k) {
		int[][] arr = new int[n+1][k+1]; // n�� k�� �Է¹����� 0~n-1, 0~k-1������ �����Ǳ� ������ n+1, k+1
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(i, k); j++) { // j�� i�� ����� ������ �ȵǰ�(case : i=1, j=2), 
															// 1�� �߿��� 2���� ���� ���� �Ұ���(j<=k�� ��� �߻�) 
															// j�� k�� ����� ������ �ȵȴ�(case : i=3, j=3), 
															// 2���� ���� �ϴµ� 3���� ������(case : j<=i�� ��� �߻�)
															// ���� i�� k �߿��� �� ���� ���� �������� ����
				if(i==0 || j==0 || j==i) arr[i][j] = 1; // n�� �߿��� 0���� ���� ��� : 1
															// 0�� �߿��� k���� ���� ��� : 1
															// n�� �߿��� n���� ���� ��� : 1
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		return arr[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(n+"�� �߿��� "+k+"���� �����ϴ� ����� �� : "  + func(n,k));
		return;
	}
}
