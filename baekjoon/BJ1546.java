package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ1546 {
	public static void main(String[] args) {
		float max = Integer.MIN_VALUE;
		float sum = 0;
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float[] arr = new float[n];
		float[] ans = new float[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextFloat();
		
		for(int j=0; j<n; j++)
			if(arr[j] > max) max = arr[j];
		for(int k=0; k<n; k++) {
			arr[k] = arr[k]/max*100;
			sum += arr[k];
		}
		System.out.printf("%.2f", sum/n);
	}
}
