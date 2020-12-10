package com.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalIndegree {
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> sort, int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		// ������ ������ ���ؼ� indegree ����
		int[] indegree = new int[n]; 
		for(int i=0; i<n; i++) { // ��� ������ ���ؼ�
			for(int j=0; j<arr.get(i).size(); j++) { // ���� ������ ������ ������ ������ŭ
				indegree[arr.get(i).get(j)]++; // ���� ������ ������ ������ ���ؼ� indegree 1 ����
			}
		}
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) q.offer(i); // �ش� �������κ��� ���� indegree�� 0�� ���(���� ������ ���) ť�� �߰�
		}
		
		// ������ ������ ���� indegree�� �������� �������� �˰��� ����
		while(!q.isEmpty()) {
			int output = q.poll(); // ť���� �� ó�� ���Ҹ� ��ȯ �� ����
			sort.add(output); // ��ȯ�� ���Ҹ� ArrayList�� �־ ��� ����
			for(int i=0; i<arr.get(output).size(); i++) { // ��ȯ�� ���ҿ� ������ ������ ������ŭ
				indegree[arr.get(output).get(i)]--; // ��ȯ�� ���ҿ� ������ ������ ���ؼ� indegree 1 ����
				if(indegree[arr.get(output).get(i)]==0) // ��ȯ�� ���ҿ� ������ ������ indegree�� 0�̶��
					q.offer(arr.get(output).get(i)); // �ش� ������ ť�� �߰� 
			}
		}
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
		
		ArrayList<Integer> sort = new ArrayList<Integer>();
		func(arr, sort, n);
		for(int i=0; i<sort.size(); i++) {
			System.out.print(sort.get(i)+" ");
		}
	}
}
