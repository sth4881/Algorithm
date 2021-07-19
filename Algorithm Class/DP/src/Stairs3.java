package com.assignment.no4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Assignment1_3 {
	public static void func(int n, int k, int[] stairs) {
		int[] arr = new int[n+1];
		arr[0] = 0;
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.MAX_VALUE; // 배열을 선언해주는 경우 0으로 자동 초기화되는데
												  // 아래의 if문과 0이 비교되는 것을 막아주기 위해서 최댓값으로 설정
			for(int j=0; j<k; j++) {
				// 알고리즘의 핵심 코드
				if( i>=stairs[j] && arr[i]>arr[i-stairs[j]] ) // i-stairs[j]는 0이 될 수 없으므로 i>=stairs[j],
																  // stairs[0]~stairs[k-1] 중에서 어떤 계단을 사용해야
																  // 최소 계단을 밟는 경우가 되는지를 알 수 없으므로 
																  // arr[i]>arr[i-stairs[j]]인 경우를 최소 계단을 밟은 경우의 수로 선택
					arr[i] = arr[i-stairs[j]]+1; // 한번에 stairs[j]만큼 계단을 올라가면 계단을 1회 밟은 것이므로 +1,
												   // 추가로 i개의 계단을 한번에 올라가기 위한 최소 계단 수 arr[i-stairs[j]]만큼 더해줌 
			}
		}
		for(int i=1; i<=n; i++)
			if(arr[i]==Integer.MAX_VALUE) arr[i] = -1; // MAX_VALUE인 값은 주어진 계단 단위들로는 올라갈 수 없음을 의미하므로 -1 대입
		System.out.println(arr[n]);
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] temp = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			int n = Integer.parseInt(temp[0]); // 올라가야하는 총 계단 수
			int k = Integer.parseInt(temp[1]); // 올라갈 수 있는 계단의 단위 개수
			String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수
			
			int[] stairs = new int[k];
			for(int i=0; i<k; i++)
				stairs[i] = Integer.parseInt(input[i]); // 1회에 올라갈 수 있는 계단의 개수 설정
			
			func(n, k, stairs);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
