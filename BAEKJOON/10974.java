package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1]; //고정 배열
        int[] out = new int[N + 1]; //최종 출력할 배열
        boolean[] visited = new boolean[N + 1]; //한번 쓴 숫자인지 확인

        for (int i = 1; i <= N; i++) {  //숫자를 어레이에 넣기
            arr[i] = i;
            visited[i] = false;
        }
        permutation(N, arr, out, visited, 1);
    }

    public static void permutation(int N, int[] arr, int[] out, boolean[] visited, int depth) {
        if (depth == N + 1) {   //마지막이면 출력
            for (int i = 1; i <= N; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(N, arr, out, visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}
