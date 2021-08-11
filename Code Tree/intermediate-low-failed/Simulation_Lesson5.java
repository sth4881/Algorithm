package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Marble {
	private int row = 0;
	private int col = 0;
	Marble(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public int getRow() {
		return this.row;
	}
	public int getCol() {
		return this.col;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
}

public class Simulation_Lesson5 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static void func(ArrayList<Marble> marbles, int[][] grid, int[][] location, int n, int m) {
		int max = 0;
		int max_col = 0;
		int max_row = 0;
		for(int i=0; i<marbles.size(); i++) {
			Marble marble = marbles.get(i);
			for(int j=0; j<4; j++) {
				int nx = marble.getCol() + dx[j];
				int ny = marble.getRow() + dy[j];
				if(nx>=0 && nx<n && ny>=0 && ny<n) { // 범위를 벗어나지 않게 하는 조건문
					if(grid[ny][nx]>max) { // 현재 구슬의 위치의 값보다 다음에 이동할 위치의 값이 크다면
						max = grid[ny][nx];
						max_row = ny;
						max_col = nx;
					}
				}
			}
			if(max>0) {
//				System.out.println(max_row+" "+max_col+" "+max);
				location[marble.getRow()][marble.getCol()] = 0; // 이슈가 발생하는 부분
				location[max_row][max_col] += 1;
				marbles.get(i).setRow(max_row);
				marbles.get(i).setCol(max_col);
			}
			max = 0;
			max_col = 0;
			max_row = 0;
		}

		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(location[i][j]+" ");
			System.out.println();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(location[i][j]>1) {
					marbles.remove(new Marble(i, j));
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(location[i][j]>1) {
					location[i][j] = 0;
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			int t = Integer.parseInt(tmp[2]);
			
			int[][] grid = new int[n][n];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			ArrayList<Marble> marbles = new ArrayList<Marble>();
			int[][] location = new int[n][n];
			for(int i=0; i<m; i++) {
				tmp = br.readLine().split(" ");
				int row = Integer.parseInt(tmp[0])-1;
				int col = Integer.parseInt(tmp[1])-1;
				marbles.add(new Marble(row, col));
				location[row][col] = 1;
			}
			
			// t번만큼 m개의 구슬을 움직임
			for(int i=0; i<t; i++) {
				func(marbles, grid, location, n, m);
			}
			
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(location[i][j]==1) {
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
