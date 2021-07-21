package com.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2609 {
	public static int gcd(int a, int b) {
		while(b>0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static int lcm(int a, int b, int gcd) {
		return a*b/gcd;
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] tmp = br.readLine().split(" ");
			int a = Math.max(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			int b = Math.min(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			
			int gcd = gcd(a, b);
			int lcm = lcm(a, b, gcd);
			
			bw.write(gcd+"\n");
			bw.write(lcm+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
