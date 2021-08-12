package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Vertex {
	private int row = 0;
	private int col = 0;
	Vertex(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
}

public class BFS_Lesson2 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static int bfs(int[][] grid, int row, int col, int n, int m, boolean[][] visited) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		
		q.offer(new Vertex(row, col));
		while(!q.isEmpty()) {
			Vertex vtx = q.poll();
			for(int i=0; i<4; i++) {
				int nx = vtx.getCol() + dx[i];
				int ny = vtx.getRow() + dy[i];
				if(nx>=0 && nx<m && ny>=0 && ny<n) {
					if(grid[ny][nx]>0 && !visited[ny][nx]) {
						grid[ny][nx] = grid[vtx.getRow()][vtx.getCol()] + 1;
						visited[ny][nx] = true;
						q.offer(new Vertex(ny, nx));
					}
				}
			}
		}
		return grid[n-1][m-1]-1;  // 탈출 가능한 경로에 출발점을 포함하지 않기 때문에 -1
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			int[][] grid = new int[n][m];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					grid[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			boolean[][] visited = new boolean[n][m];
			if(grid[0][0]!=0) {
				visited[0][0] = true;
				int cnt = bfs(grid, 0, 0, n, m, visited);
				if(!visited[n-1][m-1]) bw.write(-1+"\n");
				else if(visited[n-1][m-1]) bw.write(cnt+"\n");
			} else bw.write(-1+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
