package com.algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static void dfs(int start, int depth) {
        arr[depth] = start;
        // 종료 조건 : M개의 숫자가 선택됐을 경우
        if(depth==M) {
            for(int i=1; i<=M; i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            return;
        }
        // i를 start부터 시작하게 만들면 오름차순 수열만 선택 가능
        for(int i=start; i<=N; i++) {
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

            for(int i=1; i<=N; i++) {
                Arrays.fill(visited, false);
                visited[i] = true;
                dfs(i, 1);
            }

            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}