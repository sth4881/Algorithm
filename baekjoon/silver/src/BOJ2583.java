package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

/* 백준 2583번 영역구하기 (Silver) */
public class BOJ2583 {
    public static int area;
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<Integer> areas;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void paintSquare(int minX, int maxX, int minY, int maxY) {
        for(int i=minX; i<maxX; i++) {
            for(int j=minY; j<maxY; j++) {
                grid[i][j] = 1;
            }
        }
    }
    public static void bfs(int x, int y, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        area++; // 시작 지점을 포함하므로 영역 1증가
        q.offer(new Node(x, y));
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                // 다음 방문하려는 지점이 직사각형이 아니고 방문되지 않았다면
                if(grid[nx][ny]==0 && !visited[nx][ny]) {
                    // 해당 지점이 방문 예정임을 표시 및 큐에 추가 후에 영역 범위 1 증가
                    q.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            grid = new int[n][m];
            areas = new ArrayList<>();
            visited = new boolean[n][m];

            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int minX = Integer.parseInt(st.nextToken());
                int minY = Integer.parseInt(st.nextToken());
                int maxX = Integer.parseInt(st.nextToken());
                int maxY = Integer.parseInt(st.nextToken());
                paintSquare(minX, maxX, minY, maxY);
            }

            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    // 직사각형이 칠해져 있지 않고 방문된 적이 없으면
                    if(grid[i][j]==0 && !visited[i][j]) {
                        // BFS 수행 및 구한 영역의 범위를 리스트에 추가 및 영역의 개수를 1 증가
                        bfs(i, j, n, m);
                        areas.add(area);
                        area = 0;
                        cnt++;
                    }
                }
            }

            Collections.sort(areas);
            bw.write(cnt+"\n");
            for(int item : areas)
                bw.write(item+" ");
            bw.write("\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}