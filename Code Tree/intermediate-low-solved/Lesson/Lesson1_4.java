package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Lesson1_4 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			int[][] arr = new int[n][m];
			
			int num = 0;
			for(int i=0; i<m; i++) {
				if(i%2==0 ) { // 홀수 열의 경우
					for(int j=0; j<n; j++) { // 정방향으로 열 채우기
						arr[j][i] = num;
						num++;
					}
				} else { // 짝수 열의 경우
					for(int j=n-1; j>=0; j--) { // 역방향으로 열 채우기
						arr[j][i] = num;
						num++;
					}
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++)
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
