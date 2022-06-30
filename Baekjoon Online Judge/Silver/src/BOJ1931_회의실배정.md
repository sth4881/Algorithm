## 백준 1931번 회의실 배정 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1931

### 알고리즘
1. 리스트에 포함된 회의들을 종료시간이 빠른 순서로 정렬하되, 종료시간이 같다면 시작시간이 빠른 순서로 정렬한다.
2. 회의는 하나 이상 있으므로 `cnt`를 1, `finishTime`을 첫번째 회의의 종료시간으로 초기화한다.
3. 다음 회의의 시작시간이 `finishTime` 보다 늦으면 `finishTime`을 해당 회의의 종료시간으로 갱신하고 `answer`를 1 증가시킨다.
4. 모든 회의에 대해서 위의 과정을 반복하고 `answer`를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ1931 {
    static int N;
    static class Task {
        int start;
        int finish;
        Task(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());

            List<Task> list = new ArrayList<>(); // 회의 목록
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Task(a, b));
            }

            // 종료시간이 빠른 순서로 정렬 & 종료시간이 같으면 시작시간이 빠른 순서로 정렬
            list.sort((o1, o2) -> {
                if(o1.finish == o2.finish)
                     return o1.start - o2.start;
                return o1.finish - o2.finish;
            });

            int answer = 1;
            int finishTime = list.get(0).finish;
            for(int i=1; i<list.size(); i++) {
                if(finishTime <= list.get(i).start) {
                    finishTime = list.get(i).finish;
                    answer++;
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