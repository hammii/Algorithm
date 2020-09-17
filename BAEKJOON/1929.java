package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] prime = new boolean[N + 1];

        // 0과 1은 소수 제외
        prime[0] = prime[1] = false;

        // 2 부터 N 까지 소수로 설정
        for (int i = 2; i <= N; i++) {
            prime[i] = true;
        }

        for (int i = 2; (i * i) <= N; i++) {
            if (prime[i]) {
                for (int j = (i * i); j <= N; j += i) {     // i*i 미만은 이미 처리 되었으므로 i*i 부터 N 까지
                    prime[j] = false;
                }
            }
        }

        // M 부터 N 사이 중 소수인 것만 출력
        for (int i = M; i <= N; i++) {
            if (prime[i]) {
                System.out.println(i);
            }
        }
    }
}
