package com.gachon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());   // 시작 방향
            int g = Integer.parseInt(st.nextToken());   // 세대

            dragonCurve(x, y, d, g);
        }

        // 사각형 개수 구하기

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dragonCurve(int x, int y, int d, int g) {
        
    }
}