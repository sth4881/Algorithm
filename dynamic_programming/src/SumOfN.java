package com.algorithm.dp;

import java.util.Scanner;

//���� N�� 1���� K������ ���ڵ��� ������ ǥ���ϴ� ����� ��
public class SumOfN {
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
