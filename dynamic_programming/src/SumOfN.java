package com.algorithm.dp;

import java.util.Scanner;

//숫자 N을 1부터 K까지의 숫자들의 합으로 표현하는 경우의 수
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
		System.out.println("n의 합을 표현하는 방법의 수 : " + func(n));

	}
}
