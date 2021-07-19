package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11047 {
	public static void func(int[] arr, int n, int k) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			int cnt = 0;
			for(int i=n-1; i>=0; i--) {
				while(arr[i]<=k) {
					k -= arr[i];
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
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] tmparr = br.readLine().split(" ");
			int n = Integer.parseInt(tmparr[0]);
			int k = Integer.parseInt(tmparr[1]);
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				String tmp = br.readLine();
				arr[i] = Integer.parseInt(tmp);
			}
			func(arr, n, k);
			
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
