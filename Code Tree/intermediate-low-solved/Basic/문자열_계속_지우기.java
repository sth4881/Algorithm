package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 문자열_계속_지우기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split("");
			ArrayList<String> inputList = new ArrayList<String>();
			for(int i=0; i<input.length; i++) {
				inputList.add(input[i]);
			}
			
			String target = br.readLine();
			String[] targetArr = target.split("");
			
			boolean isSame;
			do {
				isSame = false;
				for(int i=0; i<inputList.size(); i++) {
					if(targetArr[0].equals(inputList.get(i))) { // targetArr의 첫번째 문자열이 inputList의 i번째 문자열과 같다면
						String abc = ""; // target과 문자열을 비교하기 위한 문자열 abc
						int idx = i; // target이 inputList에 포함되어 있는 경우, idx번째 문자열부터 target의 크기만큼 삭제하기 위해서 기억 필요
						
						int tmpIdx = idx;
						for(int j=0; j<targetArr.length; j++) { // target에 포함된 문자열에 대해서
							if(tmpIdx<inputList.size() && targetArr[j].equals(inputList.get(tmpIdx))) { // target의 문자열이 tmpIdx에 포함되면
								abc+=targetArr[j]; // 비교 문자열 abc를 갱신
								tmpIdx++;
							} else break;
						}
						
						//  target이 inputList에 포함되는 경우 inputList에서 target 부분을 삭제
						if(abc.equals(target)) {
							isSame = true; // target이 inputList에 포함되어 있으므로 true로 변경
							for(int j=0; j<targetArr.length; j++) {// targetArr에 포함된 문자열에 대해서
								inputList.remove(idx); // inputList의 idx번째 문자열부터 targetArr의 마지막 문자열까지 삭제
							}
						}
					}
				}
			} while(isSame); // target이 inputList에 포함되어 있지 않을 때까지 반복
			
			for(int i=0; i<inputList.size(); i++)
				bw.write(inputList.get(i)+"");
			bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
