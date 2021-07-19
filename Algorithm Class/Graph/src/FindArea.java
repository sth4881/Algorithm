package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment2_1 {
	public static int cnt =0;
	public static void func(int[][] arr, ArrayList<Integer> dfs, int m, int n, int row, int col, boolean[][] visited) {
		if(arr[row][col]==0 && visited[row][col]==false) { // �ش� ��ġ�� ���� 0�� ��� �湮������ ǥ���ϰ� cnt 1����
			cnt++; // ��ΰ� ��Ű�� �ʰ� �̾��� ������ ������ ũ�� 1 ����
			visited[row][col] = true; // �ش� ��ġ�� �湮������ ǥ��
			// �����¿�� �� �� �ִ��� ������ �˻��ؼ� �ش� �������� �� �� ������ ��������� ȣ��
			if(row-1>=0 && arr[row-1][col]==0 && visited[row-1][col]==false) { // ���� ������ ���� 0�̰� �湮�ߴ���
				func(arr, dfs, m, n, row-1, col, visited);
			}
			if(row+1<m && arr[row+1][col]==0 && visited[row+1][col]==false) { // �Ʒ��� ������ ���� 0�̰� �湮�ߴ���
				func(arr, dfs, m, n, row+1, col, visited);
			}
			if(col-1>=0 && arr[row][col-1]==0 && visited[row][col-1]==false) { // ���� ������ ���� 0�̰� �湮�ߴ���
				func(arr, dfs, m, n, row, col-1, visited);
			}
			if(col+1<n && arr[row][col+1]==0 && visited[row][col+1]==false) { // ������ ������ ���� 0�̰� �湮�ߴ���
				func(arr, dfs, m ,n, row, col+1, visited);
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
			
			String[] size = bufReader.readLine().split(" "); // �׽�Ʈ ���̽��� ������ �Է¹ޱ� ���� ����
			int m = Integer.parseInt(size[0]);
			int n = Integer.parseInt(size[1]);
			
			int[][] arr = new int[m][n];
			for(int i=0; i<m; i++) {
				String[] line = bufReader.readLine().split("");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
				}
			}
			
			ArrayList<Integer> dfs = new ArrayList<Integer>();
			
			boolean[][] visited = new boolean[m][n];

			for(int row=0; row<m; row++) {
				for(int col=0; col<n; col++) {
					func(arr, dfs, m, n, row, col, visited); // ��� ���ҿ� ���ؼ� �˻��ؾ��ϹǷ� mxn��ŭ �ݺ�
					if(cnt>0)	dfs.add(cnt); // ������ ������ ũ�⸦ ArrayList�� ����(������ ũ�Ⱑ 0�� ��츦 ����) 
					cnt = 0; // ��ΰ� ��Ų ��� ������ ũ�⵵ 0���� �ʱ�ȭ
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i=0; i<dfs.size(); i++)
				if(dfs.get(i) > max) max = dfs.get(i);
			
			System.out.println(dfs.size()+" "+max);

			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
