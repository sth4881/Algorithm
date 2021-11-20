package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 부분문자열_위치_구하기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split("");
			String[] target = br.readLine().split("");
			
			ArrayList<String> list = new ArrayList<String>();
			int idx = -1;
			for(int i=0; i<input.length; i++) {
				if(target[0].equals(input[i])) { // target의 첫번째 문자열이 input의 i번째 문자열과 일치하는 경우
					idx = i; // 해당 인덱스를 기억
					int tmp = idx; // 아래 알고리즘에서 사용하기 위한 tmp 변수를 생성
					for(int j=0; j<target.length; j++) { // target의 모든 문자열에 대해서
						if(tmp<input.length && target[j].equals(input[tmp])) { // target의 j번째 문자열이 input의 tmp번째 문자열과 같다면
							list.add(input[tmp]); // 해당 문자열을 list에 추가
							tmp++; // tmp를 1 증가시켜서 target의 j번째 문자열을 가리키듯이 input의 tmp번째 문자열을 가리키도록 함
						} else break; // 문자열이 하나라도 다르면 break
					}
					if(target.length==list.size()) break; // target의 길이와 list의 길이가 같으면 문자열이 일치한다고 판단하고 break
					else {
						list = new ArrayList<String>(); // 문자열의 길이가 다르면 새로운 ArrayList 객체를 대입
						idx = -1; // idx를 재사용하기위해서 -1로 초기화
					}
				}
			}
			
			if(target.length==list.size()) bw.write(idx+"\n"); // target의 길이와 list의 길이가 같으면 부분 문자열이 포함되어 있음을 뜻함
			else bw.write(-1+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
