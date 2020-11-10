package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 숫자의 개수
		String input = sc.next(); // 숫자
		int sum = 0;
		
		for(int i=0; i<n; i++) // 숫자의 개수만큼 반복
			sum += Integer.parseInt(input.substring(i, i+1));
		System.out.println(sum);
	}
}