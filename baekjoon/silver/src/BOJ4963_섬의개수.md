## 백준 4963번 섬의 개수 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/4963

### 알고리즘
1. 입력에 의해 프로그램의 종료가 결정되므로 `while(true)` 안에서 값을 입력받고 검사한다.
2. 값이 유효하다면 각각의 위치에 대해서 값이 1이고 방문하지 않았는지 확인하고 DFS를 시작한다.
3. 각 위치에 대해서 DFS를 수행한 이후에 `cnt`를 1씩 증가시키고 테스트케이스가 끝날 때마다 `answer`에 `cnt`를 추가한다.
4. 1번에서 검사한 값이 유효하지 않으면 반복문을 탈출하고 `answer`에 포함된 값들을 순서대로 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4963 {
    static int W, H;
    static int[][] grid;
    static boolean[][] visited;
    static List<Integer> answer;
    static int[] dx = { -1, 0, 1, 0, -1, 1, -1, 1 };
    static int[] dy = { 0, 1, 0, -1, 1, -1, -1, 1 };
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<H && ny>=0 && ny<W && grid[nx][ny]==1 && !visited[nx][ny];
    }
    static void dfs(int x, int y) {
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            answer = new ArrayList<>();
            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                W = Integer.parseInt(st.nextToken());
                H = Integer.parseInt(st.nextToken());

                if(W==0 && H==0) break;

                visited = new boolean[H][W];

                grid = new int[H][W];
                for(int i=0; i<H; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j=0; j<W; j++) {
                        grid[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                int cnt = 0;
                for(int i=0; i<H; i++) {
                    for(int j=0; j<W; j++) {
                        if(grid[i][j]==1 && !visited[i][j]) {
                            visited[i][j] = true;
                            dfs(i, j);
                            cnt++;
                        }
                    }
                }
                answer.add(cnt);
            }

            for(int item : answer)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```