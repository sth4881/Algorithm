package com.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visited;
    static void dfs(int start, int depth) {
        arr[depth] = start;
        // 종료 조건 : M개의 숫자가 선택됐을 경우
        if(depth==M) {
            for(int i=1; i<=M; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                // 재귀
                dfs(i, depth+1);
                // 백트래킹
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N+1];
            visited = new boolean[N+1];

            dfs(0, 0);

            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}