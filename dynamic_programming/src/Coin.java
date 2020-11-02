package com.algorithm.dp;

import java.util.Scanner;

public class Coin {
	// �Ž������� �����ִ� ���(������ ������ ���� ���)
	// ���� ū ������ ������ ����ϴ� ���� ������� �ʴ� ���� ����
	public static int func(int m, int n, int[] coin) { // m=�� �Ž�����, n=������ ���� ��
		int[][] arr = new int[m+1][n+1];
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(j==0) arr[i][j] = 0; // �Ž��� �� ������ �ϳ��� ���� ���� �Ž������� �� ���� ���� ��Ȳ(�Ұ����� ��Ȳ)
				else if(i==0) arr[i][j] = 1; // �Ž������� �������� �ʴ� ���� �Ž������� �ʴ� ���(i=j)�� �ϳ��� ������� ����
				else if(i<coin[j]) arr[i][j] = arr[i][j-1]; // �Ž������� �Ž����� ���� �������� ���� ���, 
															  // arr[i-coin[j]][j]�� ����� �� �����Ƿ� arr[i][j-1] ����
				else arr[i][j] = arr[i-coin[j]][j] + arr[i][j-1]; // ���� ��� ��츦 �������� �� arr[i][j]��
																	// �Ž������� ���� ū ������ �Ž����� ���(arr[i-coin[j]][j])
																	// +
																	// �Ž������� ���� ū ������ �Ž������� ���� ���(arr[i][j-1])
																	// �� ���� ���� ������ ���� ����
			}
		}
		return arr[m][n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // �Ž�������ϴ� �� �Ž�����
		int n = sc.nextInt(); // ������ ���� ����
		int[] coin = new int[n+1]; // �Ž������� ������ ���ҷ� ������ �迭
		coin[0] = 0; // �Ž����� ������ �������� ���� ��츦 ����ϱ� ����
		for(int i=1; i<=n; i++)
			coin[i] = sc.nextInt(); // �Ž����� ������ ���� �Է�
		System.out.println("�Ž����� �� �ִ� ����� �� : " + func(m, n, coin));
	}
}
