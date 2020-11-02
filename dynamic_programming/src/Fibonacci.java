package com.algorithm.dp;

import java.util.Scanner;

public class Fibonacci {
	// 배열을 사용한 DP 피보나치 수열
	// arr[i] = arr[i-1] + arr[i-2]; 구문이 실행되는 횟수는 이중 for문에 의해서 n*k에 비례
	// 따라서 도출되는 시간복잡도는 O(n)으로, 재귀를 사용한 피보나치 수열보다 시간복잡도 좋음
	public static int withArr(int n) {
		int[] arr = new int[n+1];
		arr[0] = 0; // 이전의 이전 수로 피보나치 수열을 적용하기 위한 첫번째 수로 초기화
		arr[1] = 1;  // 이전 수로 피보나치 수열을 적용하기 위한 두번째 수로 초기화
		for(int i=2; i<=n; i++)
			arr[i] = arr[i-1] + arr[i-2]; // arr[2]부터 arr[n]까지의 수는 이전의 이전 수와 이전 수의 합이 된다
		return arr[n];
	}
	// 배열을 사용하지 않은 DP 피보나치 수열
	// 위 메소드와 달리 배열을 사용하지 않으므로 메모리 효율이 좋음
	// 도출되는 시간복잡도는 위와 마찬가지로 O(n)
	public static int withNoArr(int n) {
		int preprev = 0; // 이전의 이전 수로 피보나치 수열을 적용하기 위한 첫번째 수로 초기화
		int prev = 1; // 이전 수로 피보나치 수열을 적용하기 위한 두번째 수로 초기화
		int cur = 0; // 첫번째 숫자와 두번째 숫자를 더해서 만들어지는 수
		for(int i=2; i<=n; i++) {
			cur = prev + preprev;
			preprev = prev;
			prev = cur;
		}
		return cur;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(n+"번째 피보나치 수열 : " + withArr(n));
		System.out.println(n+"번째 피보나치 수열 : " + withNoArr(n));
		return;
	}
}
