package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment1_3 {
	public static void func(int n, int k, int[] stairs) {
		int[] arr = new int[n+1];
		arr[0] = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.MAX_VALUE; // �迭�� �������ִ� ��� 0���� �ڵ� �ʱ�ȭ�Ǵµ�
												  // �Ʒ��� if���� 0�� �񱳵Ǵ� ���� �����ֱ� ���ؼ� �ִ����� ����
			for(int j=0; j<k; j++) {
				// �˰����� �ٽ� �ڵ�
				if( i>=stairs[j] && arr[i]>arr[i-stairs[j]] ) // i-stairs[j]�� 0�� �� �� �����Ƿ� i>=stairs[j],
																  // stairs[0]~stairs[k-1] �߿��� � ����� ����ؾ�
																  // �ּ� ����� ��� ��찡 �Ǵ����� �� �� �����Ƿ� 
																  // arr[i]>arr[i-stairs[j]]�� ��츦 �ּ� ����� ���� ����� ���� ����
					arr[i] = arr[i-stairs[j]]+1; // �ѹ��� stairs[j]��ŭ ����� �ö󰡸� ����� 1ȸ ���� ���̹Ƿ� +1,
												   // �߰��� i���� ����� �ѹ��� �ö󰡱� ���� �ּ� ��� �� arr[i-stairs[j]]��ŭ ������ 
			}
		}
		for(int i=1; i<=n; i++)
			if(arr[i]==Integer.MAX_VALUE) arr[i] = -1; // MAX_VALUE�� ���� �־��� ��� ������δ� �ö� �� ������ �ǹ��ϹǷ� -1 ����
		System.out.println(arr[n]);
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] temp = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			int n = Integer.parseInt(temp[0]); // �ö󰡾��ϴ� �� ��� ��
			int k = Integer.parseInt(temp[1]); // �ö� �� �ִ� ����� ���� ����
			String[] input = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			
			int[] stairs = new int[k];
			for(int i=0; i<k; i++)
				stairs[i] = Integer.parseInt(input[i]); // 1ȸ�� �ö� �� �ִ� ����� ���� ����
			
			func(n, k, stairs);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
