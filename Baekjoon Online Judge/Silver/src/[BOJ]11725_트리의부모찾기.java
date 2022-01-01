package com.algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visited;
    public static int[] parent;
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        parent[start] = -1;
        q.offer(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i=0; i<list.get(node).size(); i++) {
                int next = list.get(node).get(i);
                if(visited[next]) continue;
                visited[next] = true;
                parent[next] = node;
                q.offer(next);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for(int i=0; i<=n; i++)
                list.add(new ArrayList<>());

            for(int i=0; i<n-1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited = new boolean[n+1];
            parent = new int[n+1];
            bfs(1);

            for(int i=2; i<=n; i++)
                bw.write(parent[i]+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}