package com.assignment.no5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment5_1 {
	public static int func(int n, int[] ud, int[] ld, int[] utol, int[] ltou) {
		int[][] dp = new int[2][n+2]; // ������ ���̰� n+1���� �̾����Ƿ� �� n+2�ִٰ� �����ؾ���
		for(int i=1; i<=n; i++) { // hotel�� �̵��ϴ� ���� �������� �����Ƿ� dp[0][0]=0, dp[1][0]=0
			dp[0][i] = Math.min(dp[0][i-1]+ud[i], dp[1][i-1]+ld[i]+ltou[i]);
			// dp[0][i] = ���ʿ��� ���� ���(���� ��ġ�� ���� �����α��� ���µ� �ɸ��� �ּ� �ð� dp[0][i-1] 
			//				 + ���� �����ο��� ���� �����α��� ���µ� �ɸ��� �ð� ud[i])
			//				 vs
			//				 �Ʒ��ʿ��� ���� ���(���� ��ġ�� ���� �밢�� �����α��� ���µ� �ɸ��� �ּ� �ð� dp[1][i-1]
			//				 + ���� ��ġ�� ���� �밢�� �����ο��� ���� ��ġ�� �Ʒ��� �����α��� ���µ� �ɸ��� �ð� ld[i]
			//				 + �Ʒ��� �����ο��� ���� �����α��� ���µ� �ɸ��� �ð� ltou[i])

			dp[1][i] = Math.min(dp[1][i-1]+ld[i], dp[0][i-1]+ud[i]+utol[i]);
			// dp[1][i] = ���ʿ��� ���� ���(���� ��ġ�� ���� �����α��� ���µ� �ɸ��� �ּ� �ð� dp[1][i-1] 
			//				 + ���� �����ο��� ���� �����α��� ���µ� �ɸ��� �ð� ld[i])
			//				 vs
			//				 ���ʿ��� ���� ���(���� ��ġ�� ���� �밢�� �����α��� ���µ� �ɸ��� �ּ� �ð� dp[0][i-1]
			//				 + ���� ��ġ�� ���� �밢�� �����ο��� ���� ��ġ�� ���� �����α��� ���µ� �ɸ��� �ð� ud[i]
			//				 + ���� �����ο��� ���� �����α��� ���µ� �ɸ��� �ð� utol[i])
		}
		dp[0][n+1] = dp[0][n]+ud[n+1]; // ���� �ö���� �ʰ� �ٷ� �������� ���� ��츸 �����ϹǷ� �̿� ���� ����ó��
		dp[1][n+1] = dp[1][n]+ld[n+1]; // �Ʒ��� �������� �ʰ� �ٷ� �������� ���� ��츸 �����ϹǷ� �̿� ���� ����ó��
		return Math.min(dp[0][n+1], dp[1][n+1]); // ���� �� �� �߿��� �� ���� ���� �����ؼ� ��ȯ
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String size = bufReader.readLine(); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			int n = Integer.parseInt(size);
			String[] upper = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			String[] lower = bufReader.readLine().split(" ");
			String[] utol = bufReader.readLine().split(" ");
			String[] ltou = bufReader.readLine().split(" ");
			
			int[] ud = new int[n+2];
			int[] ld = new int[n+2];
			int[] ul = new int[n+1];
			int[] lu = new int[n+1];
			
			for(int i=1; i<=n+1; i++) { // u[0], l[0]�� ���� 0�̹Ƿ� �װ͵��� �����ؼ� ����
				ud[i] = Integer.parseInt(upper[i-1]);
				ld[i] = Integer.parseInt(lower[i-1]);
			}
			for(int i=1; i<=n; i++) { // ul[0],0 lu[0]�� ���� 0�̹Ƿ� �װ͵��� �����ؼ� ����
				ul[i] = Integer.parseInt(utol[i-1]);
				lu[i] = Integer.parseInt(ltou[i-1]);
			}

			System.out.println(func(n, ud, ld, ul, lu));
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
