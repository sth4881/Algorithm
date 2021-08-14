package com.algorithm.codetree;

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

public class Simulation_Lesson_5 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static void func(ArrayList<Marble> marbles, int[][] grid, int[][] location, int n, int m) {
		int[][] tmp = new int[n][n];
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
			
			// 구슬이 원래 위치한 값의 위치를 0으로 만들어줌(아예 이동하지 않는 경우는 없기 때문에)
			location[marble.getRow()][marble.getCol()] = 0;
			if(max>0) {
				marbles.get(i).setRow(max_row);
				marbles.get(i).setCol(max_col);
				tmp[max_row][max_col] += 1; // location[marble.getRow()][marble.getCol()] = 0; 코드 때문에
															// 구슬을 모두 옮기기 전에 구슬이 이동한 위치로 겹치는 일이 발생하면 
															// 구슬이 삭제되버리기 때문에 답이 틀리게 되는데, 그것을 방지하기 위해서
															// 임시 배열 tmp에 옮겨지는 구슬의 위치에 +1을 해줌
			}
			// max, max_col, max_row를 재사용하기 위해서 0으로 초기화
			max = 0;
			max_col = 0;
			max_row = 0;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(tmp[i][j]>1) marbles.remove(new Marble(i, j)); // 구슬이 해당 위치에 2개 이상 있으면 marbles에서 제거
				if(tmp[i][j]==1) location[i][j] = tmp[i][j]; // 임시 위치 배열에 저장된 위치에 구슬이 한 개만 있다면 원래 위치 배열로 위치를 옮겨옴
			}
		}
	
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(location[i][j]+" ");
			System.out.println();
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
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					System.out.print(location[i][j]+" ");
				System.out.println();
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