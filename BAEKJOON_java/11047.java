package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[10];
        int count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            if (K / arr[i] >= 1) {
                count += K / arr[i];
                K = K % arr[i];

                if (K == 0) {
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
