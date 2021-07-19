package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment3_1 {
	public static int cnt = 0;
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfs, int vtx, boolean[] visited) {
		if(!visited[vtx]) { // 현재 정점이 방문되지 않았다면
			cnt++; // 연결요소의 개수를 갱신하기위해서 cnt 1증가
			visited[vtx]=true; // 해당 정점을 방문했음을 표시
			for(int i=0; i<arr.get(vtx).size(); i++) { // 해당 정점에 인접한 정점의 개수만큼 반복
				func(arr, dfs, arr.get(vtx).get(i), visited); // 해당 정점에 인접한 정점에 대해서 DFS 실행
			}
		}
	}
	public static void main(String[] args) {
		try {
			// 테스트 케이스를 파일로부터 읽어와서 테스트 해보기 위해서 구현
			String fileName = "E:\\학교\\4-1\\알고리즘\\과제\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] nm = bufReader.readLine().split(" ");
			int n = Integer.parseInt(nm[0]); // 정점들의 개수를 받아옴
			int m = Integer.parseInt(nm[1]); // 간선들의 개수를 받아옴
			
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++)
				arr.add(new ArrayList<Integer>()); // ArrayList<ArrayList<Integer>>를 n개만큼 생성
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" ");
				int vtx = Integer.parseInt(input[0]); // 정점에 대한 input
				int adj = Integer.parseInt(input[1]); // 정점에 인접한 정점에 대한 input
				arr.get(vtx).add(adj); // vtx와 adj가 인접해있음을 표시
				arr.get(adj).add(vtx); // adj와 vtx가 인접해있음을 표시
			}
			
			ArrayList<Integer> dfs = new ArrayList<Integer>(); // 연결요소의 개수와 연결요소의 크기를 저장학 위한 ArrayList 생성
			
			boolean[] visited = new boolean[n]; // 해당 정점이 방문됐는지를 판단하기 위한 visited 배열 생성
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) { 
					func(arr, dfs, i, visited); // 방문하지 않은 정점에 대해서만 DFS 실행(인접한 정점에 대해서는 실행되지 않음)
					dfs.add(cnt); // 위의 메소드를 통해서 방문한 정점은 정점 i에 인접한 정점이므로 연결요소로 생각하지 않음
					cnt = 0; // 위의 메소드를 통해서 연결요소를 구분하는 처리가 끝나면 연결요소의 개수를 세기 위한 변수 cnt 또한 0으로 초기화해줘야함
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<dfs.size(); i++) {
				if(dfs.get(i) > max) max = dfs.get(i); // 연결요소의 크기 중에서 가장 큰 값을 max에 저장
			}
			
			System.out.println(dfs.size());
			System.out.println(max);
	
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
