package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Student {
	int height;
	int weight;
	int num;
	
	Student(int height, int weight, int num) {
		this.height = height;
		this.weight = weight;
		this.num = num;
	}
	
	public int getHeight() {
		return this.height;
	}
	public int getWeight() {
		return this.weight;
	}
	public int getNum() {
		return this.num;
	}
}

public class Lesson1_6 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			Student[] students = new Student[n];
			for(int i=0; i<n; i++) {
				String[] tmp = br.readLine().split(" ");
				int height = Integer.parseInt(tmp[0]);
				int weight = Integer.parseInt(tmp[1]);
				students[i] = new Student(height, weight, i+1);
			}
			
			Comparator<Student> comparator = new Comparator<Student>() {
				@Override
				public int compare(Student a, Student b) {
					if(a.getHeight()==b.getHeight()) {
						if(a.getWeight()==b.getWeight()) {
							return a.getNum() - b.getNum(); // 키와 몸무게가 같으면 번호가 작은 순으로 정렬
						} else return b.getWeight() - a.getWeight(); // 키가 같고 몸무게가 다르면 몸무게가 큰 순서로 정렬
					} else return b.getHeight() - a.getHeight(); // 키가 다르면 키가 큰 순서로 정렬
				}
			};
			
			Arrays.sort(students, comparator);
			for(int i=0; i<n; i++) {
				bw.write(students[i].getHeight()+" "+students[i].getWeight()+" "+students[i].getNum()+"\n");
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}