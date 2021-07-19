package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment1_1 {
	public static int cnt = 0;
	public static void func(int[] arr, int vtx, boolean[] visited) {
		cnt++; // ���� �̵��� ������ cnt 1����
		visited[vtx] = true; // �湮�� ���� ���ؼ� �湮������ ǥ��
		
		if(vtx-arr[vtx]>=0) {
			if(!visited[vtx-arr[vtx]]) {
				func(arr, vtx-arr[vtx], visited);
			}
		}
		
		if(vtx+arr[vtx]<arr.length) {
			if(!visited[vtx+arr[vtx]]) {
				func(arr, vtx+arr[vtx], visited);
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
			
			int n = Integer.parseInt(bufReader.readLine()); // �׽�Ʈ ���̽��� ������ �Է¹ޱ� ���� ����
			int start = Integer.parseInt(bufReader.readLine()); // ���� �� ��ġ
			String[] input = bufReader.readLine().split(" "); // // �׽�Ʈ ���̽��� �Է¹޴� ����

			int[] arr = new int[n];
			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			boolean[] visited = new boolean[n];
			
			func(arr, start, visited);
			System.out.println(cnt);
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
