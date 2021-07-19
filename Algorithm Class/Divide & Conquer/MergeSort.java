package com.algorithm.dnc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort {
	public static void mergeSort(int[] arr, int first, int last) {
		if(first<last) {
			int mid = (first+last)/2; // �����ϱ� ���ؼ� �߰��� ����
			mergeSort(arr, first, mid); // ���� �׷����� ����
			mergeSort(arr, mid+1, last); // ������ �׷����� ����
			merge(arr, first, mid, last); // ������ �׷���� �ٽ� ����
		}
	}
	public static void merge(int[] arr, int first, int mid, int last) {
		int left = first; // arr[first]~arr[mid]
		int right = mid+1; // arr[mid+1]~arr[last]
		int[] temp = new int[arr.length]; // �����ϱ� ���� �ӽ� �迭 ����
		int cnt = left; // temp�� �ε����� count�ϱ� ���� ���� 
		
		while(left<=mid && right <= last) { 
			if(arr[left] <= arr[right]) { // ������ ���Ұ� ���� ���Һ��� �� ��� ���� ���� ����
				temp[cnt] = arr[left];
				left++;
			} else { // ���� ���Ұ� ������ ���Һ��� �� ��� ������ ���� ����
				temp[cnt] = arr[right];
				right++;
			}
			cnt++; // � ���Ұ� �̱�� ���� ����� ���� ������ �غ��ؾ��ϹǷ� �ε��� ����
		}
		
		// ������ ���߼� �̱� �׷��� �״�� �����´�
		if(left <= mid) { // ���� �׷��� ������ �׷��� �̰ܼ� �������� ���
			for(int i=left; i<=mid; i++) { // �����ִ� ���� ���ҵ��� ó������ ������
				temp[cnt] = arr[i];
				cnt++;
			}
		} else { // ������ �׷��� ���� �׷��� �̰ܼ� �������� ���
			for(int i=right; i<=last; i++) { // �����ִ� ������ ���ҵ��� ó������ ������
				temp[cnt] = arr[i];
				cnt++;
			}
		}
		
		for(int i=first; i<=last; i++)
			arr[i] = temp[i]; // �ӽ� ������ ���ĵ� ���Ҹ� ���� �迭�� ���������� �����ؼ� ���� ������
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			int n = Integer.parseInt(bufReader.readLine()); // �׽�Ʈ ���̽��� ������ �Է¹ޱ� ���� ����
			String[] input = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			for(int i=0; i<n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			mergeSort(arr, 0, n-1);
			for(int i=0; i<n; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
