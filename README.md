# Algorithm

![Java](https://img.shields.io/badge/Java-orange?logo=Java)

## 📅 2020.11.2.
### Divide & Conquer
- MergeSort.java
### Dynamic Programming
- Fibonacci.java : 재귀식을 사용하지 않은 피보나치 수열
- Combination.java : 이항계수 : n개 중에서 k개를 뽑는 경우의 수
- ShortestPath.java : 최단거리로 mxn의 격자를 이동하는 경우의 수
- SumOfN.java : 양의 정수 n을 1부터 n의 합으로 표현하는 방법의 수
- SumOfN2.java : 양의 정수 n을 1부터 k의 합으로 표현하는 방법의 수
- SumOfN3.java : 양의 정수 n을 1부터 k의 합으로 표현할 때, 더해지는 숫자들의 순서를 고려하지 않고 표현하는 방법의 수
- Coin.java : 동전의 단위가 n개 있고 동전은 무한히 존재할 때, 거스름돈 m을 거슬러주는 방법의 수
### Baekjoon Online Judge
- BOJ10818.java : 최대힙, 최소힙을 이용해서 최대값, 최소값 찾기

## 📅 2020.11.4.
### Dynamic Programming
- Stairs1.java : n개의 계단을 오를 때 한 번에 1개 혹은 3개의 계단만 사용해서 올라가는 경우의 수
- Stairs2.java : n개의 계단을 오를 때 한 번에 오를 수 있는 계단의 단위가 s1, s2, s3, ... , sk로 총 k개의 존재할 경우, 이 계단들을 사용해서 올라가는 경우의 수

## 📅 2020.11.10.
### Dynamic Programming
- Grid2.java : 가장 아래 행의 셀로부터 '오른쪽 위쪽 대각선 방향' 혹은 '위쪽 방향' 혹은 '왼쪽 위쪽 대각선 방향'으로만 가면서 가장 위의 행의 셀까지 가는 경로의 최소 비용 구하기. 경로의 비용이란 지나가는 셀의 비용의 총합을 말한다.

## 📅 2020.11.12.
### Dynamic Programming
- Stairs3.java : n개의 계단을 오를 때 한 번에 오를 수 있는 계단의 단위가 s1, s2, s3, ... , sk로 총 k개의 존재한다고 하자. 이 계단들을 사용하되 밟는 계단 수가 최소가 되도록 하면서 올라가고자 할 때 최소 계단 수 구하기
### Baekjoon Online Judge - Dynamic Programming
- BOJ9461.java : [파도반 수열](https://www.acmicpc.net/problem/9461)

## 📅 2020.11.14.
### Baekjoon Online Judge - Dynamic Programming
- BOJ1149.java : [RGB거리](https://www.acmicpc.net/problem/1149)
- BOJ1932.java : [정수 삼각형](https://www.acmicpc.net/problem/1932)

## 📅 2020.11.18.
### Dynamic Programming
- Grid1.java : 셀 (1,1)에서 오른쪽 방향 혹은 위쪽 방향으로만 가면서 셀 (m-1, n-1) 까지 가는 경로의 최소 비용 구하기. 경로의 비용이란 지나가는 셀의 비용의 총합을 말한다.

## 📅 2020.11.19.
### Dynamic Programming
- HotelToAirport.java : [호텔에서 공항까지 가는데 걸리는 최소 시간](https://raw.githubusercontent.com/sth4881/Algorithm/main/dp/img/HotelToAirport.png)

## 📅 2020.11.29.
### Graph
- AdjList.java : ArrayList를 이용한 인접리스트 표현

## 📅 2020.12.3.
### Graph
- DFSList.java : ArrayList를 이용한 인접리스트로 DFS 구현

## 📅 2020.12.6.
### Graph
- BFSList.java : ArrayList를 이용한 인접리스트로 BFS 구현
- CountCell.java : [시작 셀로부터 도달 가능한 셀의 개수 구하기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/CountCell.png)
- FindArea.java : [미로에서 영역의 개수와 가장 큰 영역의 크기(0의 개수)를 구하기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/FindArea.png)
- MinMove.java : [시작 셀부터 모든 셀까지 마커를 옮기는데 필요한 최소 이동 횟수 구하기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/MinMove.png)

## 📅 2020.12.7.
### Graph
- MazeSearch.java : [미로에서 최단경로 찾기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/MazeSearch.png)
- FindComponent.java : [연결요소의 개수와 가장 큰 연결요소의 크기 구하기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/FindComponent.png)
- ShortestPath.java : [연결요소에서 최단경로의 길이 찾기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/ShortestPath.png)
- PrintPath.java : [연결요소에서 최단경로 출력하기](https://raw.githubusercontent.com/sth4881/Algorithm/main/graph/img/PrintPath.png)

## 📅 2020.12.10.
### Graph
- TopologicalIndegree.java : 진입분지수를 이용한 위상정렬 구현(그래프에 사이클이 만들어진 경우, 진입분지수를 이용한 위상정렬은 사용 불가능)
- TopologicalDFS.java : DFS를 이용한 위상정렬 구현

## 📅 2020.12.15.
### Graph
- Dijkstra.java : Dijkstra 알고리즘으로 최단경로 및 경로의 길이 출력하기

## 📅 2020.12.28.
### Baekjoon Online Judge - Dynamic Programming
- BOJ1003.java : [피보나치 함수](https://www.acmicpc.net/problem/1003)

## 📅 2020.12.30.
### Baekjoon Online Judge - Dynamic Programming
- BOJ2579.java : [계단 오르기](https://www.acmicpc.net/problem/2579)
- BOJ2156.java : [포도주 시식](https://www.acmicpc.net/problem/2156)

## 📅 2020.12.31.
### Baekjoon Online Judge - Dynamic Programming
- BOJ11053.java : [가장 긴 증가하는 부분수열(LIS)](https://www.acmicpc.net/problem/11053)

## 📅 2021.1.3
### Baekjoon Online Judge - Greedy Algorithm
- BOJ11047.java : [동전 0](https://www.acmicpc.net/problem/11047)

## 📅 2021.6.26
### Baekjoon Online Judge - Mathematics
- BOJ1000.java : [A+B](https://www.acmicpc.net/problem/1000)
- BOJ1001.java : [A-B](https://www.acmicpc.net/problem/1001)
- BOJ1008.java : [A/B](https://www.acmicpc.net/problem/1008)
### Baekjoon Online Judge - Geometry
- BOJ1004.java : [어린왕자](https://www.acmicpc.net/problem/1004)

## 📅 2021.6.27
### Baekjoon Online Judge - Dynamic Programming
- BOJ11726.java : [2xN 타일링](https://www.acmicpc.net/problem/11726)

## 📅 2021.6.29
### Baekjoon Online Judge - Mathematics & Geometry
- BOJ1002.java : [터렛](https://www.acmicpc.net/problem/1002)