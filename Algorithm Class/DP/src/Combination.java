package com.algorithm.dp;

import java.util.Scanner;

public class Combination {
	// nCk(n개 중에서 k를 뽑는 경우의 수)
	// = (n-1Ck-1(n을 뽑는 경우)) + (n-1Ck(n을 뽑지 않고 다른걸 뽑는 경우))
	// if~else 구문이 실행되는 횟수는 이중 for문에 의해서 n*k에 비례
	// 따라서 도출되는 시간복잡도는 O(nk)
	public static int func(int n, int k) {
		int[][] arr = new int[n+1][k+1]; // n과 k를 입력받으면 0~n-1, 0~k-1까지만 생성되기 때문에 n+1, k+1
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=Math.min(i, k); j++) { // j는 i를 절대로 넘으면 안되고(case : i=1, j=2), 
															// 1개 중에서 2개를 고르는 것은 불가능(j<=k의 경우 발생) 
															// j는 k를 절대로 넘으면 안된다(case : i=3, j=3), 
															// 2개를 골라야 하는데 3개를 골라버림(case : j<=i의 경우 발생)
															// 따라서 i와 k 중에서 더 작은 값을 조건으로 설정
				if(i==0 || j==0 || j==i) arr[i][j] = 1; // n개 중에서 0개를 뽑을 경우 : 1
															// 0개 중에서 k개를 뽑을 경우 : 1
															// n개 중에서 n개를 뽑을 경우 : 1
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		return arr[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(n+"개 중에서 "+k+"개를 선택하는 경우의 수 : "  + func(n,k));
		return;
	}
}
