package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int GCD = getGCD(Math.max(a, b), Math.min(a, b));
        System.out.println(GCD);
        System.out.println(a * b / GCD);
    }

    public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGCD(b, a % b);
        }
    }
}
