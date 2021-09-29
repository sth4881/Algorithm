package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ2468 {
	public static int[] dr = { 1, 0, -1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };
	public static void dfs(int[][] arr, int row, int col, int n, int height, boolean[][] visited) {
		visited[row][col] = true; // 현재 영역이 방문됐음을 표시
		for(int i=0; i<4; i++) { // 현재 영역으로부터 4방향에 대해서
			int nr = row + dr[i]; // 현재 영역의 행을 갱신
			int nc = col + dc[i]; // 현재 영역의 열을 갱신
			if(nr>=0 && nr<n && nc>=0 && nc<n) { // 범위 밖을 벗어나는 것을 방지
				if(arr[nr][nc]>height && !visited[nr][nc]) { // 물의 높이보다 건물의 높이가 높고 방문하지 않았을 경우
					dfs(arr, nr, nc, n, height, visited); // 다음 영역에 대해서 DFS 알고리즘 수행
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			// 1부터 100까지 불필요한 높이들은 빼고 최소 높이와 최대 높이를 추출하는 과정
			int maxHeight = 1;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][j] > maxHeight) maxHeight = arr[i][j];
				}
			}
			
			ArrayList<Integer> cnt = new ArrayList<Integer>(); // 안전영역의 개수를 구하기 위한 ArrayList 생성
			for(int height=0; height<maxHeight; height++) { // 0부터 max-1까지의 높이에 대해서(비가 안 올수도 있고, maxHeight의 경우에는 전부 물에 잠겨서 0이 되기 때문)
				cnt.add(0); // 각각의 안전영역을 0으로 초기화
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						if(arr[i][j]>height && !visited[i][j]) { // 해당 영역이 물이 높이보다 높고, 방문되지 않은 경우
							dfs(arr, i, j, n, height, visited); // 해당 영역에 대해서 DFS 알고리즘 시작
							cnt.set(height, cnt.get(height)+1); // 각각의 물의 높이에 대한 안전영역 개수를 카운트
						}
					}
				}
				visited = new boolean[n][n]; // visited를 재사용하기 위해서 초기화
			}
			
			int max = 0;
			for(int i=0; i<cnt.size(); i++)
				if(cnt.get(i) > max) max = cnt.get(i);
			bw.write(max+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
