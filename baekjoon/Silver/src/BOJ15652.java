package com.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/* 백준 15652번 N과 M (4) (Silver) */
public class BOJ15652 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw;
    static void dfs(int start, int depth) throws IOException {
        arr[depth] = start;
        // 종료 조건 : M개의 숫자가 선택됐을 경우
        if(depth==M) {
            for(int i=1; i<=M; i++)
                bw.write(arr[i]+" ");
            bw.write("\n");
            return;
        }
        // i가 start에서 시작하므로 중복되는 수를 포함한 비내림차순 성립
        for(int i=start; i<=N; i++) {
            // 재귀
            dfs(i, depth + 1);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];

            for(int i=1; i<=N; i++)
                dfs(i, 1);

            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}