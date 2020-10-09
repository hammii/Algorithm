package com.gachon;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] vector;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        vector = new int[N];
        int tail = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                vector[i] = arr[i];
            } else {
                if (vector[tail] < arr[i]) {    // vector의 마지막보다 값이 더 큰 경우
                    vector[++tail] = arr[i];
                } else {    // vector의 마지막보다 값이 같거나 작은 경우
                    int index = lower_bound(0, tail, arr[i]);   // 들어갈 자리 찾기
                    vector[index] = arr[i];
                }
            }
        }

        System.out.println(tail + 1);
    }

    public static int lower_bound(int start, int end, int num) {
        int mid = 0;

        while (start < end) {
            mid = (start + end) / 2;

            if (vector[mid] < num) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
