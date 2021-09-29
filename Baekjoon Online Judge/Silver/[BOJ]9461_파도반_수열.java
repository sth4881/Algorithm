package com.baekjoon;

import java.util.Scanner;

public class BJ9461 {
	public static long func(int n) {
		long[] arr = new long[n+1];
		arr[1] = 1; // �����ϴ� �ﰢ���� ���� ���̸� 1�� �ʱ�ȭ
		for(int i=2; i<=n; i++) { // func(i) = func(i-1) + func(i-5)�� ���� ������ ���´�
			if(i-1>0) { // i-1<=0�̸� func(i-1)�� func(i-5)�� ���� �� �����Ƿ� i-1>0�̾����
				arr[i] += arr[i-1]; // i-1>0�� �����ϸ� arr[i] = arr[i] + arr[i-1] ����
				if(i-5==-1) // i==4�� ��쿡 arr[4] = arr[3] + arr[-1]�� ����ǹǷ� arr[-1]�� �����ϴ� ��� 1�� �����ؼ� ���� ó�� 
					arr[i] += 1;
				else if(i-5>0) // i-5>0�� i-1>0�� ����ȴٴ� ���� �Ͽ� ����ǹǷ� ����ð��� ���̱� ���ؼ� ��ø if������ �ۼ�
					arr[i] += arr[i-5]; // i-5>0�� �����ϸ� arr[i] = arr[i] + arr[i-5] ����
			}
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] ans = new long[n];
		for(int i=0; i<n; i++) {
			int input = sc.nextInt();
			ans[i] = func(input);
		}
		for(int i=0; i<n; i++)
			System.out.println(ans[i]);
	}
}