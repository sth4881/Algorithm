package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ8911 {
	public static int dir = 0;
	public static int[] dx = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
	public static int[] dy = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
	public static int[][] grid;
	public static void turtle(String input) {
		int x, y;
		x = y = 250;
		grid[x][y] = 1;
		for(int i=0; i<input.length(); i++) {
			int nx, ny;
			switch(input.substring(i)) {
			// 거북이가 앞으로 가는 경우
			case "F":
				nx = x + dx[dir];
				ny = y + dy[dir];
				grid[nx][ny] = 1;
				x = nx; y = ny;
				break;
			// 거북이가 뒤로 가는 경우(0->2, 1->3, 2->0, 3->1)
			case "B":
				nx = x + dx[(dir+2)%4];
				ny = y + dy[(dir+2)%4];
				grid[nx][ny] = 1;
				x = nx; y = ny;
				break;
			// 거북이가 왼쪽으로 회전하는 경우(0->3, 1->0, 2->1, 3->2)
			case "L":
				if(dir==0) dir = 3;
				else dir -= 1; 
				break;
			// 거북이가 오른쪽으로 회전하는 경우(0->1, 1->2, 2->3, 3->0)
			case "R":
				dir = dir%3+1;
				if(dir==3) dir = 0;
				break;
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int t = Integer.parseInt(br.readLine());
			grid = new int[501][501];
			for(int i=0; i<t; i++) {
				String input = br.readLine();
				turtle(input);
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
