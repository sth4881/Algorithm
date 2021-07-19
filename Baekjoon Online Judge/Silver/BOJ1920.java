package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ1920 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			Arrays.sort(arr);
			
			int m = Integer.parseInt(br.readLine());
			tmp = br.readLine().split(" ");
			int[] target = new int[m];
			for(int i=0; i<m; i++) {
				target[i] = Integer.parseInt(tmp[i]);
			}
			
			int left = 0;
			int right = n-1;
			for(int i=0; i<m; i++) {
				while(right-left >= 0) {
					int mid = (right+left)/2;
					if(arr[mid] == target[i]) { // 배열 arr에 찾고자 하는 숫자가 존재할 때
						target[i] = 1;
						break;
					} else if(arr[mid] > target[i]) { // 찾고자 하는 목표물이 기준이 되는 숫자보다 작다면(기준이 되는 숫자 배열의 오른쪽은 보지 않음)
						right = mid-1; // mid도 탐색 대상에서 제외되기 때문에 mid-1
					} else if(arr[mid] < target[i]) { // 찾고자 하는 목표물이 기준이 되는 숫자보다 크다면(기준이 되는 숫자 배열의 왼쪽은 보지 않음)
						left = mid+1;  // mid도 탐색 대상에서 제외되기 때문에 mid+1
					}
					if(right-left < 0) { // 배열 arr에 찾고자 하는 숫자가 존재하지 않을 때
						target[i] = 0;
						break;
					}
				}
				left = 0; // left를 재활용하기 위해서
				right = n-1; // right를 재활용하기 위해서
			}
			
			for(int i=0; i<m; i++)
				bw.write(target[i]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
