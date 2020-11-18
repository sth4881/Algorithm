package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_1 {
	public static int func(int m, int n, int[][] arr) {
		int sum=0;
		if(n==1) { // ���� �ϳ��� ������ ��� ������ ���ҵ��� ��� �������ν� ����ó��
			for(int i=0; i<m; i++)
				sum += arr[i][0];
			return sum;
		}
		
		if(m==1) { // ���� �ϳ��� ������ ��� ���ҵ� �߿��� ���� ���� ���� ��ȯ�����ν� ����ó��
			int min = Integer.MAX_VALUE;
			for(int j=0; j<n; j++)
				sum += arr[0][j];
			return sum;
		}
		
		// ���� ���� �ִ� ���Ҵ� ������ �Ʒ��� ���� ��븸 ���ϹǷ� ���� ó��
		for(int i=m-2; i>=0; i--)
			arr[i][0] += arr[i+1][0];
		// �Ʒ��� ���� �ִ� ���Ҵ� ������ ���� ���� ��븸 ���ϹǷ� ���� ó��
		for(int j=1; j<n; j++)
			arr[m-1][j] += arr[m-1][j-1];
		// ���� ó���ϴ� ��츦 �����ϸ� �ش� ������ ���ʰ� �Ʒ��� ���Ҹ� ���ؼ�
		// �� ���� ���� ���� ���ҿ� ���ؼ� �����ϴ� ���
		for(int i=m-2; i>=0; i--) {
			for(int j=1; j<n; j++) {
				arr[i][j] += Math.min(arr[i+1][j], arr[i][j-1]);
			}
		}
		return arr[0][n-1]; // �� ���� ��� �߿��� �� ���� ���� ��ȯ
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] size = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			int m = Integer.parseInt(size[0]); // �ö󰡾��ϴ� ����� ����
			int n = Integer.parseInt(size[1]); // �ö󰡾��ϴ� ����� ����
			int[][] grid = new int[m][n];
			
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(input[j]);
				}
			}

			System.out.println(func(m, n, grid));
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
