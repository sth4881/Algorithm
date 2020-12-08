package com.baekjoon;

import java.util.Scanner;

public class BJ2579 {
	public static void func(int n, int[] cost) {
		int sum = cost[n];
		int cnt = 1;
		for(int i=n; i>1; i--) {
			if(i==2) {
				if(cnt!=2) sum += cost[i-1]; // ���� ����� ����
				else break;
			}
			else if(cnt==2) { // �����ؼ� 2����� ����� ���
				sum += cost[i-2];
				cnt = 1;
				i--;
			} else {
				if(cost[i-1]>=cost[i-2]) { // ���� ����� �ٴ��� ��ܺ��� Ŭ ��� sum�� ����
					sum += cost[i-1];
					cnt++;
				} else { // �ٴ��� ����� ���� ��ܺ��� Ŭ ��� sum�� ���� + cnt�� 1�� ����
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
