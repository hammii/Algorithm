package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        boolean[] prime = new boolean[N];

        // N 만큼 입력받고 소수로 설정
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
            prime[i] = true;
        }

        // 소수가 아닌 경우 false 로 설정
        for (int i = 0; i < N; i++) {
            if (num[i] == 1) {
                prime[i] = false;
            } else {
                for (int j = 2; j < num[i]; j++) {
                    if (num[i] % j == 0) {
                        prime[i] = false;
                        break;
                    }
                }
            }
        }

        // 소수인 것만 출력
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (prime[i]) {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
