package com.baekjoon;

import java.util.Scanner;

public class BJ10818_heapSort {
	public static void rebuildMaxHeap(int[] arr, int r, int n) {
		int cur = r;
		int bigger;
		while(cur*2+1 < n) { // ���� ���� �ڽ��� ������ �־�� ��(�ڽ� ��尡 ������ ���ϴ� �ǹ̰� ����)
			int left = cur*2+1;
			int right = left+1;
			// ���� ���� ���ϱ� ���ؼ� ���� �ڽ� ���� ������ �ڽ� ��� �߿��� ū ���� ����
			// ������ ��带 root ����� �����ϰ� ������ ��쿡 ���� ���� �����ϱ� ���� right<n
			if(right < n && arr[right] > arr[left])
				bigger = right;
			else bigger = left;
			if(arr[cur] < arr[bigger]) { // ���࿡ ���� ��庸�� �ڽ� ��尡 �� ũ�ٸ� ���� �ڸ��� ��ȯ�Ѵ�
				int temp = arr[cur];
				arr[cur] = arr[bigger];
				arr[bigger] = temp;
				cur = bigger; // ���� ������ �ݺ��ϱ� ���ؼ� ���� ��� �ε����� �ڽ� ��� �ε����� ����
			} else break;
		}
	}
	public static void rebuildMinHeap(int[] arr, int r, int n) {
		int cur = r;
		int smaller;
		while(cur*2+1 < n) { // ���� ���� �ڽ��� ������ �־�� ��(�ڽ� ��尡 ������ ���ϴ� �ǹ̰� ����)
			int left = cur*2+1;
			int right = left+1;
			// ���� ���� ���ϱ� ���ؼ� ���� �ڽ� ���� ������ �ڽ� ��� �߿��� ���� ���� ����
			// ������ ��带 root ����� �����ϰ� ������ ��쿡 ���� ���� �����ϱ� ���� right<n
			if(right < n && arr[right] < arr[left])
				smaller = right;
			else smaller = left;
			if(arr[cur] > arr[smaller]) { // ���࿡ ���� ��庸�� �ڽ� ��尡 �� �۴ٸ� ���� �ڸ��� ��ȯ�Ѵ�
				int temp = arr[cur];
				arr[cur] = arr[smaller];
				arr[smaller] = temp;
				cur = smaller; // ���� ������ �ݺ��ϱ� ���ؼ� ���� ��� �ε����� �ڽ� ��� �ε����� ����
			} else break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		for(int root = n/2-1; root>=0; root--)  // ������ ������ ��Ʈ������ ����(�� n/2�� ����)
			rebuildMinHeap(arr, root, n);
		System.out.print(arr[0] + " ");
		for(int root = n/2-1; root>=0; root--)  // ������ ������ ��Ʈ������ ����(�� n/2�� ����)
			rebuildMaxHeap(arr, root, n);
		System.out.println(arr[0]);
	}
}
