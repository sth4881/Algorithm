package com.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSList {
	public static void func(ArrayList<ArrayList<Integer>> arr,  int n, int vtx, boolean[] visited, int[] parent) {		
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		visited[vtx]=true; // ���� ������ �湮������ ǥ��
		parent[vtx] = -1; // ���� ������ �θ� ��尡 �����Ƿ� -1 ����
		
		q.offer(vtx); // ���� ������ ť�� ����
		while(!q.isEmpty()) { // ť�� �� ������(=�湮�� ������ ���� ������)
			int tmp = q.poll(); // �ӽ� ���� tmp�� ť�� �� �տ� �ִ� ���� ����
			bfs.add(tmp); // �湮�� ������ bfs�� ����
			System.out.print(tmp+" ");
			for(int i=0; i<arr.get(tmp).size(); i++) { // ���� ������ ������ ��� ������ŭ �ݺ�
				if(!visited[arr.get(tmp).get(i)]) { // �ش� ������ �湮���� �ʾҴٸ�
					visited[arr.get(tmp).get(i)] = true; // �ش� ������ �湮������ ǥ��
					q.offer(arr.get(tmp).get(i)); // ť�� �ش� ������ �߰�
					parent[arr.get(tmp).get(i)] = tmp; // tmp�� ������ ������ �θ� tmp�� ����
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// ũ�Ⱑ n�� ArrayList<Integer> Ÿ���� ArrayList ����
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		// �� n���� Integer Ÿ�� ArrayList�� ���� ArrayList<ArrayList<Integer>>�� �߰������ν� ���� ����
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		boolean[] visited = new boolean[n];
		
		int[] parent = new int[n];
		
		// Edge �Է¹޾Ƽ� ����
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		func(arr, n, 0, visited, parent);
		for(int i=0; i<n; i++)
			System.out.print(parent[i]+" ");
	}
}
