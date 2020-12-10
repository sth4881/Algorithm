package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalDFS {
	public static void func(ArrayList<ArrayList<Integer>> arr, Stack<Integer> s, int vtx, boolean[] visited) {
		visited[vtx]=true; // �ش� ������ �湮�� ���� ������ �湮������ ǥ��
 		for(int i=0; i<arr.get(vtx).size(); i++) { // ���� ������ ������ ������ ������ŭ
			if(!visited[arr.get(vtx).get(i)]) { // ���� ������ ������ ������ �湮���� �ʾҴٸ�
				func(arr, s, arr.get(vtx).get(i), visited); // �ش� ������ ���ؼ� DFS ����
			}
		}
		s.push(vtx); // ���� ������ ���ؼ� ���ÿ� push
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// ũ�Ⱑ n�� ArrayList<Integer> Ÿ���� ArrayList ����
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		// �� n���� Integer Ÿ�� ArrayList ������ ArrayList�� �߰������ν� ���� ����
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// Edge �Է¹޾Ƽ� ����
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
		}
		
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) // ��� ������ ���ؼ� �����ؾ��ϹǷ�
			if(!visited[i]) func(arr, s, i, visited); // ���� i�� �湮���� �ʾҴٸ� ���� i�� ���ؼ� DFS ����
		while(!s.isEmpty()) { // �� �� ���� ������ for(int i=0; i<s.size(); i++)�� ����ϸ� ��� ���� pop���� ���� 
			System.out.print(s.pop()+" ");
		}
	}
}
