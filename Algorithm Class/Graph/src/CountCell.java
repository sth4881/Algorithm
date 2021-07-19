package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment1_1 {
	public static int cnt = 0;
	public static void func(int[] arr, int vtx, boolean[] visited) {
		cnt++; // 셀을 이동할 때마다 cnt 1증가
		visited[vtx] = true; // 방문한 셀에 대해서 방문했음을 표시
		
		if(vtx-arr[vtx]>=0) {
			if(!visited[vtx-arr[vtx]]) {
				func(arr, vtx-arr[vtx], visited);
			}
		}
		
		if(vtx+arr[vtx]<arr.length) {
			if(!visited[vtx+arr[vtx]]) {
				func(arr, vtx+arr[vtx], visited);
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
			
			int n = Integer.parseInt(bufReader.readLine()); // 테스트 케이스의 개수를 입력받기 위한 변수
			int start = Integer.parseInt(bufReader.readLine()); // 시작 셀 위치
			String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수

			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			boolean[] visited = new boolean[n];
			
			func(arr, start, visited);
			System.out.println(cnt);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
