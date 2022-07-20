## 백준 22858번 원상 복구 (small) (실버 3)
### 문제링크
- https://www.acmicpc.net/problem/22858

### 알고리즘
1. `D(i)`를 `K`번 수행해서 도출한 결과 `S(i)`에 `D`의 반대 작업을 `K`번 수행해서 원본 배열 `P(i)`를 도출하는 문제이다.
2. `D(i)`는 `i`번째 원소에 `P(i)`를 대입한다는 뜻이므로, `D(i)`의 반대는 `i`번째 원소에 `S(i)`를 대입한다는 뜻임을 알 수 있다.
3. 위의 과정을 `K`번 만큼 수행한 결과가 구하고자 하는 `P(i)`가 된다.

### 소스코드
```java
package com.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ22858 {
    static int N, K;
    static int[] S, D, arr;
    // 다음 변환 작업을 수행하기 위해서 arr 내용을 S에 복사하는 메소드
    static void migration() {
        for(int i=1; i<=N; i++) {
            S[i] = arr[i];
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            S = new int[N+1];
            D = new int[N+1];
            arr = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            // K번 만큼 반복
            for(int i=0; i<K; i++) {
                // 1번부터 N번까지 변환 작업 수행
                for(int j=1; j<=N; j++)
                    arr[D[j]] = S[j];
                migration();
            }

            for(int i=1; i<=N; i++)
                bw.write(arr[i]+" ");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```