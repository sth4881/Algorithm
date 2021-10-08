package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1157 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().toUpperCase().split("");
			
			// 문자열 abc를 이용해서 input에서 사용되는 각각의 알파벳 개수를 구함
			String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int[] cnt = new int[26];
			for(String item : input) {
				int tmp = abc.indexOf(item);
				cnt[tmp]++;
			}
			
			// 각각의 알파벳 개수 중에서 가장 많이 사용되는 알파벳의 개수 max를 구함
			int idx = 0;
			int max = cnt[0];
			for(int i=1; i<cnt.length; i++) {
				if(cnt[i] > max) {
					max = cnt[i];
					idx = i;
				}
			}
			
			// max값이 같은 경우가 여러개인 경우에는 tmpCnt를 이용해서 횟수를 카운트함
			int tmpCnt = 0;
			for(int item : cnt) {
				if(max == item) tmpCnt++;
			}
			
			String[] tmpArr = abc.split(""); // 가장 많이 사용되는 알파벳을 출력하기 위해서 split으로 알파벳을 쪼갬
			if(tmpCnt > 1) bw.write("?"+"\n"); // tmpCnt > 1이면 ? 출력
			else bw.write(tmpArr[idx]+"\n"); // 그렇지 않은 경우에는 가장 많이 사용되는 알파벳 출력
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
