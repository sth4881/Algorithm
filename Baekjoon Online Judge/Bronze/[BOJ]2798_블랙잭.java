package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2798 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			int[] arr = new int[n];
			tmp = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(tmp[i]);
			}
			
			int max = 0;
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					for(int k=j+1; k<n; k++) {
						int sum = arr[i]+arr[j]+arr[k];
						if(sum<=m && sum > max) max = sum; // M을 넘지 않는 최대값이 되는 sum을 찾기
					}
				}
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
