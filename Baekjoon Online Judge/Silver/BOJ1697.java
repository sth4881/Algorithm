package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1697 {
	public static int[] dx = { -1, 1, 2 };
	public static void bfs(int start, int end, int[] check) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[start] = 0;
		
		q.offer(start);
		while(!q.isEmpty()) {
			int nx;
			int vtx = q.poll();
			for(int i=0; i<3; i++) {
				if(dx[i]==-1 || dx[i]==1) {
					nx = vtx+dx[i];
				} else {
					nx = vtx*dx[i];
				}

				if(nx>=0 && nx<check.length && check[nx]==0) {
					check[nx] = check[vtx]+1;
					q.offer(nx);
				}
				if(nx==end) {
					System.out.println(check[nx]); // 시작점에서 출발점에 도착한 경우 걸린 최소시간 반환
					return;
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			
			int size = Math.max(start, end);
			int[] check = new int[100001];
			
			if(start==end) bw.write(0+"\n");
			else bfs(start, end, check);

			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}