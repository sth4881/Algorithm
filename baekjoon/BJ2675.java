package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] temp;
		String[] ans = new String[t];
		for(int i=0; i<t; i++) { // 전체 테스트 케이스 개수
			ans[i] = "";
			int r = sc.nextInt(); // 반복 횟수 초기화
			String s = sc.next(); // 문자열 s 초기화
			temp = new String[s.length()];
			for(int j=0; j<s.length(); j++) // 입력받은 문자열의 크기만큼
				temp[j] = s.substring(j, j+1); // 문자열 슬라이싱해서 저장
			for(int k=0; k<s.length(); k++) {
				for(int l=0; l<r; l++)
					ans[i] += temp[k];
			}
		}
		for(int m=0; m<t; m++)
			System.out.println(ans[m]);
	}
}
