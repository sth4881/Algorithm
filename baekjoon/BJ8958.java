package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sub = 0; // O의 개수
		int[] count = new int[n];
		String[] ans = new String[n];
		
		for(int i=0; i<n; i++)
			ans[i] = sc.next();
		for(int j=0; j<n; j++) {
			for(int k=0; k<ans[j].length(); k++) {
				if(ans[j].substring(k, k+1).equals("X"))
					sub = 0; // X가 나올 경우 sub 초기화
				else if(k>0 && (ans[j].substring(k-1, k).equals("O"))) { 
					sub++; // O가 나왔으므로 sub++
					count[j] += sub; // 현재까지 나온 O의 개수만큼 더해줌
				}
				else if(ans[j].substring(k, k+1).equals("O")) {
					count[j]++; sub++; // O가 처음 나왔으므로 sub++
				}
			}
			sub = 0;
		}
		for(int l=0; l<n; l++)
			System.out.println(count[l]);
	}
}
