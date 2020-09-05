package com.gachon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = sc.nextInt();
            arr[test_case - 1] = num;
        }
        Arrays.sort(arr);
        System.out.print(arr[T / 2]);
    }
}
