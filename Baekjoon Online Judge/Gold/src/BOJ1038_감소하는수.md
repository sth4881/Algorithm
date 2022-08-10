## 백준 1038번 감소하는 수 (골드 5)
### 문제링크
- https://www.acmicpc.net/problem/1038

### 알고리즘
1. `N`번째 감소하는 수를 구하는 문제이다. 즉, `N`번째 내림차순 수를 구하면 된다.
2. 가장 큰 감소하는 수 `9876543210`가 몇 번째 감소하는 수인지 알아보기 위해 0부터 4로 시작하는 감소하는 수가 몇 개씩 나오는지 적어보자.
3. 직접 적어보면 0일 때는 `1`개, 1일 때는 `2`개, 2일 때는 `4`개, 3일 때는 `8`개, 4일 때는 `16`개로 각각 `2^N`개의 감소하는 수가 구해짐을 알 수 있다.
4. 또한, `N`으로 시작하는 감소하는 수의 개수는 `2^0 + ... + 2^(N-1)`개이므로, 가장 큰 감소하는 수는 `1022`번째 감소하는 수임을 알 수 있다.
5. 따라서 `N`이 `1022`를 넘기는 감소하는 수는 존재하지 않음을 알 수 있고, `1023`보다 작은 `N`번째 감소하는 수는 재귀와 백트래킹을 통해 도출한다.
6. 각 자릿수별로 감소하는 수를 구해서 각각 리스트에 저장해준 후에 모든 감소하는 수를 도출하면 `N`번째 감소하는 수를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ1038 {
    static int N;
    static int[] arr;
    static List<String> list;
    static void recursive(int depth, int limit) {
        if(depth==limit) { // depth와 limit이 같아질 때마다
            StringBuilder str = new StringBuilder();
            for(int i=0; i<limit; i++)
                str.append(arr[i]); // 감소하는 수를 구하기 위해 배열의 원소들을 순서대로 이어서 하나의 문자열로 변환
            list.add(str.toString()); // 문자열로 변환된 감소하는 수를 리스트에 대입
            return;
        }
        for(int i=0; i<10; i++) {
            if(depth==0 || (arr[depth-1]>i)) { // 현재 0번째 단계이거나 i값이 이전 단계의 숫자보다 감소한 경우
                arr[depth] = i; // 감소하는 수를 구하기 위해 현재 단계에 i를 대입
                recursive(depth+1, limit); // 다음 단계의 재귀를 수행
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            arr = new int[11];

            if(N>1022) bw.write(-1+"\n");
            else {
                for(int i=1; i<=11; i++)
                    recursive(0, i); // 자릿수별로 감소하는 수를 구하기 위한 완전탐색
                bw.write(list.get(N)+"\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```