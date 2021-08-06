package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Lesson2_4 {
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };
	public static void func(ArrayList<Integer> list, int[][] arr, int n, int row, int col) {
		boolean loop;
		list.add(arr[row][col]);
		do {
			loop = false; // while문이 반복 수행되는 경우 loop를 재사용해주기 위해서 false로 변경
			for(int i=0; i<4; i++) {
				int nx = col + dx[i];
				int ny = row + dy[i];
				if(ny>=0 && ny<n && nx>=0 && nx<n && arr[ny][nx]>arr[row][col]) { // 다음 방문할 숫자의 좌표가 범위를 벗어나지 않았고, 현재 숫자보다 값이 클 경우
					list.add(arr[ny][nx]); // 방문한 숫자를 리스트에 저장
					row = ny; col = nx; // 다음에 방문할 숫자의 좌표는 다음 반복문에서 현재 숫자의 좌표가 되므로
					loop = true; // 위의 조건문을 만족했으므로 while문을 반복할 것임을 표시
					break; // '상하좌우'의 우선순위를 통해서 현재 숫자의 값보다 큰 숫자를 찾으면 바로 for문을 빠져나옴
				}
			}
		} while(loop); // loop의 true/false 여부에 따라서 탐색 과정을 계속할지 판단
//		int max = tmp.get(0);
//		for(int i=1; i<tmp.size(); i++)
//			if(tmp.get(i)>max) max = tmp.get(i);
//		list.add(max);
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int r = Integer.parseInt(tmp[1])-1; // 편의상 1부터 n의 범위를 0부터 n-1의 범위로 변경
			int c = Integer.parseInt(tmp[2])-1; // 편의상 1부터 n의 범위를 0부터 n-1의 범위로 변경
			
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>(); // 방문한 숫자를 저장하기 위한 ArrayList 선언
			func(list, arr, n, r, c);
			for(int i=0; i<list.size(); i++)
				bw.write(list.get(i)+" ");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
