package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* ���� 2579�� ��ܿ����� (Silver) */
public class BOJ2579 {
	public static void func(int[] cost, int n) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			if(n==1) bw.write(cost[1]+"\n"); // n�� 1�� ��쿡 ���� ����ó��
			else {
				int[] dp = new int[n+1];
				dp[1] = cost[1];
				dp[2] = cost[1]+cost[2]; // �ι�° ��ܱ����� �������� ���� �� �����Ƿ� ù��° ��ܰ� �ι�° ����� ���ϸ� �ȴ�.
				
				for(int i=3; i<=n; i++)
					dp[i] = Math.max(cost[i]+dp[i-2], cost[i]+cost[i-1]+dp[i-3]); // i��° ��ܱ��� �ö��� �� ���� �� �ִ� �ִ� ������
																								// i��° ����� ���� + i-2��° ��ܱ��� �ö��� �� ���� �� �ִ� �ִ� ������
																								// i��° ����� ���� + i-1��° ����� ���� + i-3��° ��ܱ��� �ö��� �� ���� �� �ִ� �ִ� ������
																								// ���ؼ� �� ū ���� �ִ� ������ �����ϸ� �ȴ�.
				bw.write(dp[n]+"\n");
			}
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
			int n = Integer.parseInt(tmp);
			int[] cost = new int[n+1];
			for(int i=1; i<n+1; i++) {
				tmp = br.readLine();
				cost[i] = Integer.parseInt(tmp);
			}
			func(cost, n);
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	} 
}
