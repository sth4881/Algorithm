## 백준 1260번 DFS와 BFS (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1260

### 알고리즘
1. DFS로 탐색한 결과와 BFS로 탐색한 결과를 저장하기 위해서 `dfsAnswer`, `bfsAnswer`를 각각 만들어준다.
2. 방문할 정점이 여러 개인 경우에 값이 작은 정점을 먼저 방문해줘야 하므로 관계들을 `list`로 입력받은 후에 각각을 오름차순으로 정렬시켜준다.
3. DFS, BFS를 통해서 도출된 결과들을 각각 `dfsAnswer`, `bfsAnswer`에 넣어주고 탐색이 모두 끝나면 한번에 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ1260 {
    static int N, M;
    static boolean[] visited;
    static List<Integer> dfsAnswer;
    static List<Integer> bfsAnswer;
    static List<List<Integer>> list;
    static void dfs(int cur) {
        dfsAnswer.add(cur);
        visited[cur] = true;
        for(int i=0; i<list.get(cur).size(); i++) {
            int adj = list.get(cur).get(i);
            if(!visited[adj]) dfs(adj);
        }
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            int cur = q.poll();
            bfsAnswer.add(cur);
            for(int i=0; i<list.get(cur).size(); i++) {
                int adj = list.get(cur).get(i);
                if(visited[adj]) continue;
                visited[adj] = true;
                q.offer(adj);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i=0; i<=N; i++) {
                list.add(new ArrayList<>());
            }

            dfsAnswer = new ArrayList<>();
            bfsAnswer = new ArrayList<>();

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            // 오름차순 정렬
            for(List<Integer> item : list) {
                Collections.sort(item);
            }

            visited = new boolean[N+1];
            dfs(v);
            Arrays.fill(visited, false);
            bfs(v);

            for(int item : dfsAnswer)
                bw.write(item + " ");
            bw.write("\n");
            for(int item : bfsAnswer)
                bw.write(item + " ");
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
```