package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment2_2 {
	public static int func(int[][] arr, Vertex[][] vtx, int m, int n, int srcRow, int srcCol, int dstRow, int dstCol, Vertex[][] parent) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		Stack<Vertex> s = new Stack<Vertex>();
		vtx[srcRow][srcCol].visited=true; // 시작 정점에서 경로 탐색을 시작하므로 방문했음을 표시
		parent[srcRow][srcCol].x=-1; // 시작 정점은 부모 정점이 존재하지 않으므로 시작 정점의 x좌표를 -1로 설정
		parent[srcRow][srcCol].y=-1; // 시작 정점은 부모 정점이 존재하지 않으므로 시작 정점의 y좌표를 -1로 설정
		
		int row = srcRow;
		int col =srcCol;
		
		if(arr[row][col]==1) return -1;
		
		q.offer(vtx[row][col]); // 시작 정점을 큐에 추가
		while(!q.isEmpty()) {
			Vertex tmp = q.poll(); // 임시 변수 tmp에 큐에 맨 앞 정점을 대입하고 해당 정점을 큐에서 제거
			if(tmp.x-1>=0 && arr[tmp.x-1][col]==0) { // 위쪽에 정점이 존재하고, 그 정점의 값이 0이라면
				if(vtx[tmp.x-1][tmp.y].visited==false) { // 위쪽 정점을 방문하지 않았다면
					vtx[tmp.x-1][tmp.y].visited=true; // 위쪽 정점을 방문했음을 표시
					q.offer(vtx[tmp.x-1][tmp.y]); // 위쪽 정점을 큐에 추가
					parent[tmp.x-1][tmp.y]=tmp; // 위쪽 정점의 부모 정점을 tmp로 설정
				}
			}
			if(tmp.x+1<m && arr[tmp.x+1][tmp.y]==0) { // 아래쪽에 정점이 존재하고, 그 정점의 값이 0이라면
				if(vtx[tmp.x+1][tmp.y].visited==false) { // 아래쪽 정점을 방문하지 않았다면
					vtx[tmp.x+1][tmp.y].visited=true; // 아래쪽 정점을 방문했음을 표시
					q.offer(vtx[tmp.x+1][tmp.y]); // 아래쪽 정점을 큐에 추가
					parent[tmp.x+1][tmp.y]=tmp; // 아래쪽 정점의 부모 정점을 tmp로 설정
				}
			}
			if(tmp.y-1>=0 && arr[tmp.x][tmp.y-1]==0) { // 왼쪽에 정점이 존재하고, 그 정점의 값이 0이라면
				if(vtx[tmp.x][tmp.y-1].visited==false) { // 왼쪽 정점을 방문하지 않았다면
					vtx[tmp.x][tmp.y-1].visited=true; // 왼쪽 정점을 방문했음을 표시
					q.offer(vtx[tmp.x][tmp.y-1]); // 왼쪽 정점을 큐에 추가
					parent[tmp.x][tmp.y-1]=tmp; // 왼쪽 정점의 부모 정점을 tmp로 설정
				}
			}
			if(tmp.y+1<n && arr[tmp.x][tmp.y+1]==0) { // 오른쪽에 정점이 존재하고, 그 정점의 값이 0이라면
				if(vtx[tmp.x][tmp.y+1].visited==false) { // 오른쪽 정점을 방문하지 않았다면
					vtx[tmp.x][tmp.y+1].visited=true; // 오른쪽 정점을 방문했음을 표시
					q.offer(vtx[tmp.x][tmp.y+1]); // 오른쪽 정점을 큐에 추가
					parent[tmp.x][tmp.y+1]=tmp; // 오른쪽 정점의 부모 정점을 tmp로 설정
				}
			}
		}
		
		Vertex tmp = vtx[dstRow][dstCol];
		if(tmp.visited==false) return -1;
		while(tmp!=vtx[srcRow][srcCol]) {
			s.push(tmp);
			tmp = parent[tmp.x][tmp.y];
		}
		return s.size()+1; // 시작 정점의 값도 0이므로 +1해줘야함
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] size = bufReader.readLine().split(" "); // 테스트 케이스의 개수를 입력받기 위한 변수
			int m = Integer.parseInt(size[0]);
			int n = Integer.parseInt(size[1]);
			
			int[][] arr = new int[m][n];
			Vertex[][] vtx = new Vertex[m][n]; // 2차원 배열의 좌표를 큐에 넣어주기 위해서 vtx 선언
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					vtx[i][j] = new Vertex(); // 각각의 vtx에게 메모리를 할당함으로써 생성
				}
			}
			Vertex[][] parent = new Vertex[m][n]; // 목적지로부터 시작 정점으로의 최단경로를 찾기 위해서 parent 선언 
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					parent[i][j] = new Vertex(); // 각각의 parent에게 메모리를 할당함으로써 생성
				}
			}
			
			for(int i=0; i<m; i++) {
				String[] line = bufReader.readLine().split("");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
					vtx[i][j].x=i; // Vertex에게 x좌표 부여
					vtx[i][j].y=j; // Vertex에게 y좌표 부여
				}
			}
			
			String[] input = bufReader.readLine().split(" ");
			int srcRow = Integer.parseInt(input[0]);
			int srcCol = Integer.parseInt(input[1]);
			int dstRow = Integer.parseInt(input[2]);
			int dstCol = Integer.parseInt(input[3]);
			
			int result = func(arr, vtx, m, n, srcRow, srcCol, dstRow, dstCol, parent);
			System.out.println(result);

			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}

class Vertex {
	int x=0;
	int y=0;
	boolean visited=false;
}
