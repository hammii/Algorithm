package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            int sum = 0;

            for (int j = 1; j <= num; j++) {
                if (j % 2 == 1) {
                    sum += j;
                } else {
                    sum -= j;
                }
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}
