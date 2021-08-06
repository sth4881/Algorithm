package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Lesson2_1 {
	public static int getGold(int[][] arr, int row, int col) { // row와 col을 기점으로 3x3 격자 내의 동전 개수 구하기
		int cnt = 0;
		for(int i=row; i<=row+2; i++) {
			for(int j=col; j<=col+2; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String tmp[] = br.readLine().split(" ");
				for(int j=0; j<tmp.length; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			// 3x3 격자로 동전 개수 추출
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i>=n-2 || j>=n-2) continue;
					list.add(getGold(arr, i, j));
				}
			}
			
			// 동전 개수를 최대로 찾는 3x3 격자 구하기
			int max = Integer.MIN_VALUE;
			for(int i=0; i<list.size(); i++) {
				if(list.get(i) > max) max = list.get(i);
			}
			
			bw.write(max+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
