## 백준 1263번 시간 관리 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1263

### 알고리즘
1. 마감시간이 빠른 일의 순서로 리스트를 정렬한다.
2. 일을 하는데 소요되는 시간을 `sum`에 더해서 합을 구한다.
3. 해당 일에 대한 마감시간에서 `sum` 값을 뺀 값과 `min`을 비교해서 값이 더 작으면 `min`을 갱신한다.
4. 위의 과정을 모든 일에 대해서 반복한 후에 `min`을 출력한다.
5. 만약에 `min`이 음수라면 -1을 출력한다. 

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1263 {
    static class Task {
        int time;
        int deadline;
        Task(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            List<Task> list = new ArrayList<>();
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Task(a, b));
            }

            // 마감시간을 기준으로 정렬
            list.sort((o1, o2) -> o1.deadline - o2.deadline);

            int sum = list.get(0).time; // 일을 하는데 소요되는 시간의 합
            int min = list.get(0).deadline - sum; // 일을 가장 늦게 시작할 수 있는 시간
            for(int i=1; i<list.size(); i++) {
                sum += list.get(i).time;
                min = Math.min(min, list.get(i).deadline-sum);
            }

            if(min < -1) bw.write(-1+"\n");
            else bw.write(min+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```