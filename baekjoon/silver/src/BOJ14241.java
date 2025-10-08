package com.algorithm.baekjoon;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 백준 14241번 슬라임합치기 (Silver) */
public class BOJ14241 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            LinkedList<Integer> list = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                list.add(Integer.parseInt(st.nextToken()));
            list.sort(Comparator.reverseOrder());

            int result = 0;
            while(list.size()>1) {
                int a = list.pop();
                int b = list.pop();
                list.addFirst(a + b);
                result = result + (a*b);
            }

            bw.write(result+"\n");
            bw.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}