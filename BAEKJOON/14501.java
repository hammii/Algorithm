package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] time = new int[N + 2];
        int[] money = new int[N + 2];
        int[] dp = new int[N + 2];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            money[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (i + time[i] <= N + 1) {     // 일을 한 경우
                dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + money[i]);
                result = dp[i + time[i]];
            }
            // 일을 건너뛴 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            result = dp[i + 1];
        }

        System.out.println(result);
    }
}
