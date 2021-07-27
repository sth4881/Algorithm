package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//트리 구조를 만들기 위한 Node 클래스 생성
class Node {
	String data;
	Node leftNode, rightNode;
	public Node(String data) {
		this.data = data;
	}
	public Node addLeftNode(Node node) {
        this.leftNode = node;
        return node;
    }
    public Node addRightNode(Node node) {
        this.rightNode = node;
        return node;
    }
}

public class BOJ1991 {
	public static void preOrder(Node node,  ArrayList<String> ans) { // 전위 순회
		ans.add(node.data);
		if(node.leftNode != null) preOrder(node.leftNode, ans); // left node에 자식이 있다면 left node에 대해서 전위 순회
		if(node.rightNode != null) preOrder(node.rightNode, ans); // right node에 자식이 있다면 right node에 대해서 전위 순회
	}
	
	public static void inOrder(Node node, ArrayList<String> ans) { // 중위 순회
		if(node.leftNode != null) inOrder(node.leftNode, ans); // left node에 자식이 있다면 left node에 대해서 중위 순회
		ans.add(node.data);
		if(node.rightNode != null) inOrder(node.rightNode, ans); // right node에 자식이 있다면 left node에 대해서 중위 순회
	}
	
	public static void postOrder(Node node, ArrayList<String> ans) { // 후위 순회
		if(node.leftNode != null) postOrder(node.leftNode, ans); // left node에 자식이 있다면 left node에 대해서 후위 순회
		if(node.rightNode != null) postOrder(node.rightNode, ans); // right node에 자식이 있다면 left node에 대해서 후위 순회
		ans.add(node.data);
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Node> arr = new ArrayList<Node>();
			
			String[] tmp = br.readLine().split(" ");
			Node root = new Node(tmp[0]); // Root Node 초기화
			arr.add(root);
			
			Node leftNode = null;
			Node rightNode = null;
			if(!tmp[1].equals(".")) { // root node의 왼쪽 자식에 값이 있다면
				leftNode = root.addLeftNode(new Node(tmp[1]));
				arr.add(leftNode);
			}
			if(!tmp[2].equals(".")) { // root node의 오른쪽 자식에 값이 있다면
				rightNode = root.addRightNode(new Node(tmp[2]));
				arr.add(rightNode);
			}

			// Root Node를 제외한 노드들을 트리에 추가하는 과정
			for(int i=1; i<n; i++) {
				tmp = br.readLine().split(" ");
				Node curNode = null;
				for(int j=0; j<i; j++) {
					if(arr.get(j).leftNode!=null && arr.get(j).leftNode.data==tmp[0]) {
						curNode = arr.get(j).leftNode;
						break;
					} else if(arr.get(j).rightNode!=null && arr.get(j).rightNode.data==tmp[0]) {
						curNode = arr.get(j).rightNode;
						break;
					}
				}

//				System.out.println(curNode.data);
//				if(curNode.leftNode!=null) System.out.println(curNode.leftNode.data);
//				if(curNode.rightNode!=null) System.out.println(curNode.rightNode.data);
				
				if(!tmp[1].equals(".")) { // i번째 node의 왼쪽 자식에 값이 있다면
					leftNode = curNode.addLeftNode(new Node(tmp[1])); // i번째 node의 왼쪽 자식의 값을 초기화
					arr.add(leftNode);
				}
				if(!tmp[2].equals(".")) { // i번째 node의 오른쪽 자식에 값이 있다면
					rightNode = curNode.addRightNode(new Node(tmp[2])); // i번째 node의 오른쪽 자식의 값을 초기화
					arr.add(rightNode);
				}
				
//				for(int j=0; j<i; j++) {
//					// 전체 트리에서 각각의 노드에 대한 왼쪽 자식 노드와 현재 입력되는 노드의 값이 같을 경우(현재 노드가 왼쪽 자식일 경우)
//					if(arr.get(j).leftNode != null && arr.get(j).leftNode.data==curNode.data) {
//						if(curNode.leftNode!=null) arr.get(j).leftNode.addLeftNode(curNode.leftNode); // 현재 노드의 왼쪽 자식이 존재하면 왼쪽 부분에 추가
//						if(curNode.rightNode!=null) arr.get(j).leftNode.addRightNode(curNode.rightNode); // 현재 노드의 오른쪽 자식이 존재하면 왼쪽 부분에 추가
//					}
//					 // 전체 트리에서 각각의 노드에 대한 오른쪽 자식 노드와 현재 입력되는 노드의 값이 같을 경우(현재 노드가 오른쪽 자식일 경우)
//					if(arr.get(j).rightNode != null && arr.get(j).rightNode.data==curNode.data) {
//						if(curNode.leftNode!=null) arr.get(j).rightNode.addLeftNode(curNode.leftNode); // 현재 노드의 왼쪽 자식이 존재하면 오른쪽 부분에 추가
//						if(curNode.rightNode!=null) arr.get(j).rightNode.addRightNode(curNode.rightNode); // 현재 노드의 오른쪽 자식이 존재하면 오른쪽 부분에 추가
//					}
//				}
			}
			
			ArrayList<String> ans = new ArrayList<String>();
			preOrder(root, ans);
			for(int i=0; i<ans.size(); i++)
				bw.write(ans.get(i)+"");
			bw.write("\n");
			
			ans = new ArrayList<String>();
			inOrder(root, ans);
			for(int i=0; i<ans.size(); i++)
				bw.write(ans.get(i)+"");
			bw.write("\n");
			
			ans = new ArrayList<String>();
			postOrder(root, ans);
			for(int i=0; i<ans.size(); i++)
				bw.write(ans.get(i)+"");
			bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace(); 
		}
	}
}