package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ4344 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		float[] ans = new float[c];
		int temp; int[] arr;
		float sum = 0;
		float avg = 0;
		int count = 0;
		
		for(int i=0; i<c; i++) { // 테스트 케이스 개수만큼 반복
			temp = sc.nextInt();
			arr =  new int[temp];
			for(int j=0; j<arr.length; j++) // 케이스의 길이만큼 반복
				arr[j] = sc.nextInt();
			for(int k=0; k<arr.length; k++) // 평균 계산
				sum += arr[k];
			avg = sum/arr.length;
			for(int l=0; l<arr.length; l++) { // 평균을 넘는 학생들의 비율 계산
				if(arr[l] > avg) count++;
			}
			ans[i] = (float)count/(float)arr.length*100;
			sum = 0; avg = 0; count = 0;
		}
		
		for(int m=0; m<c; m++) {
			System.out.printf("%.3f%%", ans[m]);
			System.out.println();
		}
	}
}
