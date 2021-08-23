package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 대각선으로_숫자_채우기 {
	public static int[] dx = { -1 };
	public static int[] dy = { 1 };
	public static void func(int[][] grid, int cx, int cy, int n, int m) {
		int num = 1;
		int col_idx = 0;
		int row_idx = 0;
		grid[0][0] = num;
		for(int i=1; i<n*m; i++) {
			int nx = cx-1;
			int ny = cy+1;
			if(nx>=0 && ny>=0 && nx<m && ny<n) { // 범위 이탈 방지
				cx = nx; cy = ny;
				grid[cy][cx] = ++num;
			}
			 else { // 범위를 이탈한 경우 첫번째 행으로 이동하고 열은 col+1로 이동
				if(col_idx<m-1) { // 마지막 열 전까지에 대해서
					cx = ++col_idx; cy = 0;
					grid[cy][cx] = ++num;
				} else { // 마지막 열에 대해서
					if(row_idx<n-1) { // 마지막 행 전까지에 대해서
						cx = n-1; cy = ++row_idx;
						grid[cy][cx] = ++num;
					}
				}
			 }
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int[][] grid = new int[n][m];
			
			func(grid, 0, 0, n, m);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
					bw.write(grid[i][j]+" ");
				bw.write("\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}