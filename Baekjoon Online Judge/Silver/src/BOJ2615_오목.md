## 백준 2615번 오목 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/2615

### 알고리즘
1. 바둑판을 보고 오목의 결과를 출력하는 문제이다.
2. 바둑반의 모든 위치를 탐색해야 하므로 브루트 포스를 사용하며, 위치에 돌이 있는 경우에만 탐색을 진행한다.
3. 또한, 오목을 이긴 색깔의 가장 왼쪽(열이 같으면 가장 위쪽) 돌을 출력해야 하므로 편의상 `우상(-1, 1)`, `우(0, 1)`, `우하(1, 1)`, `하(1, 0)` 4방향만 탐색한다.
4. 각 방향에 대해 정방향으로 탐색해서 색깔이 같은 돌을 찾으면 정방향 탐색 개수를 증가시킨다.
5. 정방향 탐색이 끝나면 해당 방향의 역방향으로 탐색해서 색깔이 같은 돌을 찾으면 역방향 탐색 개수를 증가시킨다.
6. 만약에 정방향 탐색을 통해 탐색을 시작한 돌을 포함해서 같은 돌을 5개 찾았고, 역방향 탐색을 통해 돌을 찾지 못했다면 탐색을 시작한 돌의 `색깔(1, 2)`과 `위치`를 출력하면 된다.
7. 모든 바둑판의 위치를 탐색했음에도 오목을 만족하는 경우가 없다면 `0`을 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ2615 {
    static int[][] grid;
    static int[] dx = { -1, 0, 1, 1 };
    static int[] dy = { 1, 1, 1, 0 };
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<19 && ny>=0 && ny<19;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            grid = new int[19][19];

            for(int i=0; i<19; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<19; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int x=0; x<19; x++) {
                for(int y=0; y<19; y++) {
                    if(grid[x][y]==0) continue;
                    for(int i=0; i<4; i++) {
                        // 정방향 탐색
                        int forward = 1;
                        int nx = x;
                        int ny = y;
                        while(true) {
                            nx += dx[i];
                            ny += dy[i];
                            if(check(nx, ny) && grid[x][y]==grid[nx][ny]) forward++;
                            else break;
                        }
                        // 역방향 탐색
                        int backward = 0;
                        nx = x;
                        ny = y;
                        while(true) {
                            nx -= dx[i];
                            ny -= dy[i];
                            if(check(nx, ny) && grid[x][y]==grid[nx][ny]) backward++;
                            else break;
                        }
                        // 오목을 만족하는지 확인
                        if(forward==5 && backward==0) {
                            bw.write(grid[x][y]+"\n");
                            bw.write((x+1)+" "+(y+1)+"\n");
                            bw.close();
                            return;
                        }
                    }
                }
            }

            bw.write(0+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```