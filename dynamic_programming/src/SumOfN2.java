package com.algorithm.dp;

import java.util.Scanner;

// ���� N�� 1���� K������ ���ڵ��� ������ ǥ���ϴ� ����� ��
public class SumOfN2 {
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
