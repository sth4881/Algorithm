package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ15596 {
	 long sum(int[] a) {
		long result = 0;
		for(int i=0; i<a.length; i++)
			result += a[i];
		return result;
	}
	
	public static void main(String[] args) {
		BJ15596 ex = new BJ15596();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<a.length; i++)
			a[i] = sc.nextInt();
		ex.sum(a);
	}
}
