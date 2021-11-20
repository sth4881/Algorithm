package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Lesson3_2 {
	public static void func(ArrayList<Integer> list, int n, int k, int cnt) {
		if(cnt==n) { // 종료 조건시 값 출력
			for(int item : list)
				System.out.print(item+" ");
			System.out.println();
			return;
		}
		for(int i=1; i<=k; i++) {
			// 리스트의 마지막에서 두번째 값과 마지막 값이 같고 현재 리스트에서 넣어주려는 값이 같은 경우를 제외
			if(list.size()>=2 && list.get(list.size()-2)==list.get(list.size()-1) && list.get(list.size()-1)==i)
				continue;
			else {
				list.add(i);
				func(list, n, k, cnt+1);
				list.remove(list.size()-1); // 마지막 원소를 빼줘야 백트래킹 알고리즘을 수행할 수 있으므로
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int k = Integer.parseInt(tmp[0]);
			int n = Integer.parseInt(tmp[1]);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			func(list, n, k, 0);
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
