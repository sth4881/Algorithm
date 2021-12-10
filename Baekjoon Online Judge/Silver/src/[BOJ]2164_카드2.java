package com.algorithm.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; i++)
                q.offer(i);

            if(n==1) bw.write(1+"\n");
            else {
                while (true) {
                    // 맨 위의 카드를 버림
                    q.poll();
                    // 큐에 카드가 한 장만 남을 때까지 반복
                    if (q.size() == 1) break;
                    // 그 다음 카드를 맨 아래에 위치시킴
                    q.offer(q.poll());
                }
                bw.write(q.poll()+"\n");
            }
            bw.close();
        } catch(IOException e) {
            e.getStackTrace();
        }
    }
}