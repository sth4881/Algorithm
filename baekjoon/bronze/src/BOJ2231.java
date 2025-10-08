package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 2231번 분해합 (Bronze) */
public class BOJ2231 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String input = br.readLine();
			int min = Integer.MAX_VALUE;
			for(int i=1; i<Integer.parseInt(input); i++) {
				int sum = i; // 분해합을 만들기 위해서 i값으로 초기화
				String[] toStringArr = Integer.toString(i).split(""); // i값을 문자열로 만들어서 각각의 자리수로 이뤄진 문자열 배열 생성
				for(int j=0; j<toStringArr.length; j++) {
					sum += Integer.parseInt(toStringArr[j]); // i값 각각의 자리수를 sum에 추가로 더해줌
				}
				if(sum==Integer.parseInt(input) && i<min) // 결과적으로 만들어진 i의 분해합이 input과 같고 최소인 경우에
					min = i; // min을 i값으로 갱신
				sum = 0; // sum을 재사용하기 위해서 0으로 변경
			}
			
			if(min == Integer.MAX_VALUE) min = 0; // 생성자가 없는 경우에는 min의 값이 바뀌지 않으므로 0을 출력
			
			bw.write(min+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}