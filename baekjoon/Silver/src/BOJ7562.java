package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* 백준 7562번 나이트의이동 (Silver) */
public class BOJ7562 {
	public static int bfs(int[][] arr, int n, int srcRow, int srcCol, int dstRow, int dstCol, Vertex[][] vtxArr, Vertex[][] parent) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		Stack<Vertex> s = new Stack<Vertex>();
		vtxArr[srcRow][srcCol].visited = true;
		parent[srcRow][srcCol].row = -1;
		parent[srcRow][srcCol].col = -1;
		
		q.offer(vtxArr[srcRow][srcCol]);
		while(!q.isEmpty()) {
			Vertex vtx = q.poll();
			if(vtx.row > 0 && vtx.col > 1 && !vtxArr[vtx.row-1][vtx.col-2].visited) {
				vtxArr[vtx.row-1][vtx.col-2].visited = true;
				q.offer(vtxArr[vtx.row-1][vtx.col-2]);
				parent[vtx.row-1][vtx.col-2] = vtx;
			}
			if(vtx.row > 0 && vtx.col < n-2 && !vtxArr[vtx.row-1][vtx.col+2].visited) {
				vtxArr[vtx.row-1][vtx.col+2].visited = true;
				q.offer(vtxArr[vtx.row-1][vtx.col+2]);
				parent[vtx.row-1][vtx.col+2] = vtx;
			}
			if(vtx.row > 1 && vtx.col > 0 && !vtxArr[vtx.row-2][vtx.col-1].visited) {
				vtxArr[vtx.row-2][vtx.col-1].visited = true;
				q.offer(vtxArr[vtx.row-2][vtx.col-1]);
				parent[vtx.row-2][vtx.col-1] = vtx;
			}
			if(vtx.row > 1 && vtx.col < n-1 && !vtxArr[vtx.row-2][vtx.col+1].visited) {
				vtxArr[vtx.row-2][vtx.col+1].visited = true;
				q.offer(vtxArr[vtx.row-2][vtx.col+1]);
				parent[vtx.row-2][vtx.col+1] = vtx;
			}
			if(vtx.row < n-1 && vtx.col > 1 && !vtxArr[vtx.row+1][vtx.col-2].visited) {
				vtxArr[vtx.row+1][vtx.col-2].visited = true;
				q.offer(vtxArr[vtx.row+1][vtx.col-2]);
				parent[vtx.row+1][vtx.col-2] = vtx;
			}
			if(vtx.row < n-1 && vtx.col < n-2 && !vtxArr[vtx.row+1][vtx.col+2].visited) {
				vtxArr[vtx.row+1][vtx.col+2].visited = true;
				q.offer(vtxArr[vtx.row+1][vtx.col+2]);
				parent[vtx.row+1][vtx.col+2] = vtx;
			}
			if(vtx.row < n-2 &&  vtx.col > 0 && !vtxArr[vtx.row+2][vtx.col-1].visited) {
				vtxArr[vtx.row+2][vtx.col-1].visited = true;
				q.offer(vtxArr[vtx.row+2][vtx.col-1]);
				parent[vtx.row+2][vtx.col-1] = vtx;
			}
			if(vtx.row < n-2 && vtx.col < n-1 && !vtxArr[vtx.row+2][vtx.col+1].visited) {
				vtxArr[vtx.row+2][vtx.col+1].visited = true;
				q.offer(vtxArr[vtx.row+2][vtx.col+1]);
				parent[vtx.row+2][vtx.col+1] = vtx;
			}
		}
		
		Vertex vtx = vtxArr[dstRow][dstCol]; // 최단거리를 찾기 위해서 도착점에서 시작
		while(vtx != vtxArr[srcRow][srcCol]) { // 노드 vtx가 출발점에 도착할 때까지
			s.push(vtx); // 노드 vtx를 스택에 쌓음
			vtx = parent[vtx.row][vtx.col]; // 노드 vtx를 vtx의 부모 노드로 갱신
		}
		return s.size(); // 이동하는 횟수이므로 출발점을 포함하지 않음
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int testcase = Integer.parseInt(br.readLine());
			int[] ans = new int[testcase];
			for(int t=0; t<testcase; t++) {
				int n = Integer.parseInt(br.readLine());
				String[] tmp = br.readLine().split(" ");
				int srcRow = Integer.parseInt(tmp[0]);
				int srcCol = Integer.parseInt(tmp[1]);
				tmp = br.readLine().split(" " );
				int dstRow = Integer.parseInt(tmp[0]);
				int dstCol = Integer.parseInt(tmp[1]);
				
				int[][] arr = new int[n][n];
				Vertex[][] vtxArr = new Vertex[n][n];
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						vtxArr[i][j] = new Vertex();
					}
				}
				Vertex[][] parent = new Vertex[n][n];  
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						parent[i][j] = new Vertex();
					}
				}
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						vtxArr[i][j].row = i;
						vtxArr[i][j].col = j;
					}
				}
				
				if(srcRow==dstRow && srcCol==dstCol) ans[t] = 0;
				else ans[t] = bfs(arr, n, srcRow, srcCol, dstRow, dstCol, vtxArr, parent);
			}
			
			for(int i=0; i<ans.length; i++)
				bw.write(ans[i]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}

class Vertex {
	int row=0;
	int col=0;
	boolean visited=false;
}