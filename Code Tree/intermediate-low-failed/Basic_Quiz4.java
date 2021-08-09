package com.algorithm.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Quiz1_4 {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int n = Integer.parseInt(br.readLine());
			String[] arr = new String[n];
			arr[0] = "1";
			if(n>1) {
				arr[1] = "11";
				for(int i=2; i<n; i++) {
					arr[i] = "";
				}
			}
			
			for(int i=2; i<n; i++) {
				String[] tmp = arr[i-1].split(""); // i번째 수열을 구하기 위해서는 i-1번째 수열을 알아야함
				for(int j=1; j<tmp.length; j++) { // i-1번째 수열의 원소 각각에 대해서 반복
					int cnt = 1;
					String target = tmp[j-1];	//  j-1번째 이후의 원소들에 대해서 같은지를 비교하기 위해서 i-1번째 수열의 j-1번째 원소를 타겟으로 삼음
					while(j<tmp.length && target.equals(tmp[j])) { // target과 같은 숫자가 나오지 않을 때까지 반복
						System.out.println(arr[i]+" "+target+" "+tmp[j]); // !!!!! target과 tmp[j] 값은 1, 2로 서로 달라야 하는데 출력 결과는 1, 1로 같게 나오는 문제
						cnt++; // 타겟으로 삼은 원소의 값과 j번째 원소의 값이 같다면 cnt 증가
						j++; // 다음 원소를 비교해야하므로 j 증가
					}
					arr[i] += (target+Integer.toString(cnt)); // j번째 원소가 같지 않으므로 while문을 빠져나와서 i번째 수열의 값을 갱신
					// !!!!! arr[i] += 를 수행하면 값이 이어붙여져야하는데 마지막 값만 들어가는 문제
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
