package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* 백준 1991번 트리순회 (Silver) */
public class BOJ1991 {
	public static class Node {
		char data;
		Node left;
		Node right;
		public Node(char data) {
			this.data = data;
		}
	}
	public static class Tree {
		Node root;
		ArrayList<Character> preOrderList = new ArrayList<Character>();
		ArrayList<Character> inOrderList = new ArrayList<Character>();
		ArrayList<Character> postOrderList = new ArrayList<Character>();
		public void createNode(char rootData, char leftData, char rightData) {
			// 루트 노드가 존재하지 않아서 트리가 구성되지 않는 경우 루트 노드를 생성
			if(root == null) {
				root = new Node(rootData);
				if(leftData != '.') root.left = new Node(leftData);
				if(rightData != '.') root.right = new Node(rightData);
			}
			// 루트 노드가 존재하여 트리가 구성된 경우 해당 노드를 트리의 어느 부분에 위치시킬지 결정
			else appendNode(root, rootData, leftData, rightData);
		}
		public void appendNode(Node root, char rootData, char leftData, char rightData) {
			// 현재 노드의 값과 일치하는 노드를 찾지 못한 경우 재귀 종료
			if(root == null) return;
			// 현재 노드의 값과 일치하는 노드를 찾은 경우
			else if(root.data == rootData) {
				// 현재 노드의 왼쪽 노드에 값이 존재하는 경우 루트 노드와 연결
				if(leftData != '.') root.left = new Node(leftData);
				// 현재 노드의 오른쪽 노드에 값이 존재하는 경우 루트 노드와 연결
				if(rightData != '.') root.right = new Node(rightData);
			}
			// 현재 노드의 값과 일치하는 노드를 찾지 못했고 탐색할 노드가 남아있는 경우
			// 현재 노드의 왼쪽 노드와 오른쪽 노드를 각각 재귀적으로 탐색
			else {
				appendNode(root.left, rootData, leftData, rightData);
				appendNode(root.right, rootData, leftData, rightData);
			}
		}
		// 전위 순회
		public void preOrder(Node root) {
			preOrderList.add(root.data);
			if(root.left != null) preOrder(root.left);
			if(root.right != null) preOrder(root.right);
		}
		// 중위 순회
		public void inOrder(Node root) {
			if(root.left != null) inOrder(root.left);
			inOrderList.add(root.data);
			if(root.right != null) inOrder(root.right);
		}
		// 후위 순회
		public void postOrder(Node root) {
			if(root.left != null) postOrder(root.left);
			if(root.right != null) postOrder(root.right);
			postOrderList.add(root.data);
		}
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 입력 & 선언 & 초기화
			int n = Integer.parseInt(br.readLine());
			Tree tree = new Tree();
			for(int i=0; i<n; i++) {
				String[] str = br.readLine().split(" ");
				tree.createNode(str[0].charAt(0), str[1].charAt(0), str[2].charAt(0));
			}
			
			// 전위 순회
			tree.preOrder(tree.root);
			for(char item : tree.preOrderList)
				bw.write(item+"");
			bw.write("\n");
			
			// 중위 순회
			tree.inOrder(tree.root);
			for(char item : tree.inOrderList)
				bw.write(item+"");
			bw.write("\n");
			
			// 후위 순회
			tree.postOrder(tree.root);
			for(char item : tree.postOrderList)
				bw.write(item+"");
			bw.write("\n");
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}