package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BackTracking_Lesson3 {
	public static void func(ArrayList<Integer> list, int n, int m, int cnt, int cur) {
		if(cur==n+1 && cnt==m) {
			for(int item : list)
				System.out.print(item+" ");
			System.out.println();
			return;
		}
		
		// cnt는 뽑는 숫자의 개수를 나타내고, cur은 1부터 N까지의 숫자 중에서 하나를 나타낸다. 
		// cur를 뽑는 숫자에 포함시키는 경우를 나타낸 코드
		list.add(cur);
		func(list, n, m, cnt+1, cur+1);
		list.remove(list.size()-1);
		
		// cur를 뽑는 숫자에 포함시키지 않는 경우를 나타낸 코드
		func(list, n, m, cnt, cur+1);
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			func(list, n, m, 0, 1);
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
