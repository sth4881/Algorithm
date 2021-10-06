package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ2606 {
	public static void dfs(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfsArr, int vtx, boolean[] visited) {
		dfsArr.add(vtx);
		visited[vtx] = true;
		for(int i=0; i<arr.get(vtx).size(); i++) {
			if(!visited[arr.get(vtx).get(i)]) {
				dfs(arr, dfsArr, arr.get(vtx).get(i), visited);
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<=n; i++)
				arr.add(new ArrayList<Integer>());
			for(int i=0; i<m; i++) {
				String[] tmp = br.readLine().split(" ");
				int vtx1 = Integer.parseInt(tmp[0]);
				int vtx2 = Integer.parseInt(tmp[1]);
				arr.get(vtx1).add(vtx2);
				arr.get(vtx2).add(vtx1);
			}
			
			int cnt = 0;
			ArrayList<Integer> dfsArr = new ArrayList<Integer>();
			boolean[] visited = new boolean[n+1];
			dfs(arr, dfsArr, 1, visited);
			
			bw.write(dfsArr.size()-1+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
