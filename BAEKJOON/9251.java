package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String zero = "0";
        int[][] dp = new int[b.length() + 1][a.length() + 1];

        a = zero.concat(a);
        b = zero.concat(b);

        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (i == 0 || j == 0) {     // 첫째줄인 경우
                    dp[i][j] = 0;
                } else {
                    if (arr1[j] == arr2[i]) {   // 같은 문자라면 대각선 +1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {    // 다른 문자라면 위, 왼쪽 비교해서 더 큰것으로 설정
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }

        System.out.println(dp[arr2.length-1][arr1.length-1]);
    }
}
