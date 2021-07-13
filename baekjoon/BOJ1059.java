package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ1059 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int l = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[l];
			for(int i=0; i<arr.length; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			Arrays.sort(arr); // 알고리즘을 적용하기 위해서 오름차순으로 정렬
			
			int cnt = 0;
			// 좋은 구간이 집합 S의 가장 작은 숫자보다 작은 경우
			for(int i=1; i<arr[0]; i++) { 
				for(int j=i+1; j<arr[0]; j++) {
					if((n>=i && n<=j) && j < arr[0]) cnt++; //n이 i와 j 사이에 존재하고 집합 S의 가장 작은 숫자보다 작은 경우 +1
				}
			}
			// 좋은 구간이 집합 S의 숫자들 사이에 위치하는 경우
			for(int i=0; i<arr.length-1; i++) {
				for(int j=arr[i]+1; j<arr[i+1]; j++) { // 집합 S의 i번째 숫자+1부터 i+1번째 숫자 전까지의 경우에 대해서
					for(int k=j+1; k<arr[i+1]; k++) { // 집합 S의 i번째 숫자+2부터 i+1번째 숫자 전까지의 경우에 대해서
						if((n>=j && n<=k) && k < arr[i+1]) cnt++; // n이 j와 k 사이에 존재하고 집합 S의 i+1번째 숫자보다 작은 경우 +1
					}
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