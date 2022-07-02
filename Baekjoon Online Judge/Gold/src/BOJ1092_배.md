## 백준 1092번 배 (골드 5)
### 문제링크
- https://www.acmicpc.net/problem/1092

### 알고리즘
1. 입력받은 크레인들을 무게 제한이 큰 순으로 정렬하고, 박스들을 무게가 큰 순으로 정렬한다.
2. 불필요한 시간 소모를 줄이기 위해서 가장 무게가 적게 나가는 박스보다 무게 제한이 낮은 크레인을 전부 제거한다.
3. 각 박스에 대해서 크레인으로 옮길 수 있으면 해당 박스를 `boxes`에서 제거하고 다음 크레인으로 다음 박스를 옮길 수 있는지 확인한다.
4. 만약에 크레인으로 옮길 수 없다면 `idx`를 증가시켜서 다음 박스를 옮길 수 있는지 확인한다.
5. `for`문을 한번 돌 때마다 사용하지 못하는 크레인을 제거하고, `cnt`를 1씩 증가시킨다.
6. 위의 과정을 더이상 옮길 박스가 없을 때까지 반복하고 `cnt`를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.*;

public class BOJ1092 {
    static int N, M; // N : 크레인 개수, M : 박스 개수
    static List<Integer> cranes, boxes;
    // 가장 무게가 적게 나가는 박스보다 무게 제한이 낮은 크레인 전부 제거
    static void removeCrane() {
        while(!boxes.isEmpty() && cranes.get(cranes.size()-1) < boxes.get(boxes.size()-1)) {
            cranes.remove(cranes.size()-1);
            if(cranes.isEmpty()) break;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            cranes = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                cranes.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            boxes = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                boxes.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(cranes, Collections.reverseOrder());
            Collections.sort(boxes, Collections.reverseOrder());
            removeCrane();

            // 박스를 옮길 수 있는 크레인이 없는 경우 -1 출력
            if(cranes.isEmpty() || cranes.get(0) < boxes.get(0)) bw.write(-1+"\n");
            else {
                int cnt = 0;
                while(!boxes.isEmpty()) {
                    int idx = 0;
                    for(int i=0; i<cranes.size();) {
                        // 박스가 비었으면 반복문 탈출
                        if(idx==boxes.size()) break;
                        // i번째 크레인이 idx번째 박스를 들지 못하면 다른 크레인도 들지 못하므로 다음 박스로 넘어감
                        if(cranes.get(i) < boxes.get(idx)) idx++;
                            // i번째 크레인이 idx번째 박스를 들 수 있다면 i를 증가시키고 idx번째 박스를 리스트에서 제거
                        else {
                            boxes.remove(idx);
                            i++;
                        }
                    }
                    removeCrane();
                    cnt++; // 한번 반복할 때마다 옮기는 시간을 1씩 증가
                }
                bw.write(cnt+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```