package com.algorithm.codetree.simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class 삼각형_컨베이어_벨트 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int t = Integer.parseInt(input[1]);
			
			LinkedList<Integer> list = new LinkedList<Integer>();
			for(int i=0; i<3; i++) {
				input = br.readLine().split(" ");
				for(int j=0; j<n; j++) {
					list.add(Integer.parseInt(input[j]));
				}
			}
			
			// 마지막 값을 첫번째 인덱스에 넣고 마지막 값을 list에서 삭제
			for(int i=0; i<t; i++) {
				int num = list.get(list.size()-1);
				list.addFirst(num);
				list.removeLast();
			}
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<n; j++) {
					bw.write(list.get(0)+" ");
					list.removeFirst();
				}
				bw.write("\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
