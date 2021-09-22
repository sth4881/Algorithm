package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 십자_모양_폭발 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0 ,0 };
	public static int[][] func(int[][] arr, int row, int col, int n) {
		// 폭발 범위에 휩싸인 값들을 0으로 변환
		for(int i=0; i<4; i++) {
			int nx = col;
			int ny = row;
			for(int j=0; j<arr[row][col]-1; j++) {
				nx += dx[i];
				ny += dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<n) arr[ny][nx] = 0;
			}
		}
		arr[row][col] = 0;
		
		// 중력에 의해서 각각의 값들을 밑으로 이동
		for(int i=n-1; i>0; i--) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]==0) {
					arr[i][j] = arr[i-1][j];
					arr[i-1][j] = 0;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String[] str = br.readLine().split(" ");
				for(int j=0; j<str.length; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			
			String[] str = br.readLine().split(" ");
			int row = Integer.parseInt(str[0])-1;
			int col = Integer.parseInt(str[1])-1;

			if(n==1) bw.write(0+"\n");
			else {
				int[][] ans = func(arr, row, col, n);
				for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++)
						bw.write(ans[i][j]+" ");
					bw.write("\n");
				}
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
