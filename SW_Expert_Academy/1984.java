package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int max = -1;
        int min = -1;
        int sum = 0;

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] arr = new int[10];

            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();

                if (i == 0) {
                    max = arr[i];
                    min = arr[i];
                } else {
                    if (arr[i] > max) {
                        max = arr[i];
                    }
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                }
                sum += arr[i];
            }
            float result = (float) ((sum - max - min) / 8.0);
            System.out.println("#" + test_case + " " + Math.round(result));

            max = -1;
            min = -1;
            sum = 0;
        }
    }
}
