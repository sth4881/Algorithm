package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Vertex {
	int x;
	int y;
	int index;
	public Vertex(int x, int y, int index) {
		this.x = x;
		this.y = y;
		this.index = index;
	}
}

public class 원점으로부터의_거리 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Vertex[] arr = new Vertex[n];
			for(int i=0; i<n; i++) {
				String[] input = br.readLine().split(" ");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);
				arr[i] = new Vertex(x, y, i+1);
			}
			
			// 객체들을 특정한 조건에서 비교하기 위한 comparator 생성
			Comparator<Vertex> comparator = new Comparator<Vertex>() {
				@Override
				public int compare(Vertex a, Vertex b) {
					int dis_A = Math.abs(a.x)+Math.abs(a.y); // 원점으로부터 점 a의 거리
					int dis_B = Math.abs(b.x)+Math.abs(b.y); // 원점으로부터 점 b의 거리
					if(dis_A != dis_B) // 원점으로부터의 거리가 두 점 모두 다르다면
						return dis_A - dis_B; // 거리가 가까운 점을 출력
					else // 원점으로부터의 거리가 두 점 모두 같다면
						return a.index - b.index; // 인덱스가 작은 순서대로 출력
				}
			};
			
			Arrays.sort(arr, comparator);
			
			for(int i=0; i<n; i++)
				bw.write(arr[i].index+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}