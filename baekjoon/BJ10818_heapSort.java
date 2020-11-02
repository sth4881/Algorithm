package com.baekjoon;

import java.util.Scanner;

public class BJ10818_heapSort {
	public static void rebuildMaxHeap(int[] arr, int r, int n) {
		int cur = r;
		int bigger;
		while(cur*2+1 < n) { // 현재 노드는 자식이 무조건 있어야 함(자식 노드가 없으면 비교하는 의미가 없음)
			int left = cur*2+1;
			int right = left+1;
			// 현재 노드와 비교하기 위해서 왼쪽 자식 노드와 오른쪽 자식 노드 중에서 큰 놈을 색출
			// 마지막 노드를 root 노드라고 가정하고 대입할 경우에 대한 오류 방지하기 위해 right<n
			if(right < n && arr[right] > arr[left])
				bigger = right;
			else bigger = left;
			if(arr[cur] < arr[bigger]) { // 만약에 현재 노드보다 자식 노드가 더 크다면 둘의 자리를 교환한다
				int temp = arr[cur];
				arr[cur] = arr[bigger];
				arr[bigger] = temp;
				cur = bigger; // 위의 과정을 반복하기 위해서 현재 노드 인덱스를 자식 노드 인덱스로 갱신
			} else break;
		}
	}
	public static void rebuildMinHeap(int[] arr, int r, int n) {
		int cur = r;
		int smaller;
		while(cur*2+1 < n) { // 현재 노드는 자식이 무조건 있어야 함(자식 노드가 없으면 비교하는 의미가 없음)
			int left = cur*2+1;
			int right = left+1;
			// 현재 노드와 비교하기 위해서 왼쪽 자식 노드와 오른쪽 자식 노드 중에서 작은 놈을 색출
			// 마지막 노드를 root 노드라고 가정하고 대입할 경우에 대한 오류 방지하기 위해 right<n
			if(right < n && arr[right] < arr[left])
				smaller = right;
			else smaller = left;
			if(arr[cur] > arr[smaller]) { // 만약에 현재 노드보다 자식 노드가 더 작다면 둘의 자리를 교환한다
				int temp = arr[cur];
				arr[cur] = arr[smaller];
				arr[smaller] = temp;
				cur = smaller; // 위의 과정을 반복하기 위해서 현재 노드 인덱스를 자식 노드 인덱스로 갱신
			} else break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		for(int root = n/2-1; root>=0; root--)  // 마지막 노드부터 루트노드까지 적용(총 n/2번 수행)
			rebuildMinHeap(arr, root, n);
		System.out.print(arr[0] + " ");
		for(int root = n/2-1; root>=0; root--)  // 마지막 노드부터 루트노드까지 적용(총 n/2번 수행)
			rebuildMaxHeap(arr, root, n);
		System.out.println(arr[0]);
	}
}
