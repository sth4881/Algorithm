package com.algorithm.dp;

import java.util.Scanner;

public class SumOfN3 {
	// ���� n�� 1���� k������ ���ڵ��� ������ ǥ���ϴ� ����� ��(��, �������� ���ڵ��� ������ ������� �ʴ´�)
	// if~else���� ����Ǵ� Ƚ���� ���� for���� ���� n*k�� ����Ѵ�. ���� ����Ǵ� �ð����⵵�� O(nk)
	public static int func(int n, int k) {
		int[][] arr = new int[n+1][k+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				if(j==0) arr[i][j] = 0; // ������ 1���� n�����ε�, n�� 1���� ���� �� �����Ƿ� �� ���� ���ٰ� ����
				else if(i==0) arr[i][j] = 1; // n=0�� ���� base case�̹Ƿ� ���� 1�� ����
				else if(i<j) arr[i][j] = arr[i][i]; // i<j�� ��쿡�� ǥ���� �� �ִ� ����� �����Ƿ� arr[i][i]�� ���� ����
				else arr[i][j] = arr[i-j][j] + arr[i][j-1]; // ���� ��츦 ������ ��� ��쿡 ���ؼ� j�� ����ϴ� ���(arr[i-j][j])�� 
															// j�� ������� �ʴ� ���(arr[i][j-1])�� ������ �и��Ͽ� ��������� ����
			}
		}
		return arr[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(n+"�� 1���� "+k+"������ ���ڵ��� ������ ǥ���� ��, �������� ���ڵ��� ������ ������� �ʰ� ǥ���ϴ� ����� �� : "+func(n,k));
	}
}
