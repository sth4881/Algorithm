## 백준 2174번 로봇 시뮬레이션 (골드 5)
### 문제링크
- https://www.acmicpc.net/problem/2174

### 알고리즘
1. 로봇의 위치와 방향을 입력받고, 명령들을 입력받아서 시뮬레이션한 결과를 구하는 문제이다.
2. 각 명령을 수행할 때마다 로봇의 회전 또는 이동에 따라서 상태를 갱신해주는 과정을 반복한다.
3. 명령을 수행 중에 벽에 부딪히거나 다른 로봇에 부딪히면 그에 대한 예외를 처리해주고, 그렇지 않으면 모든 명령을 수행 후에 `OK`를 출력한다.

### 소스코드
```java
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2174 {
    static int A, B, N, M, dir;
    static int[][] grid;
    static List<Robot> list;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static class Robot {
        int x;
        int y;
        int d;
        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static boolean check(int nx, int ny) {
        return nx>=0 && nx<B && ny>=0 && ny<A;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            grid = new int[B][A];

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list.add(new Robot(0, 0, 'N'));
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken())-1;
                int row = Integer.parseInt(st.nextToken())-1;
                switch(st.nextToken().charAt(0)) {
                    case 'N':
                        dir = 2;
                        break;
                    case 'E':
                        dir = 1;
                        break;
                    case 'S':
                        dir = 0;
                        break;
                    case 'W':
                        dir = 3;
                        break;
                }
                list.add(new Robot(row, col, dir));
                grid[row][col] = i;
            }

            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                char command = st.nextToken().charAt(0);
                int cnt = Integer.parseInt(st.nextToken());
                for(int j=0; j<cnt; j++) {
                    Robot robot = list.get(idx);
                    switch(command) {
                        case 'L': // 오른쪽으로 1번 회전
                            list.set(idx, new Robot(robot.x, robot.y, (robot.d+1)%4)); // 로봇이 바라보고 있는 방향 수정
                            break;
                        case 'R': // 왼쪽으로 1번 회전
                            list.set(idx, new Robot(robot.x, robot.y, (robot.d+3)%4)); // 로봇이 바라보고 있는 방향 수정
                            break;
                        case 'F': // 현재 보고있는 방향으로 1칸 이동
                            int nx = robot.x + dx[robot.d];
                            int ny = robot.y + dy[robot.d];
                            if(!check(nx, ny)) { // 벽에 부딪힌 경우 예외처리
                                bw.write("Robot "+idx+" crashes into the wall"+"\n");
                                bw.close();
                                return;
                            }
                            if(grid[nx][ny]!=0) { // 다른 로봇과 부딪힌 경우 예외처리
                                bw.write("Robot "+idx+" crashes into robot "+grid[nx][ny]+"\n");
                                bw.close();
                                return;
                            }
                            list.set(idx, new Robot(nx, ny, robot.d)); // 로봇의 위치 수정
                            grid[robot.x][robot.y] = 0;
                            grid[nx][ny] = idx;
                            break;
                    }
                }
            }

            bw.write("OK\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```