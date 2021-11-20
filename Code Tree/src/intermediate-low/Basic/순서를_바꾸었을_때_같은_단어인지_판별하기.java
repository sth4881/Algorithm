package com.algorithm.codetree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 순서를_바꾸었을_때_같은_단어인지_판별하기 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			String[] input1 = br.readLine().split("");
			String[] input2 = br.readLine().split("");

			if(input1.length!=input2.length) bw.write("No\n"); // 길이 다르면 탈락
			else {
				Arrays.sort(input1); Arrays.sort(input2); // 알파벳 정렬
                boolean isEqual = true;
                for(int i=0; i<input1.length; i++) {
                    if(!input1[i].equals(input2[i])) {
                        isEqual = false;
                        break;
                    }
                }
				if(isEqual) bw.write("Yes\n"); // tmp1와 tmp2가 같으면 Yes
				else bw.write("No\n"); // tmp1와 tmp2가 다르면 No
			}
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
