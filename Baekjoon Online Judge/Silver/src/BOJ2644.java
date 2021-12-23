package com.algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2644 {
    public static int cnt, answer;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> list;
    public static void dfs(int src, int dsc) {
        visited[src] = true;
        for(int i=0; i<list.get(src).size(); i++) {
            if(visited[list.get(src).get(i)]) continue;
            cnt++; // 촌수 차이가 날 때마다 cnt 1 증가
            dfs(list.get(src).get(i), dsc);
            cnt--; // 백트래킹을 위해서 cnt 1 감소
        }
        // 시작점과 도착점이 같아지는 시점에 cnt를 answer에 저장
        if(src==dsc) answer = cnt;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i=0; i<=n; i++)
                list.add(new ArrayList<>());

            int m = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.get(x).add(y);
                list.get(y).add(x);
            }

            visited = new boolean[n+1];
            dfs(a, b);

            if(!visited[b]) bw.write(-1+"\n");
            else bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}