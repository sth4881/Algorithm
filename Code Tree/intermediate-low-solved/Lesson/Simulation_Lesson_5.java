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
    public static ArrayList<Marble> func(ArrayList<Marble> marbles, int[][] grid, int[][] location, int n, int m) {
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
        
        marbles = new ArrayList<Marble>(); // marbles에 새로운 ArrayList 삽입
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(tmp[i][j]==1) { // tmp가 1인 경우에 구슬이 그 위치에 있다고 생각
                	marbles.add(new Marble(i, j)); // 해당 위치의 행과 열로 새로운 마블 객체를 생성
                }
            }
        }

        return marbles;
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
                marbles = func(marbles, grid, location, n, m); // 구슬들을 움직이는 과정 후에 위치값들을 계속 갱신
            }
            
            bw.write(marbles.size()+"\n"); // ArrayList에 존재하는 marble의 개수를 출력
            bw.close();
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}