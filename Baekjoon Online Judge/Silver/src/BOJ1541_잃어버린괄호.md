## 백준 1541번 잃어버린 괄호 (실버 2)
### 문제링크
- https://www.acmicpc.net/problem/1541

### 알고리즘
1. 입력받은 문자열을 '-' 기준으로 잘라서 배열에 저장한다.
2. 식에서 첫번째 원소는 숫자와 '+'로 구성된 식이므로 '+'를 기준으로 잘라서 만들어진 원소(`item`)들을 `answer`에 각각 더해준다.
3. 다른 원소들도 첫번째 원소처럼 '+'를 기준으로 잘라서 만들어진 원소(`item`)들을 `sum`에 각각 더해준다.
4. `input`에 저장된 원소들은 첫번째 원소를 제외하고 전부 음수이기 때문에 `answer`에서 `sum`을 빼준다.
5. 위의 과정을 `input`의 모든 원소에 대해서 수행한 후에 `answer`를 출력한다.

### 소스코드
```java
import java.io.*;

public class BOJ1541 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] input = br.readLine().split("-"); // ex) 55-50+40-60+20-30 = 55, 50+40, 60+20, 30
            int answer = 0;
            for(String item : input[0].split("\\+")) {
                answer += Integer.parseInt(item); // input의 첫번째 원소는 '+'를 기준으로 전부 잘라서 더하기
            }
            for(int i=1; i<input.length; i++) {
                int sum = 0;
                String[] str = input[i].split("\\+");
                for(String item : str)
                    sum += Integer.parseInt(item); // input의 두번째 원소부터는 '+'를 기준으로 전부 잘라서 더해준 sum 구하기
                answer -= sum; // input 각각의 원소에 대해 도출한 sum 값을 answer에서 빼기
            }

            bw.write(answer+"\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```