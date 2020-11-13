package com.algorithm.dp;

import java.util.Scanner;

public class SumOfN3 {
	// 숫자 n을 1부터 k까지의 숫자들의 합으로 표현하는 방법의 수(단, 더해지는 숫자들의 순서는 고려하지 않는다)
	// if~else문이 실행되는 횟수는 이중 for문에 의해 n*k에 비례한다. 따라서 도출되는 시간복잡도는 O(nk)
	public static int func(int n, int k) {
		int[][] arr = new int[n+1][k+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=k; j++) {
				if(j==0) arr[i][j] = 0; // 범위가 1부터 n까지인데, n이 1보다 작을 수 없으므로 이 경우는 없다고 가정
				else if(i==0) arr[i][j] = 1; // n=0인 경우는 base case이므로 값을 1로 정의
				else if(i<j) arr[i][j] = arr[i][i]; // i<j인 경우에는 표현할 수 있는 방법이 없으므로 arr[i][i]의 값을 대입
				else arr[i][j] = arr[i-j][j] + arr[i][j-1]; // 위의 경우를 제외한 모든 경우에 대해서 j를 사용하는 경우(arr[i-j][j])와 
															// j를 사용하지 않는 경우(arr[i][j-1])의 합으로 분리하여 재귀적으로 수행
			}
		}
		return arr[n][k];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(n+"를 1부터 "+k+"까지의 숫자들의 합으로 표현할 때, 더해지는 숫자들의 순서를 고려하지 않고 표현하는 방법의 수 : "+func(n,k));
	}
}
