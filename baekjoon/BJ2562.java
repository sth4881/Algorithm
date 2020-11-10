package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ2562 { // BJ = BaekJun
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int temp=0;
		
		for(int i=0; i<9; i++)
			arr[i] = sc.nextInt();
		
		for(int j=0; j<9; j++) {
			if(arr[j] > max)
				max = arr[j];
		}
		
		for(int k=0; k<9; k++) {
			if(arr[k] == max)
				temp = k+1;
		}
		
		System.out.println(max);
		System.out.println(temp);
	}
}
