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
			if(n>1) {
				for(int i=1; i<n; i++) {
					arr[i] = "";
				}
			}
			
//			// j번째 숫자를 target으로 삼아서 이후의 숫자들이 target이 아닌 값을 만날때까지 cnt증가
//			for(int i=1; i<n; i++) {
//				String[] seq = arr[i-1].split(""); // i번째 수열을 구하기 위해서는 i-1번째 수열을 알아야함
//				for(int j=0; j<seq.length; j++) {
//					int cnt = 1; // i-1번째 수열의 j번째 숫자를 카운트하기 위한 변수 cnt를 1로 초기화
//					if(j<seq.length-1 && seq[j].equals(seq[j+1])) { // 수열 seq의 j번째 숫자가 마지막 숫자가 아니고 그 다음 숫자가 일치하면
//						cnt++; // j번째 숫자가 연속된다는 뜻이므로 1증가
//					}
//					else if(j==seq.length-1) { // 수열 seq의 j번째 숫자가 마지막 숫자라면
//						System.out.println(i+" "+j+" "+"GG");
//						if(seq.length>1 && !seq[seq.length-2].equals(seq[seq.length-1])) { // 해당 숫자가
//							arr[i] += (seq[seq.length-1] + Integer.toString(cnt));
//						} else if(seq.length>1 && !seq[seq.length-2].equals(seq[seq.length-1])) {
//							arr[i] += (seq[j]+ Integer.toString(cnt));
//						}
//					}
//				}
//			}

			for(int i=1; i<n; i++) {
				String[] seq = arr[i-1].split(""); // i번째 수열을 구하기 위해서는 i-1번째 수열을 알아야함
				for(int j=0; j<seq.length; j++) {
					int cnt = 1;
					String target = seq[j]; //  j번째 이후의 원소들에 대해서 같은지를 비교하기 위해서 i-1번째 수열의 j번째 원소를 타겟으로 삼음
					if(target != seq[seq.length-1]) { // 현재 target이 수열의 마지막 숫자가 아니라면
						while(j<seq.length-1 && target.equals(seq[j+1])) {
							cnt++; // 타겟으로 삼은 원소의 값과 다음 원소의 값이 같다면 cnt 증가
							j++;
						}
					} else { // 현재 target이 수열의 마지막 숫자라면
						if(seq.length>1 && seq[seq.length-2].equals(seq[seq.length-1])) { // 마지막 숫자가 이전 숫자와 같은(?) 경우에 대해서 처리
							arr[i] += seq[seq.length-1] + Integer.toString(cnt);
						}
					}
					arr[i] += (target+Integer.toString(cnt)); // 다음 원소의 값이 같지 않으므로 조건문을 빠져나와서 i번째 수열의 값을 target과 cnt값을 더해서 갱신
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