package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Quiz1_2 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=start; i<=end; i++) {
				int cnt = 0;
				for(int j=1; j<=i; j++)
					if(i%j==0) cnt++;
				if(cnt==3) list.add(i); // 숫자 i의 약수가 3이면 list에 추가
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
