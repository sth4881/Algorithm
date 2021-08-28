package com.algorithm.codetree.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

class Number {
	private int index;
	private int value;
	Number(int index, int value) {
		this.index = index;
		this.value = value;
	}
	public int getIndex() {
		return index;
	}
	public int getValue() {
		return value;
	}
}

public class 정렬된_숫자_위치_알아내기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			
			Number[] numarr = new Number[n];
			for(int i=0; i<n; i++)
				numarr[i] = new Number(i+1, Integer.parseInt(input[i]));
			
			// 정렬을 위한 comparator 생성
			Comparator<Number> comparator = new Comparator<Number>() {
				@Override
				public int compare(Number a, Number b) {
					if(a.getValue()==b.getValue()) {
						return a.getIndex() - b.getIndex(); // a값과 b값이 같은 경우 번호가 빠른 원소를 반환
					} else return a.getValue() - b.getValue(); // 그 외에 경우에는 값이 작은 순서대로 정렬
				}
			};
			Arrays.sort(numarr, comparator);
			
			int[] ans = new int[n];
			for(int i=0; i<n; i++)
				ans[numarr[i].getIndex()-1] = i+1; // 정렬된 숫자들의 원래 인덱스를 활용하여 정답 배열을 저장
			
			for(int item : ans)
				bw.write(item+" ");
			bw.write("\n");
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
