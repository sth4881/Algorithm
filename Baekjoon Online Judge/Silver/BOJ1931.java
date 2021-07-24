package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ1931 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(tmp[0]);
				arr[i][1] = Integer.parseInt(tmp[1]);
			}
			
			// 회의 종료시간(arr[i][1])을 기준으로 정렬하기 위해서 Comparator를 이용하여 compare 메소드를 재정의
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[1]==o2[1]) return o1[0] - o2[0]; // 종료시간이 같을 경우 시작시간이 빠른 순서대로 회의를 정렬
					else return o1[1] - o2[1]; // 그 외의 경우에 대해서는 종료시간이 빠른 순서대로 회의를 정렬
				}
			});
			
			// 알고리즘
			int cnt = 1; // 사용할 수 있는 회의 개수를 1로 초기화
			int endTime = arr[0][1]; // 회의 종료시간을 첫번째 회의의 종료시간으로 초기화
			for(int i=1; i<n; i++) {
				if(endTime <= arr[i][0]) { // i번째 회의 시작시간이 이전 회의 종료시간과 같거나 더 늦을 경우  
					endTime = arr[i][1]; // 회의 종료시간을 갱신
					cnt++; // 회의의 개수를 1 증가
				}
			}
			
			bw.write(cnt+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}