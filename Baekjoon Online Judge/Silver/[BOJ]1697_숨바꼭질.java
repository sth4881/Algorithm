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
	public static int[] dx = { -1, 1, 2 }; // 왼쪽 또는 오른쪽으로 한 칸 이동하거나 x2만큼 순간이동 가능
	public static void bfs(int start, int end, int[] check) {
		Queue<Integer> q = new LinkedList<Integer>(); // BFS를 사용하기 위해서 큐를 생성
		check[start] = 0; // 시작점에서는 움직이지 않으므로 소요되는 시간도 0초
		
		q.offer(start); // 시작점을 큐에 넣어주는것으로 BFS 알고리즘 시작
		while(!q.isEmpty()) {
			int nx; // 다음에 방문할 정점을 받기 위한 변수 선언
			int vtx = q.poll(); // 다음 방문할 정점을 탐색하기 위해서 큐에 들어있는 값들을 하나씩 꺼내옴 
			for(int i=0; i<3; i++) {
				if(dx[i]==-1 || dx[i]==1) { // 왼쪽 또는 오른쪽으로 한 칸씩 이동하는 경우에 대해서는 덧셈 수행
					nx = vtx+dx[i];
				} else { // x2만큼 순간이동하는 경우에 대해서는 곱셈 수행
					nx = vtx*dx[i];
				}
				if(nx>=0 && nx<check.length && check[nx]==0) { // 다음으로 방문할 정점 nx가 배열의 범위를 벗어나지 않았고, 방문되지 않았을 경우
					check[nx] = check[vtx]+1; // 최소시간을 구하기 위해서 다음 정점에 현재 정점+1
					q.offer(nx); // nx를 큐에 추가
				}
				if(nx==end) { // 시작점에서 출발점에 도착한 경우 위의 과정을 중단하고 걸린 최소시간을 반환
					System.out.println(check[nx]); 
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

			int[] check = new int[100001]; // 목표에서 요구하는 최소시간을 구하기 위한 배열
			
			if(start==end) bw.write(0+"\n"); // start와 end가 같은 경우에 대해서는 0을 출력
			else bfs(start, end, check); // 그 외의 경우에 대해서는 BFS 알고리즘 수행

			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}