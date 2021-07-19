package com.algorithm.dp;

import java.util.Scanner;

public class Fibonacci {
	// �迭�� ����� DP �Ǻ���ġ ����
	// arr[i] = arr[i-1] + arr[i-2]; ������ ����Ǵ� Ƚ���� ���� for���� ���ؼ� n*k�� ���
	// ���� ����Ǵ� �ð����⵵�� O(n)����, ��͸� ����� �Ǻ���ġ �������� �ð����⵵ ����
	public static int withArr(int n) {
		int[] arr = new int[n+1];
		arr[0] = 0; // ������ ���� ���� �Ǻ���ġ ������ �����ϱ� ���� ù��° ���� �ʱ�ȭ
		arr[1] = 1;  // ���� ���� �Ǻ���ġ ������ �����ϱ� ���� �ι�° ���� �ʱ�ȭ
		for(int i=2; i<=n; i++)
			arr[i] = arr[i-1] + arr[i-2]; // arr[2]���� arr[n]������ ���� ������ ���� ���� ���� ���� ���� �ȴ�
		return arr[n];
	}
	// �迭�� ������� ���� DP �Ǻ���ġ ����
	// �� �޼ҵ�� �޸� �迭�� ������� �����Ƿ� �޸� ȿ���� ����
	// ����Ǵ� �ð����⵵�� ���� ���������� O(n)
	public static int withNoArr(int n) {
		int preprev = 0; // ������ ���� ���� �Ǻ���ġ ������ �����ϱ� ���� ù��° ���� �ʱ�ȭ
		int prev = 1; // ���� ���� �Ǻ���ġ ������ �����ϱ� ���� �ι�° ���� �ʱ�ȭ
		int cur = 0; // ù��° ���ڿ� �ι�° ���ڸ� ���ؼ� ��������� ��
		for(int i=2; i<=n; i++) {
			cur = prev + preprev;
			preprev = prev;
			prev = cur;
		}
		return cur;
	}
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(n+"��° �Ǻ���ġ ���� : " + withArr(n));
		System.out.println(n+"��° �Ǻ���ġ ���� : " + withNoArr(n));
		return;
	}
}
