package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ11403 {
	public static void dfs(int[][] arr, ArrayList<ArrayList<Integer>> list, int vtx, boolean[] visited) {
		for(int i=0; i<list.get(vtx).size(); i++) { // 정점 i가 방문할 수 있는 정점들에 대해서
			if(!visited[list.get(vtx).get(i)]) { // 해당 정점이 방문되지 않았다면
				visited[list.get(vtx).get(i)] = true; // 현재 정점은 방문하지 못할 수도 있으므로 다음 정점이 방문 가능할 경우에 표시 
				dfs(arr, list, list.get(vtx).get(i), visited); // 다음 정점에 대해서 DFS 알고리즘 적용
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j<tmp.length; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			// 인접 행렬을 인접 리스트로 변환하는 과정
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++)
				list.add(new ArrayList<Integer>());
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==1) list.get(i).add(j);
				}
			}
			
			boolean[] visited = new boolean[n];
			for(int i=0; i<n; i++) {
				dfs(arr, list, i, visited); // 각각의 정점 i에 대해서 DFS 알고리즘 적용
				for(int j=0; j<n; j++) {
					if(visited[j]) { // 정점 j가 방문되었다면(정점 i에서 정점 j로 가는 경로가 존재한다면)
						arr[i][j] = 1; // 정점 i가 방문한 정점들에 대해서 가는 경로가 있음을 표시
						visited[j] = false; // visited를 다음 정점에서 활용하기 위해 false로 변환 
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					bw.write(arr[i][j]+" ");
				bw.write("\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
