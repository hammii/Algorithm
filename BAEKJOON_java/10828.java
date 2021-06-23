package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] stack = new int[N];
        int top = -1;

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            if (input.contains("push")) {
                int num = sc.nextInt();
                stack[++top] = num;
            } else if (input.equals("pop")) {
                if (top == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack[top--]);
                }
            } else if (input.equals("size")) {
                System.out.println(top + 1);
            } else if (input.equals("empty")) {
                if (top == -1) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input.equals("top")) {
                if (top == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack[top]);
                }
            }
        }

    }
}
