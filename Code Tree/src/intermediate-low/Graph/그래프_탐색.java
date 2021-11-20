package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DFS_Lesson1 {
	public static int cnt = 0;
	public static void dfs(ArrayList<ArrayList<Integer>> list, int start, boolean[] visited) {
		visited[start] = true;
		for(int i=0; i<list.get(start).size(); i++) {
			if(!visited[list.get(start).get(i)]) {
				cnt++; // 시작 정점에 대한 cnt를 증가시켜주지 않기 위해서 cnt를 여기서 증가
				dfs(list, list.get(start).get(i), visited);
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
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=n; i++) {
				list.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<m; i++) {
				tmp = br.readLine().split(" ");
				int vtx1 = Integer.parseInt(tmp[0]);
				int vtx2 = Integer.parseInt(tmp[1]);
				list.get(vtx1).add(vtx2);
				list.get(vtx2).add(vtx1);
			}
			
			boolean[] visited = new boolean[n+1];
			dfs(list, 1, visited);
			
			bw.write(cnt+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
