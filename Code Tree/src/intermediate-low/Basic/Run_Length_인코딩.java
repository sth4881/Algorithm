package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Run_Length_인코딩 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split("");
			
			ArrayList<String> list = new ArrayList<String>();
			int cnt = 1;
			for(int i=0; i<input.length-1; i++) {
				if(input[i].equals(input[i+1])) cnt++; // i번째 문자열과 i+1번째 문자열이 일치하면 cnt 1 증가
				else { // 일치하지 않으면 i번째 문자열과 cnt를 list에 차례대로 추가
					list.add(input[i]);
					list.add(Integer.toString(cnt));
					cnt=1; // cnt를 재사용하기 위해서 초기화
				}
			}
			list.add(input[input.length-1]); // 마지막 문자열은 i-1번째 문자열과 일치하든 안하든 list에 추가
			list.add(Integer.toString(cnt)); // 위의 for문을 빠져나와도 cnt 값은 변하지 않으므로 list에 그대로 추가
			
			String answer = "";
			for(String item : list)
				answer += item;
			
			bw.write(answer.length()+"\n");
			for(String item : list)
				bw.write(item+"");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
