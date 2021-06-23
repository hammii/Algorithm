package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] prime = new boolean[N + 1];

        prime[0] = prime[1]  = false;

        for (int i = 2; i <= N; i++) {
            prime[i] = true;
        }

        for (int i = 2; (i * i) <= N; i++) {
            if (prime[i]) {
                for (int j = (i * i); j <= N; j += i) {
                    prime[j] = false;
                }
            }
        }

        int sum = 0;
        int min = 0;

        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                sum += i;

                if (min == 0) {
                    min = i;
                }
            }
        }

        if (sum == 0) {
            System.out.print(-1);
        } else {
            System.out.println(sum);
            System.out.print(min);
        }
    }
}
