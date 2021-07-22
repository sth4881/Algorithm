package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ1931 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Time> arr = new ArrayList<Time>();
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				int start = Integer.parseInt(tmp[0]);
				int end = Integer.parseInt(tmp[1]);
				Time time = new Time(start, end);
				arr.add(time);
			}
			
			// 회의가 끝나는 시간을 기준으로 삽입정렬
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					if((arr.get(i).end == arr.get(j).end && arr.get(i).start < arr.get(j).start) || arr.get(i).end > arr.get(j).end) { // i번쨰 회의가 끝나는 시간이 j번째 회의가 끝나는 시간보다 늦으면
						Time temp = new Time(arr.get(i).start, arr.get(i).end);
						arr.set(i, arr.get(j));
						arr.set(j, temp);
					}
				}
			}
			
			// 알고리즘
			int cnt = 1;
			int threshold = arr.get(0).end;
			for(int i=1; i<n; i++) {
				if(threshold <= arr.get(i).start) {
					threshold = arr.get(i).end;
					cnt++;
				}
			}
			
			bw.write(cnt+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}

class Time {
	int start = 0;
	int end = 0;
	Time(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
