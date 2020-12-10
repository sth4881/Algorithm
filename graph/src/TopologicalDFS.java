package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalDFS {
	public static void func(ArrayList<ArrayList<Integer>> arr, Stack<Integer> s, int vtx, boolean[] visited) {
		visited[vtx]=true; // 해당 정점을 방문한 적이 없으면 방문했음을 표시
 		for(int i=0; i<arr.get(vtx).size(); i++) { // 현재 정점에 인접한 정점의 개수만큼
			if(!visited[arr.get(vtx).get(i)]) { // 현재 정점에 인접한 정점을 방문하지 않았다면
				func(arr, s, arr.get(vtx).get(i), visited); // 해당 정점에 대해서 DFS 수행
			}
		}
		s.push(vtx); // 현재 정점에 대해서 스택에 push
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
		
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) // 모든 정점에 대해서 수행해야하므로
			if(!visited[i]) func(arr, s, i, visited); // 정점 i를 방문하지 않았다면 정점 i에 대해서 DFS 수행
		while(!s.isEmpty()) { // 알 수 없는 이유로 for(int i=0; i<s.size(); i++)를 사용하면 모든 값이 pop되지 않음 
			System.out.print(s.pop()+" ");
		}
	}
}
