## 백준 11559번 Puyo Puyo (골드 4)

### 문제링크
- https://www.acmicpc.net/problem/11559

### 알고리즘
1. 현재 화면을 보고 `Puyo Puyo`의 연쇄가 몇 번 일어나는지 구하는 문제이다.
2. 우선 현재 화면에서 연쇄가 일어나는 `Puyo`를 찾기 위해 각 `Puyo`에 대해서 BFS를 수행한다.
3. `Puyo`와 같은 색깔의 `Puyo`가 4개 이상 인접할 때 연쇄가 발생하므로, 연쇄를 찾아주기 위해 `Puyo`를 발견하면 리스트에 넣어준다.
4. BFS를 마친 `Puyo`로 인해 리스트의 크기가 4이상인 경우, 연쇄가 발생했다고 보고 리스트에 저장된 `Puyo`들을 모두 제거해준다.
5. 위의 과정을 각 `Puyo`에 대해 수행한 후에 연쇄로 인해 바닥과 `Puyo` 사이에 빈 공간이 생겼다면, 중력이 작용한다고 생각하고 `Puyo`들을 떨어트려준다.
6. 위의 과정을 연쇄가 일어나지 않을 때까지 수행한 후 연쇄가 발생한 횟수를 출력한다.

### 소스코드
```java
package com.algorithm.baekjoon;

import java.io.*;
import java.util.*;

public class BOJ11559 {
    static boolean flag;
    static char[][] grid;
    static List<Puyo> list;
    static Stack<Character> s;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static class Puyo {
        int x;
        int y;
        Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static boolean check(int nx, int ny, char type) {
        return nx>=0 && nx<12 && ny>=0 && ny<6 && grid[nx][ny]==type && !visited[nx][ny];
    }
    static void bfs(int x, int y) {
        Queue<Puyo> q = new LinkedList<>();
        list.add(new Puyo(x, y));
        q.offer(new Puyo(x, y));
        visited[x][y] = true;
        while(!q.isEmpty()) {
            Puyo puyo = q.poll();
            for(int i=0; i<4; i++) {
                int nx = puyo.x + dx[i];
                int ny = puyo.y + dy[i];
                if(check(nx, ny, grid[puyo.x][puyo.y])) {
                    list.add(new Puyo(nx, ny));
                    q.offer(new Puyo(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        if(list.size()>3) flag = true;
        else list.clear();
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            grid = new char[12][6];
            visited = new boolean[12][6];
            list = new ArrayList<>();
            s = new Stack<>();

            for(int i=0; i<12; i++) {
                char[] chars = br.readLine().toCharArray();
                for(int j=0; j<6; j++) {
                    grid[i][j] = chars[j];
                }
            }

            int chain = 0;
            do {
                // 연쇄가 일어나는 뿌요 찾기
                for(int i=0; i<12; i++) {
                    for(int j=0; j<6; j++) {
                        if(grid[i][j]!='.' && !visited[i][j]) {
                            bfs(i, j);
                            // 연쇄로 없어진 뿌요 제거하기
                            for(Puyo puyo : list)
                                grid[puyo.x][puyo.y] = '.';
                            list.clear();
                        }
                    }
                }
                // 뿌요들을 빈 공간으로 떨어트리기
                for(int j=0; j<6; j++) {
                    for(int i=0; i<12; i++) {
                        if(grid[i][j]!='.') s.push(grid[i][j]);
                        grid[i][j] = '.';
                    }
                    for(int i=11; i>=0; i--) {
                        if(s.isEmpty()) break;
                        grid[i][j] = s.pop();
                    }
                }
                // 방문 배열 초기화
                for(boolean[] item : visited) {
                    Arrays.fill(item, false);
                }
                if(!flag) break;
                else chain++;
                flag = false;
                list.clear();
            } while(chain>0);
            bw.write(chain+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```