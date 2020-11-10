package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ10818 { // BJ = BaekJun
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();
		}
			
		for(int j=0; j<num; j++) {
			if(arr[j] > max)
				max = arr[j];
			if(arr[j] < min)
				min = arr[j];
		}
		
		System.out.println(min + " " + max);
	}
}
