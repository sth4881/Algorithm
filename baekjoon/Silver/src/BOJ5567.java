package com.algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 백준 5567번 결혼식 (Silver) */
public class BOJ5567 {
    public static boolean[] visited;
    public static HashSet<Integer> set;
    public static ArrayList<ArrayList<Integer>> list;
    public static void dfs(int start, int depth) {
        if(depth>2) return;
        set.add(start);
        visited[start] = true;
        for(int i=0; i<list.get(start).size(); i++) {
            int next = list.get(start).get(i);
            if(visited[next]) continue;
            dfs(next, depth+1);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            set = new HashSet<>();
            list = new ArrayList<>();
            for(int i=0; i<=n; i++)
                list.add(new ArrayList<>());

            for(int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited = new boolean[n+1];
            for(int i=0; i<list.get(1).size(); i++) {
                Arrays.fill(visited, false);
                dfs(list.get(1).get(i), 1);
            }

            if(list.get(1).size()==0) bw.write(0+"\n");
            else bw.write(set.size()-1+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}