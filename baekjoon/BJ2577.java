package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int result = a*b*c;
		
		String str = Integer.toString(result);
		int n = str.length();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			String temp = str.substring(i, i+1);
			int value = Integer.parseInt(temp);
			arr[i] = value;
		}
		
		int[] ans = {0,0,0,0,0,0,0,0,0,0};
		for(int j=0; j<10; j++) {
			for(int k=0; k<n; k++)
				if(arr[k]==j) ans[j]++;
		}
		for(int l=0; l<10; l++)
			System.out.println(ans[l]);
	}
}
