package com.algorithm.baekjoon;

import java.util.Scanner;

public class BJ2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String[] temp;
		String[] ans = new String[t];
		for(int i=0; i<t; i++) { // ��ü �׽�Ʈ ���̽� ����
			ans[i] = "";
			int r = sc.nextInt(); // �ݺ� Ƚ�� �ʱ�ȭ
			String s = sc.next(); // ���ڿ� s �ʱ�ȭ
			temp = new String[s.length()];
			for(int j=0; j<s.length(); j++) // �Է¹��� ���ڿ��� ũ�⸸ŭ
				temp[j] = s.substring(j, j+1); // ���ڿ� �����̽��ؼ� ����
			for(int k=0; k<s.length(); k++) {
				for(int l=0; l<r; l++)
					ans[i] += temp[k];
			}
		}
		for(int m=0; m<t; m++)
			System.out.println(ans[m]);
	}
}
