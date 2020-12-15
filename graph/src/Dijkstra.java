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
		cnt.add(src); // ���� ������ �ִܰŸ��� ��������Ƿ� cnt.add(src) 
		found[src] = true; // ���� ������ �׻� �ִܰŸ��� ��������� found[src] = true;
		distance[src] = 0; // ���� �������κ��� ���� ���������� �Ÿ��� 0
		parent[src] = -1; // ���� ������ �θ� ������ �������� �����Ƿ� -1

		int vtx = src;
		while(cnt.size()<arr.size()) { // �ִܰŸ��� ������ ������ �� ������ �������� ���� ������
			for(int i=0; i<arr.get(vtx).size(); i++) { // ���� ���� vtx�� ������ ���� �߿���
				Vtx adj = arr.get(vtx).get(i);
				if(!found[adj.vertex]) { // ������ ������ �湮���� �ʾҴٸ�
					if(distance[adj.vertex] > distance[vtx] + adj.weight) { // ���� �������κ��� ������ ���� adj������ �Ÿ� distance[adj.vertex]��
																						// ���� �������κ��� ���� ���� vtx������ �Ÿ� distance[vtx]
																						// 										+
																						// ���� ���� vtx���� ������ ���� adj ������ �Ÿ� adj.weight ���� �۴ٸ�
						distance[adj.vertex] = distance[vtx] + adj.weight;
					}
				}
			}
			
			// �湮���� ���� ���� �߿��� �������� �湮�� ��������
			// ���� �������κ����� �ش� ���������� �Ÿ��� �ּ��� ������ ����
			int min = Integer.MAX_VALUE;
			int next = Integer.MIN_VALUE; // �ǹ̾��� �ʱ�ȭ
			for(int i=0; i<arr.size(); i++) { 
				if(!found[i]) { // ���� �������κ��� �ִܰŸ��� �������� ���� ���� �߿���
					if(distance[i] < min) { // ���� �������κ����� �Ÿ��� �ּ��� ������ ���ϱ�
						min = distance[i];
						next = i;
					}
				}
			}
			
			// �湮���� ���� ���� �߿��� �ִܰŸ��� �� �� �ִ� 
			// ������ �������� �湮�� �������� ó��
			found[next] = true; // ���� �������κ����� �ִܰŸ��� ���������� ǥ��
			cnt.add(next); // ���� �������κ����� �ִܰŸ��� ������ ������ ���� 1 ����
			vtx = next; // next�� ���� vtx�� �־������ν� ���� �湮�� ������ ����
		}
	}
	public static void main(String[] args) {
		try {
			// �׽�Ʈ ���̽��� ���Ϸκ��� �о�ͼ� �׽�Ʈ �غ��� ���ؼ� ����
			String fileName = "E:\\�б�\\4-1\\�˰���\\����\\test.txt";
			File file = new File(fileName);
			FileReader reader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(reader);
			System.out.println(fileName);
			
			String[] nm = bufReader.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			ArrayList<ArrayList<Vtx>> arr = new ArrayList<ArrayList<Vtx>>();
			for(int i=0; i<n; i++) {
				arr.add(new ArrayList<Vtx>()); // ������ ArrayList�� �޸� �Ҵ��ؼ� ����
			}
			
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" ");
				int tmp1=Integer.parseInt(input[0]);
				int tmp2=Integer.parseInt(input[1]);
				int tmp3=Integer.parseInt(input[2]);
				Vtx adj1 = new Vtx(); // ���� ������ ����ġ�� ��� �ֱ� ���ؼ� Ŭ���� Vertex ����
				adj1.vertex=tmp2; // ���� tmp1�� ������ ���� tmp2�� adj.vertex�� ����
				adj1.weight=tmp3; // ���� tmp1�� tmp2�� �մ� ����ġ tmp3�� adj.weight�� ����
				arr.get(tmp1).add(adj1); // ���� ���� ���� tmp1�� ArrayList�� ����
				Vtx adj2 = new Vtx(); // ���� ������ ����ġ�� ��� �ֱ� ���ؼ� Ŭ���� Vertex ����
				adj2.vertex=tmp1; // ���� tmp2�� ������ ���� tmp1�� adj.vertex�� ����
				adj2.weight=tmp3; // ���� tmp2�� tmp1�� �մ� ����ġ tmp3�� adj.weight�� ����
				arr.get(tmp2).add(adj2); // ���� ���� ���� tmp2�� ArrayList�� ����
			}
			
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<arr.get(i).size(); j++) {
//					System.out.println(i+"��° �ε����� ������: "+arr.get(i).size());
//					System.out.println(i+" "+arr.get(i).get(j).vertex+" "+arr.get(i).get(j).weight);
//				}
//			}
			
			String[] srcdst = bufReader.readLine().split(" ");
			int src = Integer.parseInt(srcdst[0]);
			int dst = Integer.parseInt(srcdst[1]);
			
			int[] dist = new int[n];
			for(int i=0; i<n; i++)
				dist[i] = 1000000; // ���� �������κ��� �ٸ� ��� ������ �Ÿ��� ���Ѵ뿡 ������ �ʱ�ȭ 
			int[] parent = new int[n]; // ��θ� ����ϱ� ���ؼ� ������ ������ �θ� ������ ����
			boolean[] found = new boolean[n]; // ���� �������κ��� �ش� ���������� �ִܰ�θ� ã������ ǥ��

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