package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DFS_Lesson2 {
	public static int[] dx = { 0, 1 };
	public static int[] dy = { 1, 0 };
	public static void dfs(int[][] grid, int row, int col, int n, int m, boolean[][] visited) {
		for(int i=0; i<2; i++) {
			int nx = col + dx[i];
			int ny = row + dy[i];
			if(nx>=0 && nx<m && ny>=0 && ny<n) {
				if(grid[ny][nx]==1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					dfs(grid, ny, nx, n, m, visited);
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
			
			int[][] grid = new int[n][m];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<m; j++) {
					grid[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			boolean[][] visited = new boolean[n][m];
			visited[0][0] = true;
			dfs(grid, 0, 0, n, m, visited);
			
			if(!visited[n-1][m-1]) bw.write(0+"\n");
			else if(visited[n-1][m-1]) bw.write(1+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
