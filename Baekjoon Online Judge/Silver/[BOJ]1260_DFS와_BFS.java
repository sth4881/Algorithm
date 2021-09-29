package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1260 {
	public static void dfs(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfsArr, int v, boolean[] visited) {
		dfsArr.add(v); // 메소드를 통해서 들어온 노드의 순서대로 dfs를 구성
		visited[v] = true; // 해당 노드가 방문됐음을 표시
		for(int i=0; i<arr.get(v).size(); i++) { // 해당 노드의 인접한 노드들에 대해서
			if(!visited[arr.get(v).get(i)]) { // 해당 노드가 방문되지 않았다면
				dfs(arr, dfsArr, arr.get(v).get(i), visited); // 해당 노드에 대해서 다시 dfs를적용
			}
		}
	}
	
	public static void bfs(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> bfsArr, int v, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(v); // 시작 노드를 큐에 추가
		visited[v] = true; // 시작 노드가 방문됐음을 표시
		while(!q.isEmpty()) { // 큐에 원소가 없을 때까지
			int vtx = q.poll(); // 큐에서 맨 처음 노드를 반환
			bfsArr.add(vtx); // 큐에서 반환된 순서대로 bfs를 구성
			for(int i=0; i<arr.get(vtx).size(); i++) { // 반환된 노드에 인접한 노드들에 대해서
				if(!visited[arr.get(vtx).get(i)]) { // 해당 노드가 방문되지 않았다면
					visited[arr.get(vtx).get(i)] = true; // 해당 노드가 방문됐음을 표시
					q.offer(arr.get(vtx).get(i)); // 큐에 해당 노드를 추가
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			int v = Integer.parseInt(tmp[2]);
			
			// 인접리스트 구현
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
			
			// 정점 번호가 작은 것을 먼저 방문하도록 만들어주기 위해 오름차순 정렬
			for(int i=0; i<arr.size(); i++) {
				Collections.sort(arr.get(i));
			}
			
			ArrayList<Integer> dfsArr = new ArrayList<Integer>();
			ArrayList<Integer> bfsArr = new ArrayList<Integer>();
			boolean[] visited = new boolean[n+1];
			dfs(arr, dfsArr, v, visited);
			
			// dfs를 통해서 visited 배열이 전부 true로 바뀌었으므로
			// bfs에서 사용해주기 위해 모든 값을 전부 false로 변경
			for(int i=0; i<visited.length; i++)
				visited[i] = false;
			bfs(arr, bfsArr, v, visited);
			
			// 출력
			for(int i=0; i<dfsArr.size(); i++)
				bw.write(dfsArr.get(i)+" ");
			bw.write("\n");
			for(int i=0; i<bfsArr.size(); i++)
				bw.write(bfsArr.get(i)+" ");
			bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
