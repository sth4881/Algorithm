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
		for(int i=1; i<n*n; i++) { // n*n-1개의 칸을 채우기 위해서
			while(true) { // 이동할 때까지 방향을 바꿔주기 위해서 while문 삽입
				int nx = cx + dx[dir];
				int ny = cy + dy[dir];
				if(nx>=0 && ny>=0 && nx<n && ny<n && grid[ny][nx]==0) { // 범위 이탈 & 이동하려는 위치의 값이 0이면
					grid[ny][nx] = num+1; // 다음으로 이동하려는 위치의 값을 현재 값 +1로 변경
					cx = nx; cy = ny; // 현재 x와 현재 y값을 다음 x와 다음 y값으로 갱신 
					num++;
					break; // 다음 칸으로 이동하기 위해서 break
				} else dir = (dir+1) % 4; // 그렇지 않으면 방향을 바꿔준다.
			}
		}
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
