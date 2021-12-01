package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 가장_왼쪽에_있는_최댓값 {
	public static void func(ArrayList<Integer> list, ArrayList<Integer> ans) {
		int idx = 0;
		int max = Integer.MIN_VALUE;
		for(int i=list.size()-1; i>=0; i--) { // 최댓값 중에서 가장 왼쪽의 인덱스를 출력하기 때문에 끝에서부터 탐색
			if(list.get(i)>=max) { // 최댓값을 발견하면
				max = list.get(i);
				idx = i; // 인덱스를 기억
			}
		}
		ans.add(idx+1); // 기억한 인덱스를 정답 출력용 ArrayList에 추가
		while(idx<list.size()) { // list의 끝에서 해당 인덱스까지
			list.remove(idx); // list의 원소들을 제거
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<n; i++) {
				list.add(Integer.parseInt(input[i]));
			}
			
			ArrayList<Integer> ans = new ArrayList<Integer>();
			while(list.size()>0) { // list에 원소가 하나 이상 남아있을 때까지 수행
				func(list, ans);
			}
			
			for(int item : ans)
				bw.write(item+" ");
			bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
