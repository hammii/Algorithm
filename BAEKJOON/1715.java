package com.gachon;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() > 1) {
            int i = pq.poll();
            int j = pq.poll();

            sum = sum + (i + j);
            if (!pq.isEmpty()) {
                pq.offer(i + j);
            }
        }
        bw.write(String.valueOf(sum));

        br.close();
        bw.flush();
        bw.close();
    }
}