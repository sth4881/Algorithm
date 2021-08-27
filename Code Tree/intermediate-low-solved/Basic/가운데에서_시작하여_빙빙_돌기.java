package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 가운데에서_시작하여_빙빙_돌기 {
	public static int dir = 0;
	public static int[] dx = { -1, 0, 1, 0 };
	public static int[] dy = { 0, -1, 0, 1 };
	public static void func(int[][] grid, int cx, int cy, int n) {
		int num = n*n;
		grid[cy][cx] = num--; // 초기값을 'A'로 지정
		for(int i=1; i<n*n; i++) { // 초기값을 제외한 n*m개의 칸에 대해서
			while(true) { // 이동할 수 있을 때까지 방향(dir)을 바꿔서 확인
				int nx = cx + dx[dir]; // x의 방향을 갱신
				int ny = cy + dy[dir]; // y의 방향을 갱신
				if(nx>=0 && ny>=0 && nx<n && ny<n && grid[ny][nx]==0) { // 다음 칸으로 이동할 수 있다면(범위 이탈 방지)
					grid[ny][nx] = num--; // 다음으로 이동하는 칸에 현재 알파벳+1
					cx = nx; // 현재 x를 갱신
					cy = ny; // 현재 y를 갱신
					break; // 이동했으면 다음 알파벳의 이동을 위해서 루프를 빠져나옴
				} else { // 다음 칸으로 이동할 수 없다면
					dir = (dir+1)%4; // 방향을 바꿔준다
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];
			
			func(grid, n-1, n-1, n);
			
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
