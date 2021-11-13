package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ5212 {
	public static char[][] island, newIsland;
	public static void makeMap(int row, int col) {
		for(int i=1; i<row+1; i++) {
			for(int j=1; j<col+1; j++) {
				int cnt = 0;
				if(island[i][j]=='.') continue;
				// 상
				if(island[i-1][j]=='.') cnt++;
				// 하
				if(island[i+1][j]=='.') cnt++;
				// 좌
				if(island[i][j-1]=='.') cnt++;
				// 우
				if(island[i][j+1]=='.') cnt++;
				// cnt가 3이상이라면 해당 위치의 X값을 '.'으로 변경
				if(cnt>=3) newIsland[i][j] = '.';
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] input = br.readLine().split(" ");
			int r = Integer.parseInt(input[0]);
			int c = Integer.parseInt(input[1]);
			
			island = new char[r+2][c+2];
			newIsland = new char[r+2][c+2];
			for(int i=1; i<r+1; i++) {
				String map = br.readLine();
				for(int j=1; j<c+1; j++) {
					island[i][j] = newIsland[i][j] = map.charAt(j-1);
				}
			}
			
			makeMap(r, c);
			int minR, maxR, minC, maxC;
			minR = minC = Integer.MAX_VALUE;
			maxR = maxC = Integer.MIN_VALUE;
			for(int i=1; i<r+1; i++) {
				for(int j=1; j<c+1; j++) {
					if(newIsland[i][j]=='X') {
						minR = Math.min(minR,  i);
						maxR = Math.max(maxR,  i);
						minC = Math.min(minC,  j);
						maxC = Math.max(maxC,  j);
					}
				}
			}

			for(int i=minR; i<maxR; i++) {
				for(int j=minC; j<maxC; j++)
					bw.write(newIsland[i][j]+"");
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
