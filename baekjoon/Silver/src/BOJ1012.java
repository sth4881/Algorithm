package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* 백준 1012번 유기농배추 (Silver) */
public class BOJ1012 {
	public static void dfs(int[][] arr, int row, int col, int m, int n, boolean[][] visited) {
		visited[row][col] = true;
		if(col>0 && arr[row][col-1] != 0 && !visited[row][col-1]) { // 위로 이동하는 경우
			dfs(arr, row, col-1, m, n, visited);
		}
		if(col<n-1 && arr[row][col+1] != 0 && !visited[row][col+1]) { // 아래로 이동하는 경우
			dfs(arr, row, col+1, m, n, visited);
		}
		if(row>0 && arr[row-1][col] != 0 && !visited[row-1][col]) { // 왼쪽으로 이동하는 경우
			dfs(arr, row-1, col, m, n, visited);
		}
		if(row<m-1 && arr[row+1][col] != 0 && !visited[row+1][col]) {
			dfs(arr, row+1, col, m, n, visited);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int testcase = Integer.parseInt(br.readLine());
			int[] ans = new int[testcase]; // 배추의 개수를 세기 위한 배열 ans
			for(int t=0; t<testcase; t++) {
				String[] mnk = br.readLine().split(" ");
				int m = Integer.parseInt(mnk[0]);
				int n = Integer.parseInt(mnk[1]);
				int k = Integer.parseInt(mnk[2]);
				
				int[][] arr = new int[m][n];
				for(int i=0; i<k; i++) {
					String[] input = br.readLine().split(" ");
					int x = Integer.parseInt(input[0]);
					int y = Integer.parseInt(input[1]);
					arr[x][y] = 1;
				}
				
				boolean[][] visited = new boolean[m][n]; // 배추밭의 영역들을 방문했는지 확인하기 위한 배열 visited
				for(int row=0; row<arr.length; row++) {
					for(int col=0; col<arr[row].length; col++) {
						if(arr[row][col] != 0 && !visited[row][col]) {
							dfs(arr, row, col, m, n, visited); // row x col 영역을 방문하지 않았다면 방문 시작
							ans[t]++;
						}
					}
				}
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
