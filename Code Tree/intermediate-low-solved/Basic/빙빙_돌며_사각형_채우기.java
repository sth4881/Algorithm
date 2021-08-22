package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 빙빙_돌며_사각형_채우기 {
	public static int cx =0, cy = 0, dir = 0;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static void func(char[][] grid, int n, int m) {
		grid[cy][cx] = 'A'; // 초기값을 'A'로 지정
		for(int i=1; i<n*m; i++) { // 초기값을 제외한 n*m개의 칸에 대해서
			while(true) { // 이동할 수 있을 때까지 방향(dir)을 바꿔서 확인
				int nx = cx + dx[dir]; // x의 방향을 갱신
				int ny = cy + dy[dir]; // y의 방향을 갱신
				if(nx>=0 && ny>=0 && nx<m && ny<n && grid[ny][nx]=='\u0000') { // 다음 칸으로 이동할 수 있다면(범위 이탈 방지 & 다음 칸에 어떤 알파벳도 들어가있지 않으면)
					grid[ny][nx] = (char) (i%26+'A'); // 다음으로 이동하는 칸에 현재 알파벳+1
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
			
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			char[][] grid = new char[n][m];
			func(grid, n, m);
			
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
