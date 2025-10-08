package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

/* 백준 2667번 단지번호붙이기 (Silver) */
public class BOJ2667 {
	public static void dfs(int[][] arr, int n, int row, int col, int[] tmp, int idx, boolean[][] visited) {
		tmp[idx]++; // 현재 구역의 집을 idx 단지로 생각하고 해당 단지의 개수를 1 증가
		visited[row][col] = true; // 현재 구역의 집이 방문됐음을 표시
		if(row > 0 && arr[row-1][col]==1 && !visited[row-1][col]) { // 위쪽에 집이 있고 방문하지 않았을 경우
			dfs(arr, n, row-1, col, tmp, idx, visited); // 위쪽 집에 대해서 DFS를 수행
		}
		if(row < n-1 && arr[row+1][col]==1 && !visited[row+1][col]) { // 아래쪽에 집이 있고 방문하지 않았을 경우
			dfs(arr, n, row+1, col, tmp, idx, visited); // 아래쪽 집에 대해서 DFS를 수행
		}
		if(col > 0 && arr[row][col-1]==1 && !visited[row][col-1]) { // 왼쪽에 집이 있고 방문하지 않았을 경우
			dfs(arr, n, row, col-1, tmp, idx, visited); // 왼쪽 집에 대해서 DFS를 수행
		}
		if(col < n-1 && arr[row][col+1]==1 && !visited[row][col+1]) { // 오른쪽에 집이 있고 방문하지 않았을 경우
			dfs(arr, n, row, col+1, tmp, idx, visited); // 오른쪽 집에 대해서 DFS를 수행
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split("");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			int[] tmp = new int[n*n]; // 각각의 단지에 대한 집의 개수를 저장하기 위한 배열
			boolean[][] visited = new boolean[n][n]; // 각각의 집의 방문 여부를 저장하기 위한 배열
			
			int idx = 0; // 단지의 개수를 저장하기 위한 변수
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j]==1 && !visited[i][j]) { // 해당 구역에 집이 있고 방문되지 않았다면 
						dfs(arr, n, i, j, tmp, idx, visited); // 해당 구역을 DFS로 탐색
						idx++; // 위의 메소드를 빠져나왔다는 뜻은 해당 단지를 다 탐색했다는 의미로 단지 번호를 증가
					}
				}
			}
			
			int[] ans = new int[idx]; // 정답 출력 배열 생성
			for(int i=0; i<idx; i++) {
				ans[i] = tmp[i];
			}
			Arrays.sort(ans); // 각각의 단지에 대한 집의 개수를 오름차순으로 정렬
			bw.write(idx+"\n");
			for(int i=0; i<idx; i++) {
				bw.write(ans[i]+"\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}