package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {
	public static int[] dr = { 0, 1, 0, -1 };
	public static int[] dc = { 1, 0, -1, 0 };
	
	// 정점의 행과 열을 묶어서 큐에 넣어주기 위해 클래스를 새로 정의
	static class Vertex {
		int row, col;
		Vertex(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static int bfs(int[][] maze, int row, int col, int n, int m) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(new Vertex(0, 0)); // 시작점을 큐에 넣어서 BFS를 시작
		while(!q.isEmpty()) {
			Vertex vtx = q.poll();
			for(int i=0; i<4; i++) { // 상하좌우 4방향에 대해서
				int nr = vtx.row + dr[i]; // 정점 vtx의 다음 행을 정의
				int nc = vtx.col + dc[i]; // 정점 vtx의 다음 열을 정의
				if(nr>=0 && nr<n && nc>=0 && nc<m) { // 미로의 상하좌우 끝부분을 벗어나지 않게 조건을 만들어줌
					if(maze[nr][nc]==1) { // 다음으로 이동하는 영역에 벽이 아닌 길이 존재한다면
						maze[nr][nc] = maze[vtx.row][vtx.col] + 1; // 최단거리를 구하기 위해서 현재 정점의 값+1 해줌
						q.offer(new Vertex(nr, nc)); // 다음 방문할 정점을 큐에 추가
					}
				}
			}
		}
		return maze[n-1][m-1]; // 결과적으로 도착점의 값이 최단거리임을 알 수 있음
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			int[][] maze = new int[n][m];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split("");
				for(int j=0; j<m; j++) {
					maze[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			int result = bfs(maze, 0, 0, n, m);
			bw.write(result+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}