package com.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSList {
	public static void func(ArrayList<ArrayList<Integer>> arr,  int n, int vtx, boolean[] visited, int[] parent) {		
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		visited[vtx]=true; // 현재 정점을 방문했음을 표시
		parent[vtx] = -1; // 시작 정점은 부모 노드가 없으므로 -1 대입
		
		q.offer(vtx); // 시작 정점을 큐에 넣음
		while(!q.isEmpty()) { // 큐가 빌 때까지(=방문할 정점이 없을 때까지)
			int tmp = q.poll(); // 임시 변수 tmp에 큐의 맨 앞에 있는 값을 대입
			bfs.add(tmp); // 방문한 정점을 bfs에 저장
			System.out.print(tmp+" ");
			for(int i=0; i<arr.get(tmp).size(); i++) { // 현재 정점의 인접한 노드 개수만큼 반복
				if(!visited[arr.get(tmp).get(i)]) { // 해당 정점이 방문되지 않았다면
					visited[arr.get(tmp).get(i)] = true; // 해당 정점을 방문했음을 표시
					q.offer(arr.get(tmp).get(i)); // 큐에 해당 정점을 추가
					parent[arr.get(tmp).get(i)] = tmp; // tmp의 인접한 정점의 부모를 tmp로 규정
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 크기가 n인 ArrayList<Integer> 타입의 ArrayList 선언
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		// 총 n개의 Integer 타입 ArrayList를 각각 ArrayList<ArrayList<Integer>>에 추가함으로써 최종 생성
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		boolean[] visited = new boolean[n];
		
		int[] parent = new int[n];
		
		// Edge 입력받아서 적용
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		func(arr, n, 0, visited, parent);
		for(int i=0; i<n; i++)
			System.out.print(parent[i]+" ");
	}
}
