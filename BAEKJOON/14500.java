package com.gachon;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[501][501];
    static boolean[][] visited = new boolean[501][501];
    static int[] dr = {-1, 0, 0, 1};   // 북,서,동,남
    static int[] dc = {0, -1, 1, 0};
    static int N, M;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visited[i][j] = true;
                findOne(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void findOne(int row, int col, int cnt, int sum) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int next_r = row + dr[i];
            int next_c = col + dc[i];

            if (next_r > 0 && next_c > 0 && next_r <= N && next_c <= M) {
                if (!visited[next_r][next_c]) {
                    visited[next_r][next_c] = true;
                    findOne(next_r, next_c, cnt + 1, sum + map[next_r][next_c]);
                    visited[next_r][next_c] = false;

                    if (cnt == 2) { // ㅗ 모양 테트로미노
                        visited[next_r][next_c] = true;
                        findOne(row, col, cnt + 1, sum + map[next_r][next_c]);
                        visited[next_r][next_c] = false;
                    }
                }
            }
        }
    }
}