package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ2920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[8];
		int count = 0;
		
		for(int i=0; i<8; i++)
			arr[i] = sc.nextInt();
		
		// ascending
		for(int j=0; j<8; j++) {
			if(arr[j] == j+1)
				count++;
			if(count == 8) {
				System.out.println("ascending");
				return;
			}
		}
		count = 0;
		
		// descending
		for(int k=0; k<8; k++) {
			if(arr[k] == 8-k)
				count++;
			if(count == 8) {
				System.out.println("descending");
				return;
			}
		}
		
		// mixed
		System.out.println("mixed");
	}
}