package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 박스_굴리기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			int[][] rotated = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					rotated[j][n-1-i] = arr[i][j];
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					bw.write(rotated[i][j]+" ");
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
