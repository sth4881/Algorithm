package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ1753 {
	public static class Node {
		int num;
		int weight;
		public Node(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}
	}
	public static int[] dist; // 시작점으로부터 각 정점의 최단거리 계산
	public static boolean[] found; // 최단거리를 찾은 정점을 구별하기 위한 배열
	public static ArrayList<ArrayList<Node>> list;
	public static void dijkstra(int src, int n) {
		int cnt = 1;
		int cur = src;
		dist[cur] = 0; // 시작점으로부터 시작점까지의 거리는 0
		found[cur] = true; // 시작점의 최단거리는 항상 0으로 도출되므로 true
		
		// 모든 정점의 최단거리를 구할 때까지 반복
		while(cnt!=n) {
			// 정점 node에 인접한 각각의 정점들에 대해서
			for(int i=0; i<list.get(cur).size(); i++) { 
				Node adj = list.get(cur).get(i);
				// 정점 node에 인접한 정점의 최단거리가 구해지지 않았다면
				if(!found[adj.num]) {
					// ① 시작점으로부터 정점 adj까지의 거리와
					// ② 시작점으로부터 정점 node까지의 거리 + 정점 node로부터 정점 adj까지의 거리를 비교
					if(dist[adj.num] > dist[cur] + adj.weight) {
						dist[adj.num] = dist[cur] + adj.weight; // ②의 값이 더 작다면 최단거리를 갱신
					}
				}
			}
			
			// 아직 방문되지 않는 정점 중에서 다음으로 방문할 정점으로
			// 시작점으로부터 정점까지의 거리가 최소인 정점을 선택하는 알고리즘
			int min = Integer.MAX_VALUE;
			int nextVisit = 0;
			for(int i=1; i<list.size(); i++) {
				// 시작점으로부터의 최단거리가 구해지지 않은 정점 중에서
				if(!found[i]) {
					// 시작점으로부터 거리가 최소인 정점 구하기
					// 거리가 최소인 정점이 여러 개인 경우에는 번호가 빠른 정점으로 결정
					if(dist[i] < min) {
						min = dist[i];
						nextVisit = i;
					}
				}
			}
			
			// 아직 방문되지 않은 정점 중에서 시작점으로부터
			// 최단거리로 갈 수 있는 정점을 도출 및 다음 방문할 정점으로 처리하는 알고리즘
			found[nextVisit] = true;
			cur = nextVisit;
			cnt++;
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 입력
			String[] nm = br.readLine().split(" "); // 정점, 간점 개수
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int src = Integer.parseInt(br.readLine()); // 시작점 입력
			
			// 선언
			list = new ArrayList<ArrayList<Node>>();
			for(int i=0; i<=n; i++)
				list.add(new ArrayList<Node>());
			
			// 초기화
			for(int i=0; i<m; i++) {
				String[] input = br.readLine().split(" ");
				int u = Integer.parseInt(input[0]);
				int v = Integer.parseInt(input[1]);
				int w = Integer.parseInt(input[2]);
				list.get(u).add(new Node(v, w));
			}
			
			// 시작 정점과 다른 정점 간의 거리를 저장하기 위한 배열
			dist = new int[n+1];
			for(int i=0; i<=n; i++)
				dist[i] = Integer.MAX_VALUE; // 시작 정점으로부터 다른 모든 정점의 거리를 무한대에 가깝게 초기화
			found = new boolean[n+1]; // 시작 정점으로부터 해당 정점까지의 최단경로를 찾았음을 표시하기 위한 배열 생성
			
			dijkstra(src, n);
			
			// 출력
			for(int i=1; i<dist.length; i++) {
				if(dist[i]==Integer.MAX_VALUE) bw.write("INF\n");
				else bw.write(dist[i]+"\n");
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}