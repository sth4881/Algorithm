package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ1003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] arr = new long[n][2];
		for(int i=0; i<n; i++) {
			int input = sc.nextInt();
			if(input==0) {
				arr[i][0] = 1;
				arr[i][1] = 0;
			} else if(input==1) {
				arr[i][0] = 0;
				arr[i][1] = 1;
			}
			else {
				long[][] zeroone = new long[input+1][2];
				zeroone[0][0] = 1L; zeroone[1][0] = 0L;
				zeroone[0][1] = 0L; zeroone[1][1] = 1L;
				for(int j=2; j<=input; j++) {
					zeroone[j][0] = zeroone[j-1][0] + zeroone[j-2][0];
					zeroone[j][1] = zeroone[j-1][1] + zeroone[j-2][1];
				}
				arr[i][0] = zeroone[input][0];
				arr[i][1] = zeroone[input][1];
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
	}
}
