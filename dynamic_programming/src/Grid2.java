package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_2 {
	public static int func(int m, int n, int[][] grid) {
		int sum = 0;
		if(n==1) { // ���� �ϳ��� ������ ��� ������ ���ҵ��� ��� �������ν� ����ó��
			for(int i=0; i<m; i++)
				sum += grid[i][0];
			return sum;
		}
		
		if(m==1) { // ���� �ϳ��� ������ ��� ���ҵ� �߿��� ���� ���� ���� ��ȯ�����ν� ����ó��
			int min = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				if(grid[0][j] < min)
					min = grid[0][j];
			}
			return min;
		}

		// ����� ó���ϱ� ���� �迭 ����
		int[][] arr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = grid[i][j];
			}
		}

		// �˰���
		for(int i=m-2; i>=0; i--) {
			for(int j=0; j<n; j++) {
				if(j==0) { // ���� �� ������ ����� ó���ϴ� ���
					if(arr[i+1][j] < arr[i+1][j+1]) // �Ʒ��ʰ� ���� �ϴܿ� �ִ� ���Ҹ� ���ؼ� ���� ���� ���ϱ�
						arr[i][j] += arr[i+1][j];
					else arr[i][j] += arr[i+1][j+1];
				}
				else if(j==n-1) { // ������ �� ������ ����� ó���ϴ� ���
					if(arr[i+1][j] < arr[i+1][j-1]) // �Ʒ��ʰ� ���� �ϴܿ� �ִ� ���Ҹ� ���ؼ� ���� ���� ���ϱ�
						arr[i][j] += arr[i+1][j];
					else arr[i][j] += arr[i+1][j-1];
				}
				else { 
					// ���� ���ܵ��� ������ �Ϲ����� ����
					// ���� �ϴ� ���ҿ� ���� �ϴ� ���ҿ� �Ʒ��� ���Ҹ� ���ؼ� ���� ���� ���ϱ�
					if(arr[i+1][j-1] < arr[i+1][j]) {
						if(arr[i+1][j-1] < arr[i+1][j+1])
							arr[i][j] += arr[i+1][j-1];
						else arr[i][j] += arr[i+1][j+1];
					} else {
						if(arr[i+1][j] < arr[i+1][j+1])
							arr[i][j] += arr[i+1][j];
						else arr[i][j] += arr[i+1][j+1];
					}
				}
			}
		}

		// ���� ���� �࿡�� �ּҰ��� ���� ���Ҹ� ��ȯ
		int min = Integer.MAX_VALUE;
		for(int j=0; j<n; j++) {
			if(arr[0][j] < min)
				min = arr[0][j];
		}
		return min;
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
