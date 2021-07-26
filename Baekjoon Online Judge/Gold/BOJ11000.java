package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11000 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				arr[i][0] = Integer.parseInt(tmp[0]);
				arr[i][1] = Integer.parseInt(tmp[1]);
			}
			
			// 강의 종료시간(arr[i][1])을 기준으로 정렬하기 위해서 Comparator를 이용하여 compare 메소드를 재정의
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if(o1[0]==o2[0]) return o1[1] - o2[1]; // 시작시간이 같을 경우 종료시간이 빠른 순서대로 강의를 정렬
					else return o1[0] - o2[0]; // 그 외의 경우에 대해서는 시작시간이 빠른 순서대로 강의를 정렬
				}
			});
			
			// 강의의 시작시간과 비교하기 위해서 우선순위를 이용  
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			pq.offer(arr[0][1]); // 맨 처음 강의의 종료시간을 우선수위 큐에 추가
			for(int i=1; i<n; i++) {
				if(arr[i][0] >= pq.peek()) { // i번째 강의 시작시간이 우선순위 큐의 첫 원소(강의 종료시간)보다 클 경우
					pq.poll(); // 해당 강의실에서 강의가 이어지므로 현재 강의의 종료시간을 우선순위 큐에서 제거
					pq.offer(arr[i][1]); // 바로 다음에 이어지는 i번째 강의의 종료시간을 우선순위 큐에 추가하여 강의 종료시간을 갱신
				}
				else pq.offer(arr[i][1]); // 그렇지 않은 경우 새로운 강의실이 필요하므로 우선순위 큐에 강의 종료시간을 추가하여 강의실을 추가
			}
			
			bw.write(pq.size()+"\n"); // 우선순위 큐의 길이가 필요한 강의실의 최소 개수임을 알 수 있음
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}