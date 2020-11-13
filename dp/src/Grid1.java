package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_1 {
	static int temp = -1;
	public static int func(int m, int n, int[][] arr) {
		int sum = 0;
		int sum1 = arr[m-1][0]; // ���� ������ ������ �ʱ�ȭ
		int sum2 = arr[0][n-1]; // ���� ������ ������ �ʱ�ȭ

		if(m==1) { // ���� �ϳ��� ������ ��� �� ���Ҹ� ��� ���ϴ� ������� ����ó��
			for(int j=0; j<n; j++)
				sum += arr[0][j];
			return sum;
		}
		if(n==1) { // ���� �ϳ��� ������ ��� �� ���Ҹ� ��� ���ϴ� ������� ����ó��
			for(int i=0; i<m; i++)
				sum += arr[i][0];
			return sum;
		}
		
		// ���� �������� ���� �������� �̵��ϴ� ���
		for(int i=m-1; i>=0; i--) { // ���� ������ ���� �ϴ��̹Ƿ� i=m-1���� 1���� �ö󰡴� ��� ���
			for(int j=0; j<=n-1; j++) { // j�� ���ʿ��� ���������� �̵��ϹǷ� 0���� n-1���� �̵��ϴ� ��� ���
				if(temp>-1) { // temp�� j���� 0�̻� ���� ���� ��쿡�� if�� ����
					j = temp; // i���� ���ŵǸ� j�� 0���� �����ϹǷ� temp�� �����ص״� ���� j�� �����������ν� �� ��ġ ����
					temp = -1; // temp�� ����Ǹ� �ȵǹǷ� ���� -1�� ����
				}
				if(i>0 && j==n-1) { // ���� ������ �� ��� �������� �̵� ����+ ������ ������ ���� ��� �������θ� �̵�
					sum1 += arr[i-1][j]; // ���� ���Ҹ� sum�� ���ϱ�
					temp = j; // j���� ������ä ���� -1���ֱ� ���ؼ� ���� ���� temp�� �ӽ÷� ���� ����
					break; // j���� �����ϰ� i���� �������ֱ� ���ؼ� �ش� �ݺ����� ��������
				}
				else if(j<n-1 && i==0) { // ������ ������ �� ��� ���������� �̵� ���� + ���� ������ ���� ��� ���������θ� �̵� ����
					sum1 += arr[i][j+1]; // ������ ���Ҹ� sum�� ���ϱ�
				}
				else if(i>0 && j<n-1) { // �ش� ���Ұ� ������ ���� ���� ���� �Ϲ����� ��쿡 ���� ó��
					if(arr[i][j+1] < arr[i-1][j])// �������� ���ʺ��� �۴ٸ� ���������� �̵�
						sum1 += arr[i][j+1]; // ������ ���Ҹ� sum�� ���ϱ�
					else { // ������ �����ʺ��� �۴ٸ� ���� �̵�
						sum1 += arr[i-1][j]; // ���� ���Ҹ� sum�� ���ϱ�
						temp = j; // j���� ������ä ���� -1���ֱ� ���ؼ� ���� ���� temp�� �ӽ÷� ���� ����
						break; // j���� �����ϰ� i���� �������ֱ� ���ؼ� �ش� �ݺ����� ��������
					}
				}
			}
		}
		
		// ���� �������� ���� �������� �̵��ϴ� ���
		for(int i=0; i<m; i++) { // ���� ������ ���� ����̹Ƿ� i=0���� m-1���� �ö󰡴� ��� ���
			for(int j=n-1; j>0; j--) { // j�� �����ʿ��� �������� �̵��ϹǷ� n-1���� 0���� �̵��ϴ� ��� ���
				if(temp>-1) { // temp�� j���� 0�̻� ���� ���� ��쿡�� if�� ����
					j = temp; // i���� ���ŵǸ� j�� 0���� �����ϹǷ� temp�� �����ص״� ���� j�� �����������ν� �� ��ġ ����
					temp = -1; // temp�� ����Ǹ� �ȵǹǷ� ���� -1�� ����
				}
				if(j==0) { // ���� ������ ���� ���, �Ʒ������θ� �̵��Ѵ�.
					sum2 += arr[i+1][j]; // �Ʒ��� ���Ҹ� sum�� ���ϱ�
					temp = j; // j���� ������ä ���� +1���ֱ� ���ؼ� ���� ���� temp�� �ӽ÷� ���� ����
					break;
				}
				else if(i==m-1) { // �Ʒ��� ������ ���� ���, �������θ� �̵��Ѵ�.
					sum2 += arr[i][j-1]; // ���� ���Ҹ� sum2�� ���ϱ�
				}
				else { 
					// ���� ���ܵ��� ������ �Ϲ����� ����, ���� ���ҿ� �Ʒ��� ���Ҹ� ���ؼ�
					// �� ���� ���� sum�� �����ְ� �������� ��ġ�� �̵��Ѵ�.
					if(arr[i][j-1] < arr[i+1][j]) // ���� ���Ұ� �Ʒ��� ���Һ��� ���� ���
						sum2 += arr[i][j-1]; // ���� ���Ҹ� sum2�� ���ϱ�
					else { // �Ʒ��� ���Ұ� ���� ���Һ��� ���� ���
						sum2 += arr[i+1][j]; // �Ʒ��� ���Ҹ� sum2�� ���ϱ�
						temp = j; // j���� ������ä ���� +1���ֱ� ���ؼ� ���� ���� temp�� �ӽ÷� ���� ����
						break;
					}
				}
			}
		}
		return Math.min(sum1, sum2); // �� ���� ��� �߿��� �� ���� ���� ��ȯ
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
