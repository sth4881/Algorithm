## 백준 1149번 RGB거리 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1149

### 알고리즘
1. 모든 집들을 색칠하기 위한 최소 비용을 구하기 위해서 `i`번째 집을 붉은색, 초록색, 파란색으로 칠하는 최소 비용을 각각 구해야 한다.
2. 예를 들어 `i`번째 집을 붉은색으로 칠하기 위한 최소 비용을 구하려면, `i-1`번째 집을 초록색으로 칠하기 위한 비용과 `i-1`번째 집을 파란색으로 칠하기 위한 비용을 비교해서 최소값을 구하고 `i`번째 집을 칠하기 위한 비용을 더해줘야 한다.
3. 마찬가지로 `i`번째 집을 초록색으로 칠하기 위한 최소 비용과 파란색으로 칠하기 위한 최소 비용을 위의 예시를 통해서 각각 구해줄 수 있다.
4. 여기서 `i+1`번째 집은 `i`번째 집을 어떤 색으로 칠하는지에 따라서 바뀔 수 있기 때문에 고려하지 않는다.
5. 위의 과정을 첫번째 집부터 `N`번째 집까지 반복한 후에 `N`번째 집을 붉은색, 초록색, 파란색으로 칠하기 위한 최소 비용을 비교해서 가장 작은 값을 구해주면 된다.

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N+1][3];
            for(int i=1; i<=N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N+1][3];
            for(int i=0; i<3; i++) {
                dp[1][i] = arr[1][i];
            }
            for(int i=2; i<=N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            bw.write(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2])+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```