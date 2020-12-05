package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment1_2 {
	public static int func(int[] arr, int start, int dest, int n, boolean[] visited, int[] parent) {
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		visited[start]=true; // 현재 정점을 방문했음을 표시
		parent[start] = -1; // 시작 정점은 부모 정점이 존재하지 않으므로 -1로 초기화
		
		q.offer(start); // 시작 정점을 큐에 대입
		while(!q.isEmpty()) { // 큐가 빌 때까지(=방문할 정점이 없을 때까지)
			int tmp = q.poll(); // 임시 변수 tmp에 큐의 맨 처음 값을 반환하고 큐에서 제거
			if(tmp-arr[tmp]>=0) { // 해당 정점-정점의 가중치가 0이상인 경우
				if(!visited[tmp-arr[tmp]]) { // 해당 정점-정점을 방문하지 않았다면
					visited[tmp-arr[tmp]]=true; // 방문했음을 표시
					q.offer(tmp-arr[tmp]); // 큐에 해당 정점-정점을 추가
					parent[tmp-arr[tmp]]=tmp; // 해당 정점-정점의 부모 정점을 tmp로 규정
				}
			}
			if(tmp+arr[tmp]<n) { // 해당 정점+정점의 가중치가 n보다 작을 경우
				if(!visited[tmp+arr[tmp]]) { // 해당 정점+정점을 방문하지 않았다면
					visited[tmp+arr[tmp]]=true; // 방문했음을 표시
					q.offer(tmp+arr[tmp]); // 큐에 해당 정점+정점을 추가
					parent[tmp+arr[tmp]]=tmp; // 해당 정점+정점의 부모 정점을 tmp로 규정
				}
			}
		}
		int tmp = dest;
		if(!visited[tmp]) return -1; // 도착 정점으로 갈 수 없는 경우(해당 정점을 방문하지 않은 경우)
		while(tmp!=start) { // 목적지 정점이 출발 정점과 같아질 때까지
			s.push(tmp); // 갱신한 tmp를 스택에 추가
			tmp = parent[tmp]; // 임시 변수 tmp를 tmp의 부모 정점으로 갱신
		}
		return s.size(); // 목적지 정점과 시작 정점 전까지의 목적지 정점의 부모 정점 개수를 반환
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			int n = Integer.parseInt(bufReader.readLine()); // 테스트 케이스의 개수를 입력받기 위한 변수
			int start = Integer.parseInt(bufReader.readLine()); // 시작 셀 위치
			String[] input = bufReader.readLine().split(" "); // // 테스트 케이스를 입력받는 변수

			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			int[] cnt = new int[n]; // 각 셀마다 이동 횟수를 구하기 위한 배열 cnt 선언
			
			int[] parent = new int[n]; // 각 셀의 부모 셀을 구하기 위한 배열 parent 선언
			
			boolean[] visited = new boolean[n]; // 각 셀이 방문 여부를 판단하기 위안 배열 visited 선언
			
			for(int i=0; i<n; i++)
				cnt[i] = func(arr, start, i, n, visited, parent);
			for(int i=0; i<n; i++)
				System.out.print(cnt[i]+" ");
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
