package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 가운데에서_시작하여_빙빙_돌기 {
	public static int dir = 0;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static void func(int[][] grid, int cx, int cy, int n) {
		int num = 1;
		grid[cy][cx] = num; // 시작 위치의 값을 1로 초기화
		
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];
			int pos = (grid.length-1)/2;
			
			func(grid, pos, pos, n);
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
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
