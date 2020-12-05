package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment2_1 {
	public static int cnt =0;
	public static void func(int[][] arr, ArrayList<Integer> dfs, int m, int n, int row, int col, boolean[][] visited) {
		if(arr[row][col]==0 && visited[row][col]==false) { // 해당 위치의 값이 0인 경우 방문했음을 표시하고 cnt 1증가
			cnt++; // 경로가 끊키지 않고 이어질 때마다 영역의 크기 1 증가
			visited[row][col] = true; // 해당 위치를 방문했음을 표시
			// 상하좌우로 갈 수 있는지 없는지 검사해서 해당 방향으로 갈 수 있으면 재귀적으로 호출
			if(row-1>=0 && arr[row-1][col]==0 && visited[row-1][col]==false) { // 위쪽 원소의 값이 0이고 방문했는지
				func(arr, dfs, m, n, row-1, col, visited);
			}
			if(row+1<m && arr[row+1][col]==0 && visited[row+1][col]==false) { // 아래쪽 원소의 값이 0이고 방문했는지
				func(arr, dfs, m, n, row+1, col, visited);
			}
			if(col-1>=0 && arr[row][col-1]==0 && visited[row][col-1]==false) { // 왼쪽 원소의 값이 0이고 방문했는지
				func(arr, dfs, m, n, row, col-1, visited);
			}
			if(col+1<n && arr[row][col+1]==0 && visited[row][col+1]==false) { // 오른쪽 원소의 값이 0이고 방문했는지
				func(arr, dfs, m ,n, row, col+1, visited);
			}
		}
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] size = bufReader.readLine().split(" "); // 테스트 케이스의 개수를 입력받기 위한 변수
			int m = Integer.parseInt(size[0]);
			int n = Integer.parseInt(size[1]);
			
			int[][] arr = new int[m][n];
			for(int i=0; i<m; i++) {
				String[] line = bufReader.readLine().split("");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			ArrayList<Integer> dfs = new ArrayList<Integer>();
			
			boolean[][] visited = new boolean[m][n];

			for(int row=0; row<m; row++) {
				for(int col=0; col<n; col++) {
					func(arr, dfs, m, n, row, col, visited); // 모든 원소에 대해서 검사해야하므로 mxn만큼 반복
					if(cnt>0)	dfs.add(cnt); // 각각의 영역의 크기를 ArrayList에 삽입(영역의 크기가 0인 경우를 제외) 
					cnt = 0; // 경로가 끊킨 경우 영역의 크기도 0으로 초기화
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<dfs.size(); i++)
				if(dfs.get(i) > max) max = dfs.get(i);
			
			System.out.println(dfs.size()+" "+max);

			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
