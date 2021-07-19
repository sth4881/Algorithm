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

public class Assignment1_2 {
	public static int func(int[] arr, int start, int dest, int n, boolean[] visited, int[] parent) {
		Queue<Integer> q = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		visited[start]=true; // ���� ������ �湮������ ǥ��
		parent[start] = -1; // ���� ������ �θ� ������ �������� �����Ƿ� -1�� �ʱ�ȭ
		
		q.offer(start); // ���� ������ ť�� ����
		while(!q.isEmpty()) { // ť�� �� ������(=�湮�� ������ ���� ������)
			int tmp = q.poll(); // �ӽ� ���� tmp�� ť�� �� ó�� ���� ��ȯ�ϰ� ť���� ����
			if(tmp-arr[tmp]>=0) { // �ش� ����-������ ����ġ�� 0�̻��� ���
				if(!visited[tmp-arr[tmp]]) { // �ش� ����-������ �湮���� �ʾҴٸ�
					visited[tmp-arr[tmp]]=true; // �湮������ ǥ��
					q.offer(tmp-arr[tmp]); // ť�� �ش� ����-������ �߰�
					parent[tmp-arr[tmp]]=tmp; // �ش� ����-������ �θ� ������ tmp�� ����
				}
			}
			if(tmp+arr[tmp]<n) { // �ش� ����+������ ����ġ�� n���� ���� ���
				if(!visited[tmp+arr[tmp]]) { // �ش� ����+������ �湮���� �ʾҴٸ�
					visited[tmp+arr[tmp]]=true; // �湮������ ǥ��
					q.offer(tmp+arr[tmp]); // ť�� �ش� ����+������ �߰�
					parent[tmp+arr[tmp]]=tmp; // �ش� ����+������ �θ� ������ tmp�� ����
				}
			}
		}
		int tmp = dest;
		if(!visited[tmp]) return -1; // ���� �������� �� �� ���� ���(�ش� ������ �湮���� ���� ���)
		while(tmp!=start) { // ������ ������ ��� ������ ������ ������
			s.push(tmp); // ������ tmp�� ���ÿ� �߰�
			tmp = parent[tmp]; // �ӽ� ���� tmp�� tmp�� �θ� �������� ����
		}
		return s.size(); // ������ ������ ���� ���� �������� ������ ������ �θ� ���� ������ ��ȯ
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
			
			int[] cnt = new int[n]; // �� ������ �̵� Ƚ���� ���ϱ� ���� �迭 cnt ����
			
			int[] parent = new int[n]; // �� ���� �θ� ���� ���ϱ� ���� �迭 parent ����
			
			boolean[] visited = new boolean[n]; // �� ���� �湮 ���θ� �Ǵ��ϱ� ���� �迭 visited ����
			
			for(int i=0; i<n; i++)
				cnt[i] = func(arr, start, i, n, visited, parent);
			for(int i=0; i<n; i++)
				System.out.print(cnt[i]+" ");
			
			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}
