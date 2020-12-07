package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment3_1 {
	public static int cnt = 0;
	public static void func(ArrayList<ArrayList<Integer>> arr, ArrayList<Integer> dfs, int vtx, boolean[] visited) {
		if(!visited[vtx]) { // ���� ������ �湮���� �ʾҴٸ�
			cnt++; // �������� ������ �����ϱ����ؼ� cnt 1����
			visited[vtx]=true; // �ش� ������ �湮������ ǥ��
			for(int i=0; i<arr.get(vtx).size(); i++) { // �ش� ������ ������ ������ ������ŭ �ݺ�
				func(arr, dfs, arr.get(vtx).get(i), visited); // �ش� ������ ������ ������ ���ؼ� DFS ����
			}
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
			
			ArrayList<Integer> dfs = new ArrayList<Integer>(); // �������� ������ �������� ũ�⸦ ������ ���� ArrayList ����
			
			boolean[] visited = new boolean[n]; // �ش� ������ �湮�ƴ����� �Ǵ��ϱ� ���� visited �迭 ����
			
			for(int i=0; i<n; i++) {
				if(!visited[i]) { 
					func(arr, dfs, i, visited); // �湮���� ���� ������ ���ؼ��� DFS ����(������ ������ ���ؼ��� ������� ����)
					dfs.add(cnt); // ���� �޼ҵ带 ���ؼ� �湮�� ������ ���� i�� ������ �����̹Ƿ� �����ҷ� �������� ����
					cnt = 0; // ���� �޼ҵ带 ���ؼ� �����Ҹ� �����ϴ� ó���� ������ �������� ������ ���� ���� ���� cnt ���� 0���� �ʱ�ȭ�������
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<dfs.size(); i++) {
				if(dfs.get(i) > max) max = dfs.get(i); // �������� ũ�� �߿��� ���� ū ���� max�� ����
			}
			
			System.out.println(dfs.size());
			System.out.println(max);
	
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
