package com.algorithm;

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
	public Marble(int row, int col) {
		this.row = row;
		this.col = col;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
}

public class Lesson2_5 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static void func(int[][] arr, ArrayList<Marble> marbleList, int[][] marbleArr, int n, int m, int t) {
		for(int k=0; k<t; k++) {
			int max = 0;
			int max_col = 0;
			int max_row = 0;
			// 숫자가 가장 큰 인접한 곳으로 동시에 이동하는 알고리즘
			for(int i=0; i<marbleList.size(); i++) {
				int row = marbleList.get(i).getRow(); // i번째 구슬의 행 좌표를 불러옴
				int col = marbleList.get(i).getCol(); // i번째 구슬의 열 좌표를 불러옴
				for(int j=0; j<4; j++) {
					int nx = col+ dx[j];
					int ny = row + dy[j];
					if(ny>=0 && ny<n && nx>=0 && nx<n) { // 다음 방문할 숫자의 좌표가 범위를 벗어나지 않았고, 상하좌우에 위치한 값 중에서 값이 제일 클 경우
						if(arr[ny][nx]>arr[row][col] && arr[ny][nx]>max) {
							marbleList.get(i).setRow(ny); // 현재 구슬의 행 값을 갱신
							marbleList.get(i).setCol(nx); // 현재 구슬의 열 값을 갱신
							max = arr[ny][nx];
							max_row = ny;
							max_col = nx;
						}
					}
				}
				// 위의 과정을 통해서 구슬의 위치를 갱신
				if(max>0) { // 최대값에 변화가 있다면
					marbleArr[row][col] = 0; // 현재 위치의 값을 0으로 만들고
					marbleArr[max_row][max_col] += 1; // 다음 방문할 위치의 값을 1로 만들어서 구슬의 위치를 갱신
				}
				max = 0; // max값을 재사용해주기 위해서 0으로 초기화
			}
			
			System.out.println("hello");
			
			// 구슬의 위치가 겹치는지를 검사해서 겹치면 객체를 제거하는 알고리즘
			int tmp = marbleList.size();
			for(int i=0; i<tmp; i++) {
				int row = marbleList.get(i).getRow();
				int col = marbleList.get(i).getCol();
				System.out.println("i="+i+" "+row+" "+col+" "+arr[row][col]+" "+marbleArr[row][col]);
//				if(marbleArr[row][col]>1) marbleList.remove(i);
			}
			
			// 구슬의 위치가 겹치는지를 검사해서 겹치면 값을 0으로 만드는 알고리즘
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(marbleArr[i][j]>1) marbleArr[i][j] = 0;		
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
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			ArrayList<Marble> marbleList = new ArrayList<Marble>();
			int[][] marbleArr = new int[n][n];
			for(int i=0; i<m; i++) {
				tmp = br.readLine().split(" ");
				int r = Integer.parseInt(tmp[0])-1;
				int c = Integer.parseInt(tmp[1])-1;
				Marble marble = new Marble(r, c);
				marbleList.add(marble);
				marbleArr[r][c] = 1;
			}
			func(arr, marbleList, marbleArr, n, m, t);
			
			bw.write(marbleList.size()+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
