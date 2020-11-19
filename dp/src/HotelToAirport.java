package com.assignment.no5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment5_1 {
	public static int func(int n, int[] ud, int[] ld, int[] utol, int[] ltou) {
		int[][] dp = new int[2][n+2]; // 도로의 길이가 n+1까지 이어지므로 총 n+2있다고 생각해야함
		for(int i=1; i<=n; i++) { // hotel로 이동하는 경우는 존재하지 않으므로 dp[0][0]=0, dp[1][0]=0
			dp[0][i] = Math.min(dp[0][i-1]+ud[i], dp[1][i-1]+ld[i]+ltou[i]);
			// dp[0][i] = 왼쪽에서 오는 경우(현재 위치의 왼쪽 교차로까지 오는데 걸리는 최소 시간 dp[0][i-1] 
			//				 + 왼쪽 교차로에서 현재 교차로까지 오는데 걸리는 시간 ud[i])
			//				 vs
			//				 아래쪽에서 오는 경우(현재 위치의 왼쪽 대각선 교차로까지 오는데 걸리는 최소 시간 dp[1][i-1]
			//				 + 현재 위치의 왼쪽 대각선 교차로에서 현재 위치의 아래쪽 교차로까지 오는데 걸리는 시간 ld[i]
			//				 + 아래쪽 교차로에서 현재 교차로까지 오는데 걸리는 시간 ltou[i])

			dp[1][i] = Math.min(dp[1][i-1]+ld[i], dp[0][i-1]+ud[i]+utol[i]);
			// dp[1][i] = 왼쪽에서 오는 경우(현재 위치의 왼쪽 교차로까지 오는데 걸리는 최소 시간 dp[1][i-1] 
			//				 + 왼쪽 교차로에서 현재 교차로까지 오는데 걸리는 시간 ld[i])
			//				 vs
			//				 위쪽에서 오는 경우(현재 위치의 왼쪽 대각선 교차로까지 오는데 걸리는 최소 시간 dp[0][i-1]
			//				 + 현재 위치의 왼쪽 대각선 교차로에서 현재 위치의 위쪽 교차로까지 오는데 걸리는 시간 ud[i]
			//				 + 위쪽 교차로에서 현재 교차로까지 오는데 걸리는 시간 utol[i])
		}
		dp[0][n+1] = dp[0][n]+ud[n+1]; // 위로 올라오지 않고 바로 공항으로 가는 경우만 존재하므로 이에 대한 예외처리
		dp[1][n+1] = dp[1][n]+ld[n+1]; // 아래로 내려오지 않고 바로 공항으로 가는 경우만 존재하므로 이에 대한 예외처리
		return Math.min(dp[0][n+1], dp[1][n+1]); // 위의 두 값 중에서 더 작은 값을 선택해서 반환
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String size = bufReader.readLine(); // // 테스트 케이스를 입력받는 변수
			int n = Integer.parseInt(size);
			String[] upper = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			String[] lower = bufReader.readLine().split(" ");
			String[] utol = bufReader.readLine().split(" ");
			String[] ltou = bufReader.readLine().split(" ");
			
			int[] ud = new int[n+2];
			int[] ld = new int[n+2];
			int[] ul = new int[n+1];
			int[] lu = new int[n+1];
			
			for(int i=1; i<=n+1; i++) { // u[0], l[0]은 값이 0이므로 그것들을 제외해서 대입
				ud[i] = Integer.parseInt(upper[i-1]);
				ld[i] = Integer.parseInt(lower[i-1]);
			}
			for(int i=1; i<=n; i++) { // ul[0],0 lu[0]은 값이 0이므로 그것들을 제외해서 대입
				ul[i] = Integer.parseInt(utol[i-1]);
				lu[i] = Integer.parseInt(ltou[i-1]);
			}

			System.out.println(func(n, ud, ld, ul, lu));
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
