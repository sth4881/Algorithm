package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ11724 {
	public static void dfs(ArrayList<ArrayList<Integer>> arr, int vtx, boolean[] visited) {
		visited[vtx] = true; // 현재 정점 vtx에 대해서 방문했음을 표시
		for(int i=0; i<arr.get(vtx).size(); i++) { // 현재 정점에 인접한 각각의 정점들에 대해서
			if(!visited[arr.get(vtx).get(i)]) dfs(arr, arr.get(vtx).get(i), visited); // 방문되지 않았다면 그 정점에 대해서 DFS 알고리즘을 재귀적으로 수행
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			// 각각의 정점과 간선 정보를 이용해서 인접리스트로 만드는 과정
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=n; i++)
				arr.add(new ArrayList<Integer>());
			for(int i=0; i<m; i++) {
				tmp = br.readLine().split(" ");
				int vtx1 = Integer.parseInt(tmp[0]);
				int vtx2 = Integer.parseInt(tmp[1]);
				arr.get(vtx1).add(vtx2);
				arr.get(vtx2).add(vtx1);
			}
			
			int cnt = 0; // 연결요소의 개수를 세기 위한 변수 cnt
			boolean[] visited = new boolean[n+1]; // 각각의 정점이 방문됐는지 확인하기 위한 배열 visited
			for(int i=1; i<=n; i++) { // 정점은 0이 아닌 1부터 입력되므로 1부터 n까지의 정점에 대해서 반복문 수행
				if(!visited[i]) { // 정점 i가 방문되지 않은 경우
					dfs(arr, i, visited); // 해당 정점에 대해서 DFS 알고리즘 수행
					cnt++; // 더 이상 연결된 정점이 없으면 위의 메소드를 빠져나오게 되므로 연결요소의 개수를 1 증가
				}
			}
			
			bw.write(cnt+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
