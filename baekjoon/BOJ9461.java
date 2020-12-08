package com.baekjoon;

import java.util.Scanner;

public class BJ9461 {
	public static long func(int n) {
		long[] arr = new long[n+1];
		arr[1] = 1; // 시작하는 삼각형의 변의 길이를 1로 초기화
		for(int i=2; i<=n; i++) { // func(i) = func(i-1) + func(i-5)와 같은 구조를 갖는다
			if(i-1>0) { // i-1<=0이면 func(i-1)과 func(i-5)를 구할 수 없으므로 i-1>0이어야함
				arr[i] += arr[i-1]; // i-1>0이 성립하면 arr[i] = arr[i] + arr[i-1] 수행
				if(i-5==-1) // i==4인 경우에 arr[4] = arr[3] + arr[-1]이 수행되므로 arr[-1]을 대입하는 대신 1을 대입해서 예외 처리 
					arr[i] += 1;
				else if(i-5>0) // i-5>0은 i-1>0이 수행된다는 전제 하에 수행되므로 수행시간을 줄이기 위해서 중첩 if문으로 작성
					arr[i] += arr[i-5]; // i-5>0이 성립하면 arr[i] = arr[i] + arr[i-5] 수행
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