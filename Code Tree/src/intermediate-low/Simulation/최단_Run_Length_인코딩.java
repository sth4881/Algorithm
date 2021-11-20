package com.algorithm.codetree.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class 최단_Run_Length_인코딩 {
	public static LinkedList<String> runLengthFunc(LinkedList<String> list) {
		LinkedList<String> answer = new LinkedList<String>();
		int cnt = 1;
		for(int i=0; i<list.size()-1; i++) {
			if(list.get(i).equals(list.get(i+1))) cnt++; // i번째 문자열과 i+1번째 문자열이 일치하면 cnt 1 증가
			else { // 일치하지 않으면 i번째 문자열과 cnt를 list에 차례대로 추가
				answer.addLast(list.get(i));
				answer.addLast(Integer.toString(cnt));
				cnt=1; // cnt를 재사용하기 위해서 초기화
			}
		}
		answer.addLast(list.getLast()); // 마지막 문자열은 i-1번째 문자열과 일치하든 안하든 list에 추가
		answer.addLast(Integer.toString(cnt)); // 위의 for문을 빠져나와도 cnt 값은 변하지 않으므로 list에 그대로 추가
		return answer;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			// 입력 초기화
			String[] input = br.readLine().split("");
			LinkedList<String> list = new LinkedList<String>();
			for(int i=0; i<input.length; i++)
				list.addLast(input[i]);
			
			// Shift 연산 알고리즘
			HashSet<String> set = new HashSet<String>();
			for(int i=0; i<list.size(); i++)
				set.add(list.get(i));
			if(set.size()>1) { // HashSet의 크기가 1이상인 경우 Shift 연산 필요
				while(list.getLast().equals(list.getFirst())) { // 마지막 값과 첫번째 값이 같을 때까지
					list.addFirst(list.getLast()); // list의 마지막 값을 list의 처음 인덱스에 추가
					list.removeLast(); // list의 마지막 값을 삭제
				}
			}
			
			// Run Length 인코딩(aaaaaaaaaa 같은 경우 때문에 아래와 같은 과정을 통해서 출력 필요)
			LinkedList<String> answer = runLengthFunc(list);
			String str = "";
			for(String item : answer)
				str += item;
			bw.write(str.length()+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}