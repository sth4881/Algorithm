package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // �Է¹��� ���ڿ�
		String[] sub = new String[s.length()];
		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int[] ans = new int[26];
		for(int i=0; i<26; i++) // ���ĺ��� �����ϴ� ���� �迭, -1�� �ʱ�ȭ
			ans[i] = -1; // -1�� �ʱ�ȭ
		for(int j=0; j<s.length(); j++)
			sub[j] = s.substring(j, j+1); // �Է¹��� ���ڿ��� �����̽�
		for(int k=0; k<sub.length; k++) { // �Է¹��� ���ڿ� ��ü�� �������
			for(int l=0; l<abc.length; l++) { // ���ĺ� ��ü�� �������
				// System.out.println(sub[k] + " " + abc[l]);
				if(ans[l] == -1 && sub[k].equals(abc[l])) {// ���ڿ��� ���ĺ��� ��ġ�ϸ�
					ans[l] = k;
					break;
				}
			}
		}
		for(int x=0; x<26; x++)
			System.out.print(ans[x] + " ");
	}
}
