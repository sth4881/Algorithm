package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10]; // 입력받을 숫자 배열
		int[] ans = new int[10]; // 정답용 배열
		int count = 0;
		
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt(); // 10개의 숫자 입력받기
		for(int j=0; j<ans.length; j++)
			ans[j] = arr[j] % 42;
		for(int k=0; k<ans.length; k++) {
			for(int l=0; l<k; l++)
				if(ans[k] == ans[l]) count++;
		}
		System.out.println(ans.length-count);
	}
}
