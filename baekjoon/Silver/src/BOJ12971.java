package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

/* 백준 12971번 숫자놀이 (Silver) */
public class BOJ12971 {
	public static int gcd(int a, int b) {
		if(a%b==0) return b;
		else return gcd(b, a%b);
	}
	public static int lcm(int a, int b, int gcd) {
		return a*b/gcd;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			String[] input = br.readLine().split(" ");
			int p1 = Integer.parseInt(input[0]);
			int p2 = Integer.parseInt(input[1]);
			int p3 = Integer.parseInt(input[2]);
			int x1 = Integer.parseInt(input[3]);
			int x2 = Integer.parseInt(input[4]);
			int x3 = Integer.parseInt(input[5]);
			
			int n = 1;
			boolean found = false;
			// 아래와 같이 n을 1부터 10억까지 완전탐색하면 시간초과
//			while(n<1000000000) {
//				if(n%p1==x1 && n%p2==x2 && n%p3==x3) {
//					found = true;
//					break;
//				}
//				n++;
//			}
			// n을 1부터 10억까지 완전탐색하면 시간초과가 발생함 따라서 n을 1부터 
			// 써내려가다 보면 x1, x2, x3가 모두 0을 만드는 N이 도출되고 N+1부터는 사이클이 반복됨을 알 수 있음
			// 이 때 N은 p1, p2, p3의 최소공배수이므로 10억까지 탐색할 필요없이 p1, p2, p3의 최소공배수 전까지만 탐색
			while(n<p1*p2*p3) {
				if(n%p1==x1 && n%p2==x2 && n%p3==x3) {
					found = true;
					break;
				}
				n++;
			}
			
			if(found) bw.write(n+"\n");
			else bw.write(-1+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}