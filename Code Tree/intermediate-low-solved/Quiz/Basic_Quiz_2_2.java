package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Class {
	int value = 0;
	int cnt = 0;
	Class(int value, int cnt) {
		this.value = value;
		this.cnt = cnt;
	}
	public int getValue() {
		return this.value;
	}
	public int getCnt() {
		return this.value;
	}
}

public class Basic_Quiz_2_2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			if(n>1) {
				int[] arr = new int[n];
				for(int i=0; i<n; i++) {
					arr[i] = Integer.parseInt(input[i]);
				}
				Arrays.sort(arr); // ArrayList를 정렬
				

				ArrayList<Class> list = new ArrayList<Class>(); // arr[i]와 cnt 값을 담기 위한 Class의 ArrayList 선언
				int cnt = 1;
				for(int i=0; i<n-1; i++) {
					if(arr[i]==arr[i+1]) cnt++; // i번째 숫자와 i+1번째 숫자의 값이 같은 경우 cnt 1 증가
					else { // i번째 숫자와 i+1번째 숫자의 값이 다른 경우
						list.add(new Class(arr[i], cnt)); // arr[i]와 cnt 값을 Class 객체로 만들어서 list에 추가 
						cnt = 1; // cnt를 재사용하기 위해서 1로 초기화
					}
				}
				
				// 마지막 숫자가 중복되지 않고 고유한 경우에 대한 처리
				if(arr[n-1]!=arr[n-2]) { 
					list.add(new Class(arr[n-1], 1)); // 마지막 숫자(arr[n-1])와 1(cnt)을 Class 객체로 만들어서 list에 추가
				}
				
				int max = Integer.MIN_VALUE;
				for(int i=0; i<list.size(); i++) {
					if(list.get(i).cnt==1 && list.get(i).value>max) { // 중복되지 않고 고유한 숫자들에 대해서
						max = list.get(i).value; // 최대값을 찾기
					}
				}
				if(max==Integer.MIN_VALUE) bw.write(-1+"\n"); // max의 값이 바뀌지 않았다면(모든 숫자들이 중복해서 존재하는 경우)
				else bw.write(max+"\n"); // max의 값이 바뀌었다면(중복되지 않고 고유한 숫자가 하나라도 존재하는 경우)
			} else bw.write(input[0]+"\n"); // n이 1인 경우에 대한 처리
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
