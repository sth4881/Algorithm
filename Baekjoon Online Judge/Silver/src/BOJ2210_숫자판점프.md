## 백준 2210번 숫자판 점프 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/2210

### 알고리즘
1. 가능한 경우의 수를 찾는 문제이므로 정답 출력용 집합을 만들어준다.
2. 각 위치에 대한 값이 모두 다를 수도 있고 이전에 방문한 위치를 재방문할 수 있으므로 전체에 대해서 DFS를 시작한다.
3. 6자리 숫자를 만들어야하므로 다음 DFS를 수행할 때마다 `nextVal`을 통해서 값을 갱신하고 `depth+1`을 통해서 자릿수를 갱신한다.
4. `depth`가 6이 되면 `answer`에 값을 추가하고 반환한다.
5. 모든 위치에 대해서 위의 과정을 반복한 후에 `answer`의 크기를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ2210 {
    static int[][] grid;
    static Set<String> answer;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<5 && ny>=0 && ny<5;
    }
    static void dfs(int x, int y, String val, int depth) {
        if(depth==6) {
            answer.add(val);
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(check(nx, ny)) {
                String nextVal = val + grid[nx][ny];
                dfs(nx, ny, nextVal, depth+1);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            grid = new int[5][5];
            for(int i=0; i<5; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<5; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = new HashSet<>();
            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    dfs(i, j, Integer.toString(grid[i][j]), 1);
                }
            }

            bw.write(answer.size()+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```