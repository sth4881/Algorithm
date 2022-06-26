## 백준 2644번 촌수계산 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/2644

### 알고리즘
1. BFS를 할 때마다 특정 번호의 촌수를 계산하기 위해서 `Node` 클래스를 선언한다.
2. 먼저 주어지는 사람의 번호를 `src`, 나중에 주어지는 번호를 `dsc`라고 정의한다.
3. 주어진 값들을 입력받을 때 아직 촌수를 알 수 없기 때문에 각 번호에 대한 촌수를 0으로 초기화한다.
4. BFS로 `dst`를 찾을 때까지 각각의 `Node`를 탐색하면서 `cur.degree`를 1씩 더하는 방식으로 번호들의 촌수를 초기화한다.
5. 큐에서 꺼낸 `Node`의 번호가 `dst`와 같으면 `cur.degree`를 반환한다.
6. 만약에 모든 `Node`를 탐색할 때까지 `dst`를 찾지 못하면 -1을 반환한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ2644 {
    static int N, M;
    static boolean[] visited;
    static List<List<Node>> list;
    static class Node {
        int idx; // 번호
        int degree; // 촌수
        Node(int idx, int degree) {
            this.idx = idx;
            this.degree = degree;
        }
    }
    static int bfs(int src, int dst) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(src, 0));
        visited[src] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.idx == dst) return cur.degree;
            for(int i=0; i<list.get(cur.idx).size(); i++) {
                Node adj = list.get(cur.idx).get(i);
                if(!visited[adj.idx]) {
                    q.offer(new Node(adj.idx, cur.degree+1));
                    visited[adj.idx] = true;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(br.readLine());

            visited = new boolean[N+1];
            list = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
            }

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(new Node(b, 0));
                list.get(b).add(new Node(a, 0));
            }

            bw.write(bfs(src, dst)+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```