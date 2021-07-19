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
		if(src==dst) { // ���� ������ ���� ������ ��ġ�ϸ� ��ġ�� ������ src=dst �ϳ��̹Ƿ� dst ��ȯ
			bfs.add(dst);
			return;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		visited[src] = true; // ���� ������ ���ؼ� �湮������ ǥ��
		parent[src] = -1; // ���� ������ �θ� ������ �������� �����Ƿ� -1�� ����
		
		q.offer(src); // ���� ������ ť�� �߰�
		while(!q.isEmpty()) { // ť�� �� ������(=���� ������ �����ҿ� ����� ������ ��� �湮�� ������)
			int tmp = q.poll(); // ���� ������ ť���� ��ȯ �� �ӽ� ���� tmp�� �����ϰ� �ش� ������ ť���� ���� 
			for(int i=0; i<arr.get(tmp).size(); i++) { // ���� ������ ������ ������ ������ŭ �ݺ�
				if(!visited[arr.get(tmp).get(i)]) { // ���� ������ ������ ������ �湮���� �ʾҴٸ�
					visited[arr.get(tmp).get(i)]=true; // �ش� ������ �湮������ ǥ��
					q.offer(arr.get(tmp).get(i)); // �ش� ������ ť�� �߰�
					parent[arr.get(tmp).get(i)]=tmp; // �ش� ������ �θ� ������ tmp�� ����
				}
			}
		}
		
		int tmp = dst;
		if(!visited[tmp]) { // ���� ������ visited���� false��� ���� ������ ���� ������ �����Ұ� �ٸ��ٴ� ���̹Ƿ� -1 ��ȯ
			bfs.add(-1);
			return;
		}
		while(tmp!=src) { // ���� ������ ���� ������ ��ġ�ϱ� ������ �ݺ�
			s.push(tmp); // ���ÿ� tmp�� �ݺ������� �߰����ָ鼭 ����� ���̸� ����
			tmp=parent[tmp]; // tmp�� tmp�� �θ� �������� �����������ν� ���� �������� ���� �������� ã�ư� �� �ֵ��� �������
		}
		bfs.add(src); // ���� �ݺ��������� ���� ������ ���ÿ� �߰����� �����Ƿ� ���� ������ ���������� bfs�� �߰�
		while(!s.isEmpty()) { // ������ �� ������ �ݺ�
			bfs.add(s.pop()); // ������ LIFO ������ �ڷᱸ���̹Ƿ� ���������� ���� ���� ó������ ��µȴ�(���� ������ ������ �������� ���� �������� ���ʴ�� ��µ�)
		}
		return; // ���� �������� ���� �������� �̵��ϴµ� ���ľ��ϴ� ������ �ּ� ������ ��ȯ(�θ� ������ Ÿ�� ���� ���� �ּ� ���� ��ȯ)
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
			int n = Integer.parseInt(nm[0]); // �������� ������ �޾ƿ�
			int m = Integer.parseInt(nm[1]); // �������� ������ �޾ƿ�
			
			ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++)
				arr.add(new ArrayList<Integer>()); // ArrayList<ArrayList<Integer>>�� n����ŭ ����
			for(int i=0; i<m; i++) {
				String[] input = bufReader.readLine().split(" ");
				int vtx = Integer.parseInt(input[0]); // ������ ���� input
				int adj = Integer.parseInt(input[1]); // ������ ������ ������ ���� input
				arr.get(vtx).add(adj); // vtx�� adj�� ������������ ǥ��
				arr.get(adj).add(vtx); // adj�� vtx�� ������������ ǥ��
			}
			
			ArrayList<Integer> bfs = new ArrayList<Integer>();
			
			String[] ab = bufReader.readLine().split(" ");
			int a = Integer.parseInt(ab[0]); // ���� ���� �Է�
			int b = Integer.parseInt(ab[1]); // ���� ���� �Է�
			
			boolean[] visited = new boolean[n]; // ������ ������ŭ �湮 �Ǻ� �迭 ũ�� ����
			
			int[] parent = new int[n]; // ������ ������ŭ �θ� ������ ���� ����
			
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
