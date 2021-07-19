package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_2 {
	public static int func(int m, int n, int[][] grid) {
		int sum = 0;
		if(n==1) { // 열이 하나만 존재할 경우 나머지 원소들을 모두 더함으로써 예외처리
			for(int i=0; i<m; i++)
				sum += grid[i][0];
			return sum;
		}
		
		if(m==1) { // 행이 하나만 존재할 경우 원소들 중에서 가장 작은 값을 반환함으로써 예외처리
			int min = Integer.MAX_VALUE;
			for(int j=0; j<n; j++) {
				if(grid[0][j] < min)
					min = grid[0][j];
			}
			return min;
		}

		// 비용을 처리하기 위한 배열 생성
		int[][] arr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = grid[i][j];
			}
		}

		// 알고리즘
		for(int i=m-2; i>=0; i--) {
			for(int j=0; j<n; j++) {
				if(j==0) { // 왼쪽 끝 원소의 비용을 처리하는 경우
					if(arr[i+1][j] < arr[i+1][j+1]) // 아래쪽과 우측 하단에 있는 원소를 비교해서 작은 값을 더하기
						arr[i][j] += arr[i+1][j];
					else arr[i][j] += arr[i+1][j+1];
				}
				else if(j==n-1) { // 오른쪽 끝 원소의 비용을 처리하는 경우
					if(arr[i+1][j] < arr[i+1][j-1]) // 아래쪽과 좌측 하단에 있는 원소를 비교해서 작은 값을 더하기
						arr[i][j] += arr[i+1][j];
					else arr[i][j] += arr[i+1][j-1];
				}
				else { 
					// 위의 예외들을 제외한 일반적인 경우로
					// 좌측 하단 원소와 우측 하단 원소와 아래쪽 원소를 비교해서 작은 값을 더하기
					if(arr[i+1][j-1] < arr[i+1][j]) {
						if(arr[i+1][j-1] < arr[i+1][j+1])
							arr[i][j] += arr[i+1][j-1];
						else arr[i][j] += arr[i+1][j+1];
					} else {
						if(arr[i+1][j] < arr[i+1][j+1])
							arr[i][j] += arr[i+1][j];
						else arr[i][j] += arr[i+1][j+1];
					}
				}
			}
		}

		// 가장 위쪽 행에서 최소값을 갖는 원소를 반환
		int min = Integer.MAX_VALUE;
		for(int j=0; j<n; j++) {
			if(arr[0][j] < min)
				min = arr[0][j];
		}
		return min;
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] size = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			int m = Integer.parseInt(size[0]); // 올라가야하는 계단의 개수
			int n = Integer.parseInt(size[1]); // 올라가야하는 계단의 개수
			int[][] grid = new int[m][n];
			
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
				for(int j=0; j<n; j++) {
					grid[i][j] = Integer.parseInt(input[j]);
				}
			}

			System.out.println(func(m, n, grid));
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
