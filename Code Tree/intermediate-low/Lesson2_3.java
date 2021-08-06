package com.algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Lesson2_3 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<n; i++)
				list.add(Integer.parseInt(br.readLine()));
			
			int[][] se = new int[2][2];
			for(int i=0; i<2; i++) {
				String[] tmp = br.readLine().split(" ");
				se[i][0] = Integer.parseInt(tmp[0])-1;
				se[i][1] = Integer.parseInt(tmp[1])-1;
			}
			
			for(int i=0; i<2; i++) {
				for(int j=0; j<=se[i][1]-se[i][0]; j++) { // 해당 인덱스의 원소를 삭제하면 뒤의 원소가 그 자리를 채우게 되므로 
					list.remove(se[i][0]); // 끝 인덱스에서 시작 인덱스의 차+1만큼 해당 인덱스의 원소를 삭제하면 된다
				}
			}
			
			bw.write(list.size()+"\n");
			for(int i=0; i<list.size(); i++)
				bw.write(list.get(i)+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
