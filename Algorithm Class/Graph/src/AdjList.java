package com.algorithm.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		// 크기가 n인 ArrayList<Integer> 타입의 ArrayList 선언
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(n);
		// 총 n개의 Integer 타입 ArrayList를 각각 ArrayList<ArrayList<Integer>>에 추가함으로써 최종 생성
		for(int i=0; i<n; i++)
			arr.add(new ArrayList<Integer>());
		
		// Edge 입력받아서 적용
		for(int i=0; i<m; i++) {
			int vertex1, vertex2;
			vertex1 = sc.nextInt();
			vertex2 = sc.nextInt();
			arr.get(vertex1).add(vertex2);
			arr.get(vertex2).add(vertex1);
		}
		
		for(int i=0; i<arr.size(); i++) {
			System.out.print("정점 "+i+"의 인접리스트 : ");
			for(int j=0; j<arr.get(i).size(); j++)
				System.out.print(arr.get(i).get(j)+" ");
			System.out.println();
		}
	}
}
