## 백준 2146번 다리 만들기 (골드 4)
### 문제링크
- https://www.acmicpc.net/problem/2146

### 알고리즘
1. 하나의 섬과 다른 섬을 이어줄 수 있는 가장 짧은 다리를 구하는 문제이다.
2. 다리를 이어주기 편하게 만들기 위해 섬마다 번호를 붙여줘서 구별할 수 있도록 한다.
3. 섬의 끝에서 시작해서 다른 섬을 발견할 때까지 BFS를 수행하고, 섬의 끝에 도달하면 최단거리를 갱신하고 다음 BFS를 진행하는 방식으로 반복한다.

### 소스코드
```java
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2146 {
    static int N, answer;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static class Node {
        int x;
        int y;
        int time;
        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny];
    }
    static void numberAreas(int x, int y, int type) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        visited[x][y] = true;
        grid[x][y] = type;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(check(nx, ny) && grid[nx][ny]==1) {
                    q.offer(new Node(nx, ny, 0));
                    visited[nx][ny] = true;
                    grid[nx][ny] = type;
                }
            }
        }
    }
    static void buildBridge(int x, int y, int type) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0));
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i=0; i<4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(check(nx, ny)) {
                    if(grid[nx][ny]==0) {
                        q.offer(new Node(nx, ny, node.time+1));
                        visited[nx][ny] = true;
                    }
                    else if(grid[nx][ny]!=type) {
                        answer = Math.min(answer, node.time);
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            grid = new int[N][N];

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int type = 1;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(grid[i][j]==1 && !visited[i][j]) {
                        numberAreas(i, j, type);
                        type++;
                    }
                }
            }

            answer = Integer.MAX_VALUE;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(grid[i][j]>0) {
                        for(boolean[] item : visited)
                            Arrays.fill(item, false);
                        buildBridge(i, j, grid[i][j]);
                    }
                }
            }

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```