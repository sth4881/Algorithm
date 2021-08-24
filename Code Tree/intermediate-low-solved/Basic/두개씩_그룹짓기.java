package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 두개씩_그룹짓기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			int[] arr = new int[input.length];
			for(int i=0; i<input.length; i++)
				arr[i] = Integer.parseInt(input[i]);
			Arrays.sort(arr); // 배열 원소들을 오름차순으로 정렬 
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<input.length/2; i++) {
				int sum = arr[i]+arr[arr.length-1-i]; // 값이 작은 원소를 값이 큰 원소를 차례대로 합해줌
				list.add(sum);
			}
			
			Collections.sort(list, Collections.reverseOrder()); // 최대값을 찾기 위해서 내림차순으로 정렬
			bw.write(list.get(0)+"\n");			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
