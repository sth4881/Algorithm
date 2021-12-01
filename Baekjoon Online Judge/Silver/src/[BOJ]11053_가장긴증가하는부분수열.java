package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11053 {
	public static void func(int[] arr, int n) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int[] dp = new int[n];
			for(int i=0; i<n; i++)
				dp[i] = 1; // �ڱ��ڽ� �����κ����� �Ÿ��� 1�̹Ƿ� ��� ���� 1�� �ʱ�ȭ
			
			for(int i=1; i<n; i++) {
				int max = Integer.MIN_VALUE;
				for(int j=0; j<i; j++) { // ���� ���� �ε������� ���� ���� �ε����� ���� �������
					if(arr[i]>arr[j]) { // ���߿��� ���� ũ�Ⱑ ���� ������ ���� ���� �������
						if(max<dp[j]) max = dp[j]; // �ִ밪�� ����
					}
				}
				if(max>0) dp[i] = max+1; // ������ �ִ밪�� +1 ���༭ ���̸� ����(��� ���ҿ� ���ؼ� +1�ϸ� �ȵǹǷ� max>0�� �������� ����)
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++)
				if(max<dp[i]) max = dp[i];
			bw.write(max+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String tmp = br.readLine();
			String[] tmparr = br.readLine().split(" ");
			
			int n = Integer.parseInt(tmp);
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(tmparr[i]);
			func(arr, n);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
