package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Test1 {
	// 500 근처의 수
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}
			
			ArrayList<Integer> low= new ArrayList<Integer>();
			ArrayList<Integer> high = new ArrayList<Integer>();
			for(int i=0; i<arr.length; i++) {
				if(arr[i]<500) low.add(arr[i]);
				else high.add(arr[i]);
			}
			
			Collections.sort(low);
			Collections.sort(high);
			
			bw.write(low.get(low.size()-1)+" "+high.get(0));			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}