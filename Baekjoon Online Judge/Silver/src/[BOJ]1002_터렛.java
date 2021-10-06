package com.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1002 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int testcase = Integer.parseInt(br.readLine());
			int[] ans = new int[testcase];
			for(int i=0; i<testcase; i++) {
				String[] tmp = br.readLine().split(" ");
				int x1 = Integer.parseInt(tmp[0]);
				int y1 = Integer.parseInt(tmp[1]);
				int r1 = Integer.parseInt(tmp[2]);
				int x2 = Integer.parseInt(tmp[3]);
				int y2 = Integer.parseInt(tmp[4]);
				int r2 = Integer.parseInt(tmp[5]);
				
				int dx = (int) Math.pow(x1-x2, 2);
				int dy = (int) Math.pow(y1-y2, 2);
				double d = Math.sqrt(dx+dy);
				
				// 알고리즘(두 원의 위치관계)
				if(d == 0 && r1 == r2) { // 두 원이 완전히 겹쳐질 경우
					ans[i] = -1;
				} else if(d > r1+r2 || d < Math.abs(r1-r2)) { // 두 원이 만나지 않는 경우
					ans[i] = 0;
				} else if(d == r1+r2 || d == Math.abs(r1-r2)) { // 두 원이 한 점에서 만나는 경우(외점 or 내접)
					ans[i] = 1;
				} else if(d < r1+r2 && d > Math.abs(r1-r2)) { // 두 원이 두 점에서 만나는 경우
					ans[i] = 2;
				}
			}
			
			for(int i=0; i<ans.length; i++)
				bw.write(ans[i]+"\n");
			bw.close();			
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}
