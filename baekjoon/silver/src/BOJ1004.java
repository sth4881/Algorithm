package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* 백준 1004번 어린왕자 (Silver) */
public class BOJ1004 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int testcase = Integer.parseInt(br.readLine()); // 테스트케이스 개수
			int[] ans = new int[testcase];
			for(int t=0; t<testcase; t++) {
				String[] tmparr = br.readLine().split(" "); // 출발점(x, y)과 도착점(x, y)
				int srcx = Integer.parseInt(tmparr[0]); // 출발점 x
				int srcy = Integer.parseInt(tmparr[1]); // 출발점 y
				int dstx = Integer.parseInt(tmparr[2]); // 도착점 x
				int dsty = Integer.parseInt(tmparr[3]); // 도착점 y
				
				int n = Integer.parseInt(br.readLine()); // 행성계의 개수
				ArrayList<ArrayList<Integer>> planet = new ArrayList<ArrayList<Integer>>(n);
				for(int i=0; i<n; i++)
					planet.add(new ArrayList<Integer>(3));
				
				for(int i=0; i<n; i++) {
					String[] tmparr2 = br.readLine().split(" "); // 행성계의 중점과 반지름
					planet.get(i).add(Integer.parseInt(tmparr2[0])); // 행성계의 중점 x
					planet.get(i).add(Integer.parseInt(tmparr2[1])); // 행성계의 중점 y
					planet.get(i).add(Integer.parseInt(tmparr2[2])); // 행성계의 반지름 r
				}
				
				// 알고리즘
				for(int i=0; i<n; i++) {
					double px = planet.get(i).get(0); // i번째 행성의 x좌표
					double py = planet.get(i).get(1); // i번째 행성의 y좌표
					double pr= planet.get(i).get(2); // i번째 행성의 반지름
					
					int src_to_planet_xd = (int) Math.pow(srcx-px, 2);
					int src_to_planet_yd = (int) Math.pow(srcy-py, 2);
					double src_to_planet_d = Math.sqrt(src_to_planet_xd+src_to_planet_yd); // 출발점과 행성 간의 거리
					
					int dst_to_planet_xd = (int) Math.pow(dstx-px, 2);
					int dst_to_planet_yd = (int) Math.pow(dsty-py, 2);
					double dst_to_planet_d = Math.sqrt(dst_to_planet_xd+dst_to_planet_yd); // 도착점과 행성 간의 거리
					
					// 행성의 반지름이 출발점과 행성 간의 거리보다 크고, 도착점과 행성 간의 거리보다는 작을 경우
					if(pr>src_to_planet_d && pr<dst_to_planet_d)
						ans[t]++;
					// 행성의 반지름이 도착점과 행성 간의 거리보다 크고, 출발점과 행성 간의 거리보다는 작을 경우
					if(pr>dst_to_planet_d && pr<src_to_planet_d)
						ans[t]++;
				}
			}
			for(int t=0; t<testcase; t++)
				bw.write(ans[t]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
