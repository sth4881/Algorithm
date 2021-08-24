package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 대각선으로_숫자_채우기 {
	public static int cnt = 1;
	public static void func(int[][] grid, int row, int col, int n) {
		while(col>=0 && row<n) { // 범위 이탈 방지
			grid[row][col] = cnt++;
			row++; col--;
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
			
			for(int col=0; col<m; col++) // 첫번째 행의 모든 열에 대해서 수행
				func(grid, 0, col, n);
			for(int row=1; row<n; row++) // 마지막 열의 모든 행에 대해서 수행
				func(grid, row, m-1, n);
			
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