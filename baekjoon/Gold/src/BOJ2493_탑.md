## 백준 2493번 탑 (골드 5)
### 문제링크
- https://www.acmicpc.net/problem/2493

### 알고리즘
1. 탑이 송신한 레이저를 수신하는 탑의 번호를 찾는 문제이다.
2. 레이저는 탑의 번호보다 작은 번호의 탑으로 송신되며, 레이저를 수신하려는 탑은 레이저를 송신한 탑의 높이보다 무조건 커야 한다.
3. 수신하는 탑의 번호를 찾기 위해 스택을 확인하여 현재 탑보다 높이가 작은 탑들은 전부 제거한다.
4. 탑들을 모두 제거한 후에 스택이 비어있다면 현재 탑의 레이저를 수신할 수 있는 탑이 없다는 뜻이므로 답을 0으로 설정한다.
5. 만약에 스택이 비어있지 않다면 스택의 맨 위에 있는 탑의 번호를 답으로 설정한다.
6. 현재 탑의 번호와 높이를 클래스로 묶어서 스택에 넣고 위의 과정을 모든 탑에 대해 반복하면 된다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {
    static int N;
    static int[] arr;
    static Stack<Tower> s;
    static List<Integer> answer;
    static class Tower {
        int idx;
        int height;
        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];

            s = new Stack<>();
            answer = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=N; i++) {
                while(!s.isEmpty() && s.peek().height<=arr[i]) {
                    s.pop();
                }
                if(s.isEmpty()) answer.add(0);
                else answer.add(s.peek().idx);
                s.push(new Tower(i, arr[i]));
            }

            for(int item : answer)
                bw.write(item+" ");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```