## 백준 1080번 행렬 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1080

### 알고리즘
1. `N` 또는 `M`이 3보다 작으면 `compare()`를 통해서 0 또는 -1을 출력한다.
2. 각각의 `i`와 `j`에 대해 `flip(i, j)`로 3x3 크기의 격자에 포함된 원소들의 값을 0에서 1로, 1에서 0으로 변환한다.
3. `flip(i, j)`를 성공할 때마다 `cnt`를 1씩 증가시킨다.
4. 모든 `i`와 `j`에 대해서 위의 과정을 반복한 후에 `compare()`가 출력하는 값에 따라서 `cnt` 또는 -1을 출력한다. 

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1080 {
    static int N, M;
    static int[][] grid, target;
    static boolean check(int x, int y) {
        return x+2<N && y+2<M && grid[x][y]!=target[x][y];
    }
    // 3x3 크기의 격자에 포함된 원소들의 값을 0에서 1로, 1에서 0으로 변환
    static boolean flip(int x, int y) {
        if(!check(x, y)) return false;
        for(int i=x; i<=x+2; i++) {
            for(int j=y; j<=y+2; j++) {
                if(grid[i][j]==0) grid[i][j] = 1;
                else grid[i][j] = 0;
            }
        }
        return true;
    }
    // grid[i][j]와 target=[i][j]의 값이 일치하는지 비교
    static boolean compare() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(grid[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][M];
            for(int i=0; i<N; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<M; j++) {
                    grid[i][j] = Integer.parseInt(str[j]);
                }
            }
            target = new int[N][M];
            for(int i=0; i<N; i++) {
                String[] str = br.readLine().split("");
                for(int j=0; j<M; j++) {
                    target[i][j] = Integer.parseInt(str[j]);
                }
            }

            // N 또는 M이 3보다 작으면
            if(N<3 || M<3) {
                // grid와 target이 일치하면 바꿀 필요가 없으므로 0
                if(compare()) bw.write(0+"\n");
                // 그렇지 않으면 -1
                else bw.write(-1+"\n");
            } else {
                int cnt = 0;
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        if(flip(i, j)) cnt++;
                    }
                }
                if(compare()) bw.write(cnt+"\n");
                else bw.write(-1+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```