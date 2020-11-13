package com.baekjoon;

import java.util.Scanner;

public class BJ2579 {
	public static void func(int n, int[] cost) {
		int sum = cost[n];
		int cnt = 1;
		for(int i=n; i>1; i--) {
			if(i==2) {
				if(cnt!=2) sum += cost[i-1]; // 다음 계단을 더함
				else break;
			}
			else if(cnt==2) { // 연속해서 2계단을 밟았을 경우
				sum += cost[i-2];
				cnt = 1;
				i--;
			} else {
				if(cost[i-1]>=cost[i-2]) { // 다음 계단이 다다음 계단보다 클 경우 sum에 더함
					sum += cost[i-1];
					cnt++;
				} else { // 다다음 계단이 다음 계단보다 클 경우 sum에 더함 + cnt는 1로 변경
					sum += cost[i-2]; 
					cnt=1;
					i--;
				}
			}
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cost = new int[n+1];
		for(int i=1; i<n+1; i++)
			cost[i] = sc.nextInt();
		func(n, cost);
	}
}
