package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 0; test_case < T; test_case++) {
            int k = sc.nextInt();
            String[] p = new String[k];
            boolean possible = false;

            for (int i = 0; i < k; i++) {
                p[i] = sc.next();
            }

            loop:
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == j) {
                        continue;
                    }
                    String concat = p[i].concat(p[j]);

                    if (isPalindrome(concat)) {     // 팰린드롬인 경우 출력하고 이중 for문 나가기
                        System.out.println(concat);
                        possible = true;
                        break loop;
                    }
                }
            }

            if (!possible) {
                System.out.println(0);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        for (; i < str.length() / 2; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
