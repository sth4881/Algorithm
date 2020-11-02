package com.algorithm.dp;

import java.util.Scanner;

public class SumOfN {
	// ���� n�� 1���� k������ ���ڵ��� ������ ǥ���ϴ� ����� ��
	// arr[i] += arr[j]; ������ ����Ǵ� Ƚ���� ���� for���� ���ؼ� n^2�� ���
	// ���� ����Ǵ� �ð����⵵�� O(n^2)
	public static int func(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=i-1; j++)
				arr[i] += arr[j];
			System.out.println("arr["+i+"] = "+arr[i]);
		}
		return arr[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("n�� ���� ǥ���ϴ� ����� �� : " + func(n));

	}
}
