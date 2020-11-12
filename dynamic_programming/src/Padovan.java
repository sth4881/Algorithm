package com.algorithm.dp;

import java.util.Scanner;

public class Padovan {
	public static long func(int n) {
		long[] arr = new long[n+1];
		arr[1] = 1;
		for(int i=2; i<=n; i++) {
			if(i-1>0) {
				arr[i] += arr[i-1];
				if(i-5==-1)
					arr[i] += 1;
				else if(i-5>0)
					arr[i] += arr[i-5];
			}
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] ans = new long[n];
		for(int i=0; i<n; i++) {
			int input = sc.nextInt();
			ans[i] = func(input);
		}
		for(int i=0; i<n; i++)
			System.out.println(ans[i]);
	}
}