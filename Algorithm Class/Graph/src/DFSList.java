package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSList {
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfs, ArrayList<Boolean> visited, int vtx) {
		dfs.add(vtx); // 현재 정점을 방문한 목록에 순서대로 추가
		visited.set(vtx, true); // 현재 정점을 방문했다고 표시
		
		for(int i=0; i<arr.get(vtx).size(); i++) { // 정점 vtx와 인접한 정점의 개수만큼 반복
			if(!visited.get(arr.get(vtx).get(i))) { // 정점 vtx와 인접한 정점이 방문되지 않았다면
				func(arr, dfs, visited, arr.get(vtx).get(i)); // 해당 정점을 DFS로 방문
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 크기가 n인 ArrayList<Integer> 타입의 ArrayList 선언
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		// 총 n개의 Integer 타입 ArrayList를 각각 ArrayList<ArrayList<Integer>>에 추가함으로써 최종 생성
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// DFS로 방문한 순서를 저장하기 위한 ArrayList 선언
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		
		// 방문한 정점들을 표시하기 위한 ArrayList 선언(기본값 false)
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i=0; i<n; i++)
			visited.add(false);
		
		// Edge 입력받아서 적용
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		// DFS 적용 및 출력
		func(arr, dfs, visited, 0);
		for(int i=0; i<dfs.size(); i++)
			System.out.print(dfs.get(i)+" ");
	}
}
