package com.assignment.no6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment2_2 {
	public static int func(int[][] arr, Vertex[][] vtx, int m, int n, int srcRow, int srcCol, int dstRow, int dstCol, Vertex[][] parent) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		Stack<Vertex> s = new Stack<Vertex>();
		vtx[srcRow][srcCol].visited=true; // ���� �������� ��� Ž���� �����ϹǷ� �湮������ ǥ��
		parent[srcRow][srcCol].x=-1; // ���� ������ �θ� ������ �������� �����Ƿ� ���� ������ x��ǥ�� -1�� ����
		parent[srcRow][srcCol].y=-1; // ���� ������ �θ� ������ �������� �����Ƿ� ���� ������ y��ǥ�� -1�� ����
		
		int row = srcRow;
		int col =srcCol;
		
		if(arr[row][col]==1) return -1;
		
		q.offer(vtx[row][col]); // ���� ������ ť�� �߰�
		while(!q.isEmpty()) {
			Vertex tmp = q.poll(); // �ӽ� ���� tmp�� ť�� �� �� ������ �����ϰ� �ش� ������ ť���� ����
			if(tmp.x-1>=0 && arr[tmp.x-1][col]==0) { // ���ʿ� ������ �����ϰ�, �� ������ ���� 0�̶��
				if(vtx[tmp.x-1][tmp.y].visited==false) { // ���� ������ �湮���� �ʾҴٸ�
					vtx[tmp.x-1][tmp.y].visited=true; // ���� ������ �湮������ ǥ��
					q.offer(vtx[tmp.x-1][tmp.y]); // ���� ������ ť�� �߰�
					parent[tmp.x-1][tmp.y]=tmp; // ���� ������ �θ� ������ tmp�� ����
				}
			}
			if(tmp.x+1<m && arr[tmp.x+1][tmp.y]==0) { // �Ʒ��ʿ� ������ �����ϰ�, �� ������ ���� 0�̶��
				if(vtx[tmp.x+1][tmp.y].visited==false) { // �Ʒ��� ������ �湮���� �ʾҴٸ�
					vtx[tmp.x+1][tmp.y].visited=true; // �Ʒ��� ������ �湮������ ǥ��
					q.offer(vtx[tmp.x+1][tmp.y]); // �Ʒ��� ������ ť�� �߰�
					parent[tmp.x+1][tmp.y]=tmp; // �Ʒ��� ������ �θ� ������ tmp�� ����
				}
			}
			if(tmp.y-1>=0 && arr[tmp.x][tmp.y-1]==0) { // ���ʿ� ������ �����ϰ�, �� ������ ���� 0�̶��
				if(vtx[tmp.x][tmp.y-1].visited==false) { // ���� ������ �湮���� �ʾҴٸ�
					vtx[tmp.x][tmp.y-1].visited=true; // ���� ������ �湮������ ǥ��
					q.offer(vtx[tmp.x][tmp.y-1]); // ���� ������ ť�� �߰�
					parent[tmp.x][tmp.y-1]=tmp; // ���� ������ �θ� ������ tmp�� ����
				}
			}
			if(tmp.y+1<n && arr[tmp.x][tmp.y+1]==0) { // �����ʿ� ������ �����ϰ�, �� ������ ���� 0�̶��
				if(vtx[tmp.x][tmp.y+1].visited==false) { // ������ ������ �湮���� �ʾҴٸ�
					vtx[tmp.x][tmp.y+1].visited=true; // ������ ������ �湮������ ǥ��
					q.offer(vtx[tmp.x][tmp.y+1]); // ������ ������ ť�� �߰�
					parent[tmp.x][tmp.y+1]=tmp; // ������ ������ �θ� ������ tmp�� ����
				}
			}
		}
		
		Vertex tmp = vtx[dstRow][dstCol];
		if(tmp.visited==false) return -1;
		while(tmp!=vtx[srcRow][srcCol]) {
			s.push(tmp);
			tmp = parent[tmp.x][tmp.y];
		}
		return s.size()+1; // ���� ������ ���� 0�̹Ƿ� +1�������
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
			Vertex[][] vtx = new Vertex[m][n]; // 2���� �迭�� ��ǥ�� ť�� �־��ֱ� ���ؼ� vtx ����
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					vtx[i][j] = new Vertex(); // ������ vtx���� �޸𸮸� �Ҵ������ν� ����
				}
			}
			Vertex[][] parent = new Vertex[m][n]; // �������κ��� ���� ���������� �ִܰ�θ� ã�� ���ؼ� parent ���� 
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					parent[i][j] = new Vertex(); // ������ parent���� �޸𸮸� �Ҵ������ν� ����
				}
			}
			
			for(int i=0; i<m; i++) {
				String[] line = bufReader.readLine().split("");
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(line[j]);
					vtx[i][j].x=i; // Vertex���� x��ǥ �ο�
					vtx[i][j].y=j; // Vertex���� y��ǥ �ο�
				}
			}
			
			String[] input = bufReader.readLine().split(" ");
			int srcRow = Integer.parseInt(input[0]);
			int srcCol = Integer.parseInt(input[1]);
			int dstRow = Integer.parseInt(input[2]);
			int dstCol = Integer.parseInt(input[3]);
			
			int result = func(arr, vtx, m, n, srcRow, srcCol, dstRow, dstCol, parent);
			System.out.println(result);

			reader.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}

class Vertex {
	int x=0;
	int y=0;
	boolean visited=false;
}
