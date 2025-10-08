package com.algorithm.baekjoon;

import java.io.*;

public class BOJ10974 {
    public static int N;
    public static int[] arr;
    public static boolean[] visited;
    public static void dfs(int start, int depth) {
        arr[depth] = start;
        if(depth==N) {
            for(int i=1; i<=N; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        for(int i=1; i<=N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            visited = new boolean[N+1];

            dfs(0, 0);

            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}