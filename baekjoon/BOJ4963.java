package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ4963 {
	public static int[] dr = { 1, 1, 1, 0, 0, -1, -1, -1 };
	public static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	public static void dfs(int[][] arr, int row, int col, int h, int w, boolean[][] visited) {
		visited[row][col] = true; // 해당 정점을 방문했음을 표시
		for(int i=0; i<8; i++) { // 현재 정점으로부터 8방향에 대해서
			int nr = row+dr[i]; // 다음 정점의 행을 갱신
			int nc = col+dc[i]; // 다음 정점의 열을 갱신
			if(nr>=0 && nr<h && nc>=0 && nc<w) { // arr 범위를 초과하지 않게 제한
				if(arr[nr][nc]==1 && !visited[nr][nc]) { // 다음 정점에 섬이 있고 방문되지 않았을 경우
					dfs(arr, nr, nc, h, w, visited); // 다음 정점을 방문한다
				}
			}
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int w = Integer.parseInt(input[0]);
			int h = Integer.parseInt(input[1]);
			
			int[][] arr = new int[h][w];
			boolean[][] visited = new boolean[h][w];
			while(w!=0 || h!=0) {
				for(int i=0; i<h; i++) {
					String[] tmp = br.readLine().split(" ");
					for(int j=0; j<w; j++) {
						arr[i][j] = Integer.parseInt(tmp[j]);
					}
				}
				
				int cnt = 0;
				for(int row=0; row<h; row++) {
					for(int col=0; col<w; col++) {
						if(arr[row][col]==1 && !visited[row][col]) {
							dfs(arr, row, col, h, w, visited); // 해당 정점에 섬이 있고 방문되지 않았을 경우에 dfs 수행
							cnt++; // 위의 메소드를 빠져나왔다는 뜻은 더 이상 이어져있는 섬이 없다는 뜻이므로 cnt 1증가
						}
					}
				}
				bw.write(cnt+"\n"); // 버퍼에서 쌓이기 때문에 while문을 빠져나와서 한번에 출력
				
				// 다음 테스트 케이스를 위해서 input 갱신 및 arr와 visited, cnt 초기화
				input = br.readLine().split(" ");
				w = Integer.parseInt(input[0]);
				h = Integer.parseInt(input[1]);
				arr = new int[h][w];
				visited = new boolean[h][w];
				cnt = 0;
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
