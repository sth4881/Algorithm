package com.algorithm.baekjoon;

import java.io.*;

/* 백준 1531번 투명 (Silver) */
public class BOJ1531 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 입력
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int[][] pic = new int[101][101];
            for(int i=0; i<n; i++) {
                String[] input = br.readLine().split(" ");
                int minX = Integer.parseInt(input[0]);
                int minY = Integer.parseInt(input[1]);
                int maxX = Integer.parseInt(input[2]);
                int maxY = Integer.parseInt(input[3]);
                for(int j=minX; j<=maxX; j++) {
                    for(int k=minY; k<=maxY; k++) {
                        pic[j][k]++;
                    }
                }
            }

            int cnt = 0;
            for(int i=0; i<101; i++) {
                for(int j=0; j<101; j++) {
                    if(pic[i][j]>m) cnt++;
                }
            }

            // 출력
            bw.write(cnt+"\n");
            bw.close();
        } catch(FileNotFoundException e) {
            e.getStackTrace();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}