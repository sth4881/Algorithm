package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class BOJ1417 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int target = Integer.parseInt(br.readLine());
			Integer[] arr = new Integer[n-1];
			for(int i=0; i<n-1; i++)
				arr[i] = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			if(n!=1) {
				while(true) {
					// 기호 1번을 제외한 최다득표수의 표를
					// 가져오지 않으면 올바른 결과가 도출되지 않음
					Arrays.sort(arr, Collections.reverseOrder());
					if(target > arr[0]) break;
					target++;
					arr[0]--;
					cnt++;
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