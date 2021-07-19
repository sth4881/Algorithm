package com.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalIndegree {
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> sort, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 각각의 정점에 대해서 indegree 설정
		int[] indegree = new int[n]; 
		for(int i=0; i<n; i++) { // 모든 정점에 대해서
			for(int j=0; j<arr.get(i).size(); j++) { // 현재 정점에 인접한 정점의 개수만큼
				indegree[arr.get(i).get(j)]++; // 현재 정점에 인접한 정점에 대해서 indegree 1 증가
			}
		}
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) q.offer(i); // 해당 정점으로부터 오는 indegree가 0일 경우(시작 정점인 경우) 큐에 추가
		}
		
		// 각각의 정점에 대한 indegree를 바탕으로 위상정렬 알고리즘 구현
		while(!q.isEmpty()) {
			int output = q.poll(); // 큐에서 맨 처음 원소를 반환 후 제거
			sort.add(output); // 반환된 원소를 ArrayList에 넣어서 결과 저장
			for(int i=0; i<arr.get(output).size(); i++) { // 반환된 원소에 인접한 정점의 개수만큼
				indegree[arr.get(output).get(i)]--; // 반환된 원소에 인접한 정점에 대해서 indegree 1 감소
				if(indegree[arr.get(output).get(i)]==0) // 반환된 원소에 인접한 정점의 indegree가 0이라면
					q.offer(arr.get(output).get(i)); // 해당 정점을 큐에 추가 
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 크기가 n인 ArrayList<Integer> 타입의 ArrayList 선언
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		// 총 n개의 Integer 타입 ArrayList 각각의 ArrayList에 추가함으로써 최종 생성
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// Edge 입력받아서 적용
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
		}
		
		ArrayList<Integer> sort = new ArrayList<Integer>();
		func(arr, sort, n);
		for(int i=0; i<sort.size(); i++) {
			System.out.print(sort.get(i)+" ");
		}
	}
}
