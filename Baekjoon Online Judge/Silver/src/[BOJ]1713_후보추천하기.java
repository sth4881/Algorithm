package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ1713 {
	public static class Student {
		int num = 0; // 학생의 번호
		int total = 0; // 학생이 받은 추천수
		int tStamp = 0; // 사진이 게시된 시간
		public Student(int num, int total, int tStamp) {
			this.num = num;
			this.total = total;
			this.tStamp = tStamp;
		}
	}
	public static int[] arr;
	public static Student[] students;
	public static ArrayList<Student> list;
	public static void recommendation() {
		// 전체 학생 수를 101명으로 초기화(0 제외) 
		students = new Student[101];
		list = new ArrayList<Student>();
		for(int i=0; i<arr.length; i++) {
			// 사진이 게시된 후보가 3명 미만인 경우 후보의 사진을 게시
			if(list.size()<3) list.add(new Student(arr[i], 1, i));
			// 사진이 게시된 후보가 3명 이상인 경우
			else {
				// 추천을 받은 후보의 사진이 게시되어 있지 않다면
				if(!onBoard(i)) {
					
				}
			}
		}
	}
	// 추천을 받은 후보의 사진이 게시되어 있는지 확인
	public static boolean onBoard(int i) {
		for(int j=0; j<list.size(); j++) {
			// 추천을 받은 후보의 사진이 이미 게시되어 있는 경우
			if(list.get(j).num==arr[i]) {
				list.get(j).total += 1;
				return true;
			}
		}
		// 추천을 받은 후보의 사진이 게시되어 있지 않은 경우 false 반환
		return false;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			// 입력
			int n = Integer.parseInt(br.readLine()); // 사진틀의 개수
			int m = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			// 선언 & 초기화
			arr = new int[m];
			for(int i=0; i<m; i++)
				arr[i] = Integer.parseInt(input[i]);
			
			// 알고리즘
			recommendation();

			// 출력(오름차순으로 정렬)
			//Collections.sort(list);
			//for(int item : list)
			//	bw.write(item+" ");
			//bw.write("\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
