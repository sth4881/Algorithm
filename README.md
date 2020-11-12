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
- BJ10818_heapSort.java : 최대힙, 최소힙을 이용해서 최대값, 최소값 찾기

## 📅 2020.11.4.
### Dynamic Programming
- Stairs1.java : n개의 계단을 오를 때 한 번에 1개 혹은 3개의 계단만 사용해서 올라가는 경우의 수
- Stairs2.java : n개의 계단을 오를 때 한 번에 오를 수 있는 계단의 단위가 s1, s2, s3, ... , sk로 총 k개의 존재할 경우, 이 계단들을 사용해서 올라가는 경우의 수

## 📅 2020.11.10.
### Dynamic Programming
- Grid1.java : 셀 (1,1)에서 오른쪽 방향 혹은 위쪽 방향으로만 가면서 셀 까지 가는 경로의 최소 비용 구하기. 경로의 비용이란 지나가는 셀의 비용의 총합을 말한다.
- Grid2.java : 가장 아래 행의 셀로부터 '오른쪽 위쪽 대각선 방향' 혹은 '위쪽 방향' 혹은 '왼쪽 위쪽 대각선 방향'으로만 가면서 가장 위의 행의 셀까지 가는 경로의 최소 비용 구하기. 경로의 비용이란 지나가는 셀의 비용의 총합을 말한다.
- BJ1003.java : 피보나치 함수를 재귀적으로 호출할 때, n번째 피보나치 수열은 0과 1을 각각 몇 번씩 호출하는지 구하기

## 📅 2020.11.12.
### Dynamic Programming
- Stairs3.java : n개의 계단을 오를 때 한 번에 오를 수 있는 계단의 단위가 s1, s2, s3, ... , sk로 총 k개의 존재한다고 하자. 이 계단들을 사용하되 밟는 계단 수가 최소가 되도록 하면서 올라가고자 할 때 최소 계단 수 구하기
- Padovan.java : 나선 모양으로 놓여져 있는 삼각형의 변의 길이를 수열로 갖는 파도반 수열 구현하기