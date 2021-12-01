package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Basic_Test {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			int cnt = 0; // 완전수의 개수를 세기 위한 변수
			for(int i=start; i<=end; i++) {
				int sum = 0; // 약수의 합이 i를 제외한 모든 약수를 더했을 때 i가 되는지 확인하기 위한 변수
				for(int j=1; j<i; j++) {
					if(i%j==0) sum += j; // j가 i의 약수라면 sum에 더해줌
				}
				if(sum==i) cnt++; // j가 완전수라면 cnt를 1 증가
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
