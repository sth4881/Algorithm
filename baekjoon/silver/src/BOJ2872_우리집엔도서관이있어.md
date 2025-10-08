## 백준 2872번 우리집엔 도서관이 있어 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/2872

### 알고리즘
1. 몇 권의 책을 옮겨서 순서대로 책을 정렬할 수 있는지 구하는 문제이다.
2. 반대로 몇 권의 책을 옮기지 않아도 되는지 구하면 더 쉽게 풀 수 있는 문제이다.
3. 번호가 가장 큰 책의 위치에서부터 번호가 가장 작은 책의 위치까지 번호가 하나씩 작은 책의 개수를 구한다.
4. 책의 전체 개수에서 번호가 하나씩 작은 책의 개수를 뺀 값을 출력한다.

### 소스코드
```java
import java.io.*;

public class BOJ2872 {
    static int N;
    static int[] books;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            N = Integer.parseInt(br.readLine());
            books = new int[N];

            int idx = -1;
            for(int i=0; i<N; i++) {
                books[i] = Integer.parseInt(br.readLine());
                if(books[i]==N) idx = i;
            }

            int cnt = 1;
            for(int i=idx-1; i>=0; i--) {
                if(books[idx]-1 == books[i]) {
                    idx = i;
                    cnt++;
                }
            }

            bw.write((N-cnt)+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```