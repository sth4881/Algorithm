package com.algorithm.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {

	public static void func(ArrayList<ArrayList<Vtx>> arr, int src, int dst, int[] distance, int[] parent, boolean[] found) {
		ArrayList<Integer> cnt = new ArrayList<Integer>();
		cnt.add(src); // 시작 정점은 최단거리가 도출됐으므로 cnt.add(src) 
		found[src] = true; // 시작 정점은 항상 최단거리가 도출됨으로 found[src] = true;
		distance[src] = 0; // 시작 정점으로부터 시작 정점까지의 거리는 0
		parent[src] = -1; // 시작 정점은 부모 정점이 존재하지 않으므로 -1

		int vtx = src;
		while(cnt.size()<arr.size()) { // 최단거리가 구해진 정점이 총 정점의 개수보다 적을 때까지
			for(int i=0; i<arr.get(vtx).size(); i++) { // 현재 정점 vtx에 인접한 정점 중에서
				Vtx adj = arr.get(vtx).get(i);
				if(!found[adj.vertex]) { // 인접한 정점을 방문하지 않았다면
					if(distance[adj.vertex] > distance[vtx] + adj.weight) { // 시작 정점으로부터 인접한 정점 adj까지의 거리 distance[adj.vertex]가
																						// 시작 정점으로부터 현재 정점 vtx까지의 거리 distance[vtx]
																						// 										+
																						// 현재 정점 vtx부터 인접한 정점 adj 까지의 거리 adj.weight 보다 작다면
						distance[adj.vertex] = distance[vtx] + adj.weight;
					}
				}
			}
			
			// 방문하지 않은 정점 중에서 다음으로 방문할 정점으로
			// 시작 정점으로부터의 해당 정점까지의 거리가 최소인 정점을 선택
			int min = Integer.MAX_VALUE;
			int next = Integer.MIN_VALUE; // 의미없는 초기화
			for(int i=0; i<arr.size(); i++) { 
				if(!found[i]) { // 시작 정점으로부터 최단거리가 구해지지 않은 정점 중에서
					if(distance[i] < min) { // 시작 정점으로부터의 거리가 최소인 정점을 구하기
						min = distance[i];
						next = i;
					}
				}
			}
			
			// 방문하지 않은 정점 중에서 최단거리로 갈 수 있는 
			// 정점을 다음으로 방문할 정점으로 처리
			found[next] = true; // 시작 정점으로부터의 최단거리가 구해졌음을 표시
			cnt.add(next); // 시작 정점으로부터의 최단거리가 구해진 정점의 개수 1 증가
			vtx = next; // next의 값을 vtx에 넣어줌으로써 다음 방문할 정점을 갱신
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
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			ArrayList<ArrayList<Vtx>> arr = new ArrayList<ArrayList<Vtx>>();
			for(int i=0; i<n; i++) {
				arr.add(new ArrayList<Vtx>()); // 각각의 ArrayList에 메모리 할당해서 생성
			}
			
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" ");
				int tmp1=Integer.parseInt(input[0]);
				int tmp2=Integer.parseInt(input[1]);
				int tmp3=Integer.parseInt(input[2]);
				Vtx adj1 = new Vtx(); // 인접 정점과 가중치를 묶어서 넣기 위해서 클래스 Vertex 생성
				adj1.vertex=tmp2; // 정점 tmp1에 인접한 정점 tmp2을 adj.vertex로 설정
				adj1.weight=tmp3; // 정점 tmp1와 tmp2를 잇는 가중치 tmp3를 adj.weight로 설정
				arr.get(tmp1).add(adj1); // 위의 값을 정점 tmp1에 ArrayList로 연결
				Vtx adj2 = new Vtx(); // 인접 정점과 가중치를 묶어서 넣기 위해서 클래스 Vertex 생성
				adj2.vertex=tmp1; // 정점 tmp2에 인접한 정점 tmp1을 adj.vertex로 설정
				adj2.weight=tmp3; // 정점 tmp2와 tmp1를 잇는 가중치 tmp3를 adj.weight로 설정
				arr.get(tmp2).add(adj2); // 위의 값을 정점 tmp2에 ArrayList로 연결
			}
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<arr.get(i).size(); j++) {
//					System.out.println(i+"번째 인덱스의 사이즈: "+arr.get(i).size());
//					System.out.println(i+" "+arr.get(i).get(j).vertex+" "+arr.get(i).get(j).weight);
//				}
//			}
			
			String[] srcdst = bufReader.readLine().split(" ");
			int src = Integer.parseInt(srcdst[0]);
			int dst = Integer.parseInt(srcdst[1]);
			
			int[] dist = new int[n];
			for(int i=0; i<n; i++)
				dist[i] = 1000000; // 시작 정점으로부터 다른 모든 정점의 거리를 무한대에 가깝게 초기화 
			int[] parent = new int[n]; // 경로를 출력하기 위해서 각각의 정점의 부모 정점을 저장
			boolean[] found = new boolean[n]; // 시작 정점으로부터 해당 정점까지의 최단경로를 찾았음을 표시

			func(arr, src, dst, dist, parent, found);
			
			for(int i=0; i<dist.length; i++)
				System.out.print(dist[i]+" ");
			System.out.println();

			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}

class Vtx {
	int vertex;
	int weight;
}