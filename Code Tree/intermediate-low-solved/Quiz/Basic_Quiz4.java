package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Basic_Quiz4 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			arr[0] = "1";
//			if(n>1) {
//				for(int i=1; i<n; i++) {
//					arr[i] = "";
//				}
//			}
			if(n>1) {
				arr[1] = "11";
				for(int i=2; i<n; i++) {
					arr[i] = "";
				}
			}
			
			// j번째 숫자를 target으로 삼아서 이후의 숫자들이 target이 아닌 값을 만날때까지 cnt증가 
			for(int i=2; i<n; i++) {
				String[] tmp = arr[i-1].split(""); // i번째 수열을 구하기 위해서는 i-1번째 수열을 알아야함
				for(int j=0; j<tmp.length; j++) {
					int cnt = 1;
					String target = tmp[j]; //  j번째 이후의 원소들에 대해서 같은지를 비교하기 위해서 i-1번째 수열의 j번째 원소를 타겟으로 삼음
					if(target != tmp[tmp.length-1]) {
						while(j<tmp.length-1 && target.equals(tmp[j+1])) {
							cnt++; // 타겟으로 삼은 원소의 값과 다음 원소의 값이 같다면 cnt 증가
							j++;
						}
					} else {
						if(tmp[tmp.length-2]==tmp[tmp.length-1]) arr[i] += tmp[tmp.length-1];
					}
					arr[i] += (target+Integer.toString(cnt)); // 다음 원소의 값이 같지 않으므로 조건문을 빠져나와서 i번째 수열의 값을 갱신
				}
			}
			
			bw.write(arr[n-1]+"\n");
			bw.close();
		} catch(FileNotFoundException e) {
			e.getStackTrace();
		} catch(IOException e) {
			e.getStackTrace();
		}
	}
}