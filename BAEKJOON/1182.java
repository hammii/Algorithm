package com.gachon;

import java.util.Scanner;

public class Main {
    static int N, S, count = 0;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        DFS(0, 0);

        if (S == 0) {
            System.out.println(--count);    // 공집합 빼주기
        } else {
            System.out.println(count);
        }
    }

    public static void DFS(int v, int su) {
        if (v == N) {   // 모든 경우의 수 끝에 도달했을 때
            if (su == S) {
                count++;
            }
            return;
        }

        DFS(v + 1, su + arr[v]);    // 자신을 더해주는 경우
        DFS(v + 1, su);     // 자신을 더하지 않는 경우
    }
}
