package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Lesson2_2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int t = Integer.parseInt(tmp[1]);
			
			int[][] arr = new int[2][n];
			for(int i=0; i<2; i++) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			
			for(int i=0; i<t; i++) {
				int tmp1 = arr[0][n-1]; // 우측 상단 원소 -> 좌측 하단으로 옮기기
				int tmp2 = arr[1][n-1]; // 우측 하단 원소 -> 좌측 상단으로 옮기기
				for(int k=n-2; k>=0; k--)
					arr[0][k+1] = arr[0][k];
				for(int k=n-2; k>=0; k--)
					arr[1][k+1] = arr[1][k];
//				for(int k=0; k<n-1; k++) {
//					arr[1][k] = arr[1][k+1];
//				}
				arr[1][0] = tmp1;
				arr[0][0] = tmp2;
			}
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<n; j++)
					bw.write(arr[i][j]+" ");
				bw.write("\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
