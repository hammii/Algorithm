package com.gachon;

import java.util.Scanner;

public class Main {
    static int N = 0;
    static int[][] map, day;
    static int[] tx = {1, -1, 0, 0};
    static int[] ty = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        day = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max_day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max_day = Math.max(dfs(i, j), max_day);     // 최대 생존 일수
            }
        }

        System.out.println(max_day);
    }

    public static int dfs(int i, int j) {
        if (day[i][j] != 0) {   // 이미 계산한 경우
            return day[i][j];
        }

        int cnt = 1;
        for (int k = 0; k < 4; k++) {   // 상,하,좌,우
            if (i + tx[k] >= 0 && i + tx[k] < N && j + ty[k] >= 0 && j + ty[k] < N) {   // 값이 존재할 때만
                if (map[i][j] < map[i + tx[k]][j + ty[k]]) {    // 값이 더 큰 경우
                    cnt = Math.max(dfs(i + tx[k], j + ty[k]) + 1, cnt);     // 자기 자신을 포함해야하므로 +1
                    day[i][j] = cnt;    // 가장 큰 값으로 최대 생존일 갱신
                }
            }
        }

        return cnt;
    }
}
