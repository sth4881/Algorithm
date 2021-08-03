package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ1697 {
	public static int[] dx = { -1, 1, 2 };
	public static int bfs(int start, int end, int[] parent, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s  = new Stack<Integer>();
		visited[start] = true;
		parent[start] = -1;
		
		q.offer(start);
		while(!q.isEmpty()) {
			int vtx = q.poll();
			for(int i=0; i<3; i++) {
				int nx = 0;
				if(dx[i]==-1 || dx[i]==1) {
					nx = vtx+dx[i];
				} else {
					nx = vtx*dx[i];
				}
				if(nx>=0 && nx<=end && !visited[nx ]) {
					visited[nx] = true;
					parent[nx] = vtx;
					q.offer(nx);
				}
			}
		}

		int vtx = end;
		while(vtx != start) {
			s.push(vtx);
			vtx = parent[vtx];
		}
		return s.size();
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			
			int size = Math.max(start, end);
			boolean[] visited = new boolean[size+1];
			int[] parent = new int[size+1];
			int result = bfs(start, end, parent, visited);
			
			bw.write(result+"\n");
			bw.close();			
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
