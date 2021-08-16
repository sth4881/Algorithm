package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 자동차_단일_거래_이익_최대화하기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			int max = Integer.MIN_VALUE;
			for(int i=0; i<n; i++) {
				int target = arr[i]; // 살 때의 가격을 target으로 지정
				for(int j=i+1; j<n; j++) // target 이후의 가격들에 대해서
					if(target<arr[j] && max<(arr[j]-target)) max = arr[j]-target; // target보다 가격이 크다면 해당 가격에서 target을 뺀 값의 최대값을 찾음
				if(max>Integer.MIN_VALUE) { // 이익이 나는 경우
					ans.add(max); // target을 통해서 만들 수 있는 최대 이익을 ArrayList에 추가
					max = Integer.MIN_VALUE; // max를 재사용하기 위해서 MIN_VALUE로 초기화
				}
			}
			
			if(ans.size()==0) bw.write(0+"\n"); // 이익이 나지 않는 경우는 0을 출력
			else {
				max = Integer.MIN_VALUE;
				for(int item : ans)
					if(item>max) max = item; // 최대 이익을 찾기
				bw.write(max+"\n");
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}