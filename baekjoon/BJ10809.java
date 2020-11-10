package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // 입력받을 문자열
		String[] sub = new String[s.length()];
		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] ans = new int[26];
		for(int i=0; i<26; i++) // 알파벳에 대응하는 숫자 배열, -1로 초기화
			ans[i] = -1; // -1로 초기화
		for(int j=0; j<s.length(); j++)
			sub[j] = s.substring(j, j+1); // 입력받은 문자열을 슬라이싱
		for(int k=0; k<sub.length; k++) { // 입력받은 문자열 전체를 대상으로
			for(int l=0; l<abc.length; l++) { // 알파벳 전체를 대상으로
				// System.out.println(sub[k] + " " + abc[l]);
				if(ans[l] == -1 && sub[k].equals(abc[l])) {// 문자열과 알파벳이 일치하면
					ans[l] = k;
					break;
				}
			}
		}
		for(int x=0; x<26; x++)
			System.out.print(ans[x] + " ");
	}
}
