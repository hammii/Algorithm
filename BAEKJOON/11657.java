package com.gachon;

import java.io.*;
import java.util.*;

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static long[] D;
    static Edge[] edge_arr;

    static boolean bellmanFord() {
        // distance 와 path 초기화
        for (int i = 1; i <= N; i++) {
            D[i] = INF;
        }
        D[1] = 0;

        for (int i = 1; i <= N - 1; i++) {
            for (int j = 0; j < M; j++) {
                if (D[edge_arr[j].from] != INF && D[edge_arr[j].to] > D[edge_arr[j].from] + edge_arr[j].cost) {
                    D[edge_arr[j].to] = D[edge_arr[j].from] + edge_arr[j].cost;
                }
            }
        }

        // 음의 싸이클 존재 확인
        for (int j = 0; j < M; j++) {
            if (D[edge_arr[j].from] != INF && D[edge_arr[j].to] > D[edge_arr[j].from] + edge_arr[j].cost) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 도시 개수
        M = Integer.parseInt(st.nextToken());   // 버스 노선 개수
        edge_arr = new Edge[M];
        D = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edge_arr[i] = new Edge(from, to, cost);
        }

        if (!bellmanFord()) {    // 음의 싸이클이 있는 경우
            bw.write(-1 + "\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (D[i] == INF) {  // 경로가 없는 경우 -1 출력
                    bw.write(-1 + "\n");
                } else {
                    bw.write(D[i] + "\n");
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}