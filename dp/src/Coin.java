package com.algorithm.dp;

import java.util.Scanner;

public class Coin {
	// 거스름돈을 나눠주는 방법(동전이 무한히 있을 경우)
	// 가장 큰 단위의 동전을 사용하는 경우와 사용하지 않는 경우로 분할
	public static int func(int m, int n, int[] coin) { // m=총 거스름돈, n=동전의 단위 수
		int[][] arr = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(j==0) arr[i][j] = 0; // 거슬러 줄 동전이 하나도 없는 경우로 거스름돈을 줄 수가 없는 상황(불가능한 상황)
				else if(i==0) arr[i][j] = 1; // 거스름돈이 존재하지 않는 경우로 거슬러주지 않는 경우(i=j)를 하나의 방법으로 생각
				else if(i<coin[j]) arr[i][j] = arr[i][j-1]; // 거스름돈이 거슬러줄 돈의 단위보다 작은 경우, 
															  // arr[i-coin[j]][j]은 사용할 수 없으므로 arr[i][j-1] 대입
				else arr[i][j] = arr[i-coin[j]][j] + arr[i][j-1]; // 위의 모든 경우를 제외했을 때 arr[i][j]는
																	// 거스름돈의 가장 큰 단위로 거슬러준 경우(arr[i-coin[j]][j])
																	// +
																	// 거스름돈의 가장 큰 단위로 거슬러주지 않은 경우(arr[i][j-1])
																	// 두 가지 경우로 나눠서 분할 가능
			}
		}
		return arr[m][n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 거슬러줘야하는 총 거스름돈
		int n = sc.nextInt(); // 동전의 단위 개수
		int[] coin = new int[n+1]; // 거스름돈의 단위를 원소로 가지는 배열
		coin[0] = 0; // 거슬러줄 동전이 존재하지 않을 경우를 고려하기 위함
		for(int i=1; i<=n; i++)
			coin[i] = sc.nextInt(); // 거슬러줄 동전의 단위 입력
		System.out.println("거슬러줄 수 있는 방법의 수 : " + func(m, n, coin));
	}
}
