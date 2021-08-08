package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Quiz1_3 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input = br.readLine().split("");
			ArrayList<String> list = new ArrayList<String>();
			for(int i=input.length-1; i>=0; i--)
				list.add(input[i]);
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).equals("0")) {
					list.remove(i);
					i--;
				} else break;
			}
			
			for(String item : list)
				bw.write(item+"");
			bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
