## 백준 1912번 연산자 끼워넣기 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1912

### 알고리즘
1. 주어진 수열에서 값이 가장 큰 연속합을 구하는 문제이다.
2. `i`번째 원소까지의 연속합을 찾는 방식은 적용이 어렵기 때문에 `i`번째 원소를 각각 더해주되 `i-1`번째 원소까지의 연속합을 가지고 갈지 말지를 판단하는 방식을 사용한다.
3. 위의 과정을 0번째 원소부터 `i-1`번째 원소까지 반복하면서 연속합을 비교하는 방식으로 `max` 값을 갱신시켜준다.

### 소스코드
```java
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1912 {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new int[N];
            dp[0] = arr[0];

            int max = dp[0];
            for(int i=1; i<N; i++) {
                dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
                max = Math.max(max, dp[i]);
            }

            bw.write(max+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```