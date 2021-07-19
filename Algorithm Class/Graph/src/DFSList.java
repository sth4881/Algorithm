package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DFSList {
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfs, ArrayList<Boolean> visited, int vtx) {
		dfs.add(vtx); // ���� ������ �湮�� ��Ͽ� ������� �߰�
		visited.set(vtx, true); // ���� ������ �湮�ߴٰ� ǥ��
		
		for(int i=0; i<arr.get(vtx).size(); i++) { // ���� vtx�� ������ ������ ������ŭ �ݺ�
			if(!visited.get(arr.get(vtx).get(i))) { // ���� vtx�� ������ ������ �湮���� �ʾҴٸ�
				func(arr, dfs, visited, arr.get(vtx).get(i)); // �ش� ������ DFS�� �湮
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// ũ�Ⱑ n�� ArrayList<Integer> Ÿ���� ArrayList ����
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		// �� n���� Integer Ÿ�� ArrayList�� ���� ArrayList<ArrayList<Integer>>�� �߰������ν� ���� ����
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// DFS�� �湮�� ������ �����ϱ� ���� ArrayList ����
		ArrayList<Integer> dfs = new ArrayList<Integer>();
		
		// �湮�� �������� ǥ���ϱ� ���� ArrayList ����(�⺻�� false)
		ArrayList<Boolean> visited = new ArrayList<Boolean>();
		for(int i=0; i<n; i++)
			visited.add(false);
		
		// Edge �Է¹޾Ƽ� ����
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		// DFS ���� �� ���
		func(arr, dfs, visited, 0);
		for(int i=0; i<dfs.size(); i++)
			System.out.print(dfs.get(i)+" ");
	}
}
