package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ3052 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				int tmp = Integer.parseInt(br.readLine());
				arr[i] = tmp%42;
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int item : arr) {
				if(!list.contains(item))
					list.add(item);
			}
			
			bw.write(list.size()+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
