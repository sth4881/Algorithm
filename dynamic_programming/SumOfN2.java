package com.algorithm.dp;

import java.util.Scanner;

public class SumOfN2 {
	// ���� n�� 1���� k������ ���ڵ��� ������ ǥ���ϴ� ����� ��
	// if(j>=0) arr[i] += arr[j]; ������ ����Ǵ� Ƚ���� ���� for���� ���ؼ� n*k�� ���
	// ���� ����Ǵ� �ð����⵵�� O(nk)
	public static int func(int n, int k) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=i-k; j<=i-1; j++)
				if(j>=0) arr[i] += arr[j];
			System.out.println("arr["+i+"] = "+arr[i]);
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k =sc.nextInt();
		System.out.println("���� "+n+"�� ���� 1���� "+k+"���� ǥ���ϴ� ����� �� : " + func(n, k));
	}
}
