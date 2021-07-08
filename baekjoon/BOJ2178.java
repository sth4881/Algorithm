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

public class BOJ2178 {
	public static int mazeSearch(int[][] arr, Vertex[][] vtxArr, Vertex[][] parent, int n, int m) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		Stack<Vertex> s = new Stack<Vertex>();
		parent[0][0].row = -1;
		parent[0][0].col = -1;

		q.offer(vtxArr[0][0]); // 시작 노드를 큐에 추가
		vtxArr[0][0].visited = true; // 시작 노드가 방문됐음을 표시
		while(!q.isEmpty()) { // 더이상 큐에 노드가 올라와있지 않은 경우
			Vertex vtx = q.poll(); // 현재 큐에서 맨 앞의 노드를 반환
			if(vtx.row > 0 && arr[vtx.row-1][vtx.col] == 1 && vtxArr[vtx.row-1][vtx.col].visited == false) { // 위쪽에 길이 존재할 경우
				vtxArr[vtx.row-1][vtx.col].visited = true; // 위쪽 노드를 방문했음을 표시
				q.offer(vtxArr[vtx.row-1][vtx.col]); // 위쪽 노드를 큐에 추가
				parent[vtx.row-1][vtx.col]=vtx; // 위쪽 노드를 부모 노드에 추가
			}
			if(vtx.row < n-1 && arr[vtx.row+1][vtx.col] == 1 && vtxArr[vtx.row+1][vtx.col].visited == false) { // 아래쪽에 길이 존재할 경우
				vtxArr[vtx.row+1][vtx.col].visited = true;  // 아래쪽 노드를 방문했음을 표시
				q.offer(vtxArr[vtx.row+1][vtx.col]); // 아래쪽 노드를 큐에 추가
				parent[vtx.row+1][vtx.col]=vtx; // 아래쪽 노드를 부모 노드에 추가
			}
			if(vtx.col > 0 && arr[vtx.row][vtx.col-1] == 1 && vtxArr[vtx.row][vtx.col-1].visited == false) { // 왼쪽에 길이 존재할 경우
				vtxArr[vtx.row][vtx.col-1].visited = true;  // 왼쪽 노드를 방문했음을 표시
				q.offer(vtxArr[vtx.row][vtx.col-1]); // 왼쪽 노드를 큐에 추가
				parent[vtx.row][vtx.col-1]=vtx; // 왼쪽 노드를 부모 노드에 추가
			}
			if(vtx.col < m-1 && arr[vtx.row][vtx.col+1] == 1 && vtxArr[vtx.row][vtx.col+1].visited == false) { // 오른쪽에 길이 존재할 경우
				vtxArr[vtx.row][vtx.col+1].visited = true;  // 오른쪽 노드를 방문했음을 표시
				q.offer(vtxArr[vtx.row][vtx.col+1]); // 오른쪽 노드를 큐에 추가
				parent[vtx.row][vtx.col+1]=vtx; // 오른쪽 노드를 부모 노드에 추가
			}
		}
		
		Vertex dst = vtxArr[n-1][m-1]; // 미로의 최단거리를 구하기 위해서 도착 노드를 불러옴
		while(dst != vtxArr[0][0]) { // 도착 노드가 시작 노드를 만날 때까지
			s.push(dst); // 해당 노드를 스택에 push
			dst = parent[dst.row][dst.col]; // 도착 노드는 도착 노드의 부모 노드로 갱신
		}
		return s.size()+1; // 미로의 최단거리를 반환
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			int[][] arr = new int[n][m];
			Vertex[][] vtx = new Vertex[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					vtx[i][j] = new Vertex();
				}
			}
			Vertex[][] parent = new Vertex[n][m];  
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					parent[i][j] = new Vertex();
				}
			}
			
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split("");
				for(int j=0; j<m; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
					vtx[i][j].row = i;
					vtx[i][j].col = j;
				}
			}
			
			int ans = mazeSearch(arr, vtx, parent, n, m);
			bw.write(ans+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}

// 정점의 행과 열 및 방문 여부를 표시하기 위한 Vertex 클래스 생성
class Vertex {
	int row=0;
	int col=0;
	boolean visited=false;
}