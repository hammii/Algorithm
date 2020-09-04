package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;
            double avg;

            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                sum += num;
            }
            avg = sum / 10.0;

            System.out.println("#" + test_case + " " + Math.round(avg));
        }

    }
}
