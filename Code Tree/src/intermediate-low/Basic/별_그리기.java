package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quiz1_1 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				for(int j=i; j<n-1; j++)
					bw.write(" ");
				for(int j=0; j<2*i+1; j++)
					bw.write("*");
				bw.write("\n");
			}
			for(int i=0; i<n-1; i++) {
				for(int j=i; j>=0; j--)
					bw.write(" ");
				for(int j=n*2-3; j>i*2; j--)
					bw.write("*");
				bw.write("\n");
			}
			
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
