package com.algorithm.codetree;

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
			if(n>1) {
				for(int i=1; i<n; i++) {
					arr[i] = "";
				}
			}

			for(int i=1; i<n; i++) {
				String[] seq = arr[i-1].split(""); // i번째 수열을 구하기 위해서는 i-1번째 수열을 알아야함
				for(int j=0; j<seq.length; j++) {
					String target = seq[j]; //  j번째 이후의 원소들에 대해서 같은지를 비교하기 위해서 i-1번째 수열의 j번째 원소를 타겟으로 삼음
					int cnt = 1; // 타겟으로 삼은 원소에 대한 반복을 위해서 cnt를 1로 초기화
					while(j<seq.length-1 && target.equals(seq[j+1])) { // 타겟으로 삼은 원소의 값과 j+1 원소의 값이 같다면
						cnt++;
						j++;
					}
					// 타겟으로 삼은 원소의 값과 j+1 원소의 값이 같지 않으면 i번째 수열의 값을 target과 cnt값을 더해서 갱신
					// 마지막 원소와 그 전 원소의 값이 같은 경우에는 while문을 돌고, j가 증가하면서 for문을 빠져나옴 
					// 마지막 원소와 그 전 원소의 값이 다른 경우에는 while문을 돌지 않고 빠져나옴
					arr[i] += (target+Integer.toString(cnt));
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
