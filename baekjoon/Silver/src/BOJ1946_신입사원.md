## 백준 1946번 신입 사원 (실버 1)
### 문제링크
- https://www.acmicpc.net/problem/1946

### 알고리즘
1. 입력받은 지원자 리스트를 서류면접 성적순으로 정렬한다.
2. 1명 이상 합격하기 때문에 `cnt`를 1, `criteria`를 서류면접 성적이 가장 우수한 지원자로 초기화한다.
3. `criteria`의 면접 성적과 서류면접 성적이 다음으로 좋은 지원자의 면접 성적을 비교해서 
후자의 성적이 더 좋으면 후자로 `criteria`를 갱신하고 `cnt`를 1 증가시킨다.
4. 위의 과정을 모든 면접자에 대해서 수행한 후에 `answer`에 `cnt` 값을 추가한다.
5. `list`를 초기화하고 각각의 테스트 케이스를 수행한 후에 `answer`에 포함된 값들을 각각 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1946 {
    static class Applicant {
        int document;
        int interview;
        Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            List<Applicant> list = new ArrayList<>(); // 지원자 리스트
            List<Integer> answer = new ArrayList<>(); // 테스트 케이스당 합격한 지원자의 수

            int T = Integer.parseInt(br.readLine());
            for(int t=0; t<T; t++) {
                int n = Integer.parseInt(br.readLine());
                for(int i=0; i<n; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    list.add(new Applicant(a, b));
                }

                // 서류면접 성적순으로 정렬
                list.sort((o1, o2) -> o1.document - o2.document);

                int cnt = 1; // 합격한 지원자 수
                Applicant criteria = list.get(0); // 서류면접 성적이 가장 우수한 지원자를 기준으로 설정
                for(int i=1; i<list.size(); i++) {
                    if(criteria.interview > list.get(i).interview) {
                        criteria = list.get(i);
                        cnt++;
                    }
                }
                answer.add(cnt);
                list.clear();
            }

            for(int item : answer)
                bw.write(item+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```