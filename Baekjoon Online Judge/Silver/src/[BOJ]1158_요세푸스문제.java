package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {
	public static Queue<Integer> q;
	public static void main(String[] args) {
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int n = Integer.parseInt(st.nextToken());
		    int k = Integer.parseInt(st.nextToken());
		
		    // 큐를 0부터 N-1까지의 사람들로 채워넣기
		    q = new LinkedList<>();
		    for(int i=1; i<=n; i++)
		    	q.offer(i);
		    
		    LinkedList<Integer> result = new LinkedList<>();
		
		    while(!q.isEmpty()) {
		    	// k-1번 만큼 큐에서 뺐다가 추가한 결과로 도출되는 값을 구해줘야함 
		    	// 따라서 큐의 크기가 k보다 작아졌다고 해도 반복을 유지해줘야함
		    	// if(q.size() < k) break;
		    	// k-1번 만큼 큐에서 빼서 다시 큐에 넣어주기
				for(int i=0; i<k-1; i++) {
					int num = q.poll();
					q.offer(num);
				}
				// k번째 값을 빼내서 결과 리스트에 추가
		    	result.add(q.poll());
		    }
		    
		    // 큐가 비워질 때까지 코드가 반복되므로 아래 코드도 지워줘야함
		    // while(!q.isEmpty()) {
		    //     result.add(q.poll());
		    // }
		    
		    System.out.print("<"+result.get(0));
		    for(int i=1; i<result.size(); i++)
		    	System.out.print(", "+result.get(i));
		    System.out.println(">");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}