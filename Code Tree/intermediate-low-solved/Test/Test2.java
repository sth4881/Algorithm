package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Test2 {
	// 최고의 13위치 2
	public static void func(ArrayList<Integer> list, int[][] grid, int row, int col, int n) {
		int cnt = 0; // 동전의 개수를 세기 위한 변수 cnt
		for(int i=col; i<=col+2; i++) // 첫번째 1x3 격자를 고정
			if(grid[row][i]==1) cnt++; // 1x3 격자 내에 동전이 있다면 cnt 1 증가
		int save = cnt;
		
		// 1. 첫번째 격자가 위치한 행에 두번째 격자를 설치하는 경우
		for(int i=col+3; i<n-2; i++) { // 첫번째 줄에 있는 두번째 격자를 col+3부터 맨 끝까지 이동
			for(int j=i; j<=i+2; j++) // 두번째 1x3 격자에 대해서
				if(grid[row][j]==1) cnt++; // 동전이 존재하면 cnt 1 증가
			list.add(cnt); // 첫번째 1x3 격자와 두번째 1x3 격자를 통해서 카운트한 동전의 개수를 list에 추가
			cnt = save; // cnt를 첫번째 1x3 격자로부터 카운트된 동전의 개수로 초기화
		}
		
		// 2. 첫번째 격자가 위치한 행의 아래 행들에 두번째 격자를 설치하는 경우
		for(int i=row+1; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(j>=n-2) continue; // 두번째 1x3 격자가 nxn 격자를 벗어나지 않게 제한
				for(int k=j; k<=j+2; k++)// 두번째 1x3 격자에 대해서
					if(grid[i][k]==1) cnt++; // 동전이 존재한면 cnt 1 증가
				list.add(cnt); // 첫번째 1x3 격자와 두번째 1x3 격자를 통해서 카운트한 동전의 개수를 list에 추가
				cnt = save; // cnt를 첫번째 1x3 격자로부터 카운트된 동전의 개수로 초기화
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] grid = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(j>=n-2) continue; // 첫번째 1x3 격자가 nxn 격자를 벗어나지 않게 제한
					func(list, grid, i, j, n);
				}
			}
			
			// 동전 개수를 최대로 찾는 경우의 수 구하기
			int max = Integer.MIN_VALUE;
			for(int i=0; i<list.size(); i++)
				if(list.get(i) > max) max = list.get(i);
			bw.write(max+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
