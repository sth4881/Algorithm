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

public class Assignment3_3 {
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> bfs, int src, int dst, boolean[] visited, int[] parent) {
		if(src==dst) { // 시작 정점과 도착 정점이 일치하면 거치는 정점은 src=dst 하나이므로 dst 반환
			bfs.add(dst);
			return;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		visited[src] = true; // 시작 정점에 대해서 방문했음을 표시
		parent[src] = -1; // 시작 정점은 부모 정점이 존재하지 않으므로 -1로 설정
		
		q.offer(src); // 시작 정점을 큐에 추가
		while(!q.isEmpty()) { // 큐가 빌 때까지(=시작 정점의 연결요소에 연결된 정점을 모두 방문할 때까지)
			int tmp = q.poll(); // 현재 정점을 큐에서 반환 및 임시 변수 tmp에 대입하고 해당 정점을 큐에서 제거 
			for(int i=0; i<arr.get(tmp).size(); i++) { // 현재 정점에 인접한 정점의 개수만큼 반복
				if(!visited[arr.get(tmp).get(i)]) { // 현재 정점에 인접한 정점을 방문하지 않았다면
					visited[arr.get(tmp).get(i)]=true; // 해당 정점을 방문했음을 표시
					q.offer(arr.get(tmp).get(i)); // 해당 정점을 큐에 추가
					parent[arr.get(tmp).get(i)]=tmp; // 해당 정점의 부모 정점을 tmp로 설정
				}
			}
		}
		
		int tmp = dst;
		if(!visited[tmp]) { // 도착 정점의 visited값이 false라면 시작 정점과 도착 정점의 연결요소가 다르다는 뜻이므로 -1 반환
			bfs.add(-1);
			return;
		}
		while(tmp!=src) { // 도착 정점이 시작 정점과 일치하기 전까지 반복
			s.push(tmp); // 스택에 tmp를 반복적으로 추가해주면서 경로의 길이를 구함
			tmp=parent[tmp]; // tmp를 tmp의 부모 정점으로 갱신해줌으로써 도착 정점에서 시작 정점까지 찾아갈 수 있도록 만들어줌
		}
		bfs.add(src); // 위의 반복문에서는 시작 정점을 스택에 추가하지 않으므로 시작 정점을 개별적으로 bfs에 추가
		while(!s.isEmpty()) { // 스택이 빌 때까지 반복
			bfs.add(s.pop()); // 스택은 LIFO 형식의 자료구조이므로 마지막으로 넣은 값이 처음으로 출력된다(시작 정점의 인접한 정점부터 도착 정점까지 차례대로 출력됨)
		}
		return; // 도착 정점에서 시작 정점까지 이동하는데 거쳐야하는 간선의 최소 개수를 반환(부모 정점을 타고 가다 보면 최소 개수 반환)
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
			
			ArrayList<Integer> bfs = new ArrayList<Integer>();
			
			String[] ab = bufReader.readLine().split(" ");
			int a = Integer.parseInt(ab[0]); // 시작 정점 입력
			int b = Integer.parseInt(ab[1]); // 도착 정점 입력
			
			boolean[] visited = new boolean[n]; // 정점의 개수만큼 방문 판별 배열 크기 설정
			
			int[] parent = new int[n]; // 정점의 개수만큼 부모 정점의 개수 설정
			
			func(arr, bfs, a, b, visited, parent);
			for(int i=0; i<bfs.size(); i++)
				System.out.print(bfs.get(i)+" ");
	
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
