package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// ũ�Ⱑ n�� ArrayList<Integer> Ÿ���� ArrayList ����
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		// �� n���� Integer Ÿ�� ArrayList�� ���� ArrayList<ArrayList<Integer>>�� �߰������ν� ���� ����
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// Edge �Է¹޾Ƽ� ����
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print("���� "+i+"�� ��������Ʈ : ");
			for(int j=0; j<arr.get(i).size(); j++)
				System.out.print(arr.get(i).get(j)+" ");
			System.out.println();
		}
	}
}
