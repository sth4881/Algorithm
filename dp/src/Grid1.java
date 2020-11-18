package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment2_1 {
	public static int func(int m, int n, int[][] arr) {
		int sum=0;
		if(n==1) { // 열이 하나만 존재할 경우 나머지 원소들을 모두 더함으로써 예외처리
			for(int i=0; i<m; i++)
				sum += arr[i][0];
			return sum;
		}
		
		if(m==1) { // 행이 하나만 존재할 경우 원소들 중에서 가장 작은 값을 반환함으로써 예외처리
			int min = Integer.MAX_VALUE;
			for(int j=0; j<n; j++)
				sum += arr[0][j];
			return sum;
		}
		
		// 왼쪽 끝에 있는 원소는 무조건 아래쪽 원소 비용만 더하므로 예외 처리
		for(int i=m-2; i>=0; i--)
			arr[i][0] += arr[i+1][0];
		// 아래쪽 끝에 있는 원소는 무조건 왼쪽 원소 비용만 더하므로 예외 처리
		for(int j=1; j<n; j++)
			arr[m-1][j] += arr[m-1][j-1];
		// 예외 처리하는 경우를 제외하면 해당 원소의 왼쪽과 아래쪽 원소를 비교해서
		// 더 작은 값을 현재 원소와 합해서 대입하는 방식
		for(int i=m-2; i>=0; i--) {
			for(int j=1; j<n; j++) {
				arr[i][j] += Math.min(arr[i+1][j], arr[i][j-1]);
			}
		}
		return arr[0][n-1]; // 두 개의 방식 중에서 더 작은 값을 반환
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
