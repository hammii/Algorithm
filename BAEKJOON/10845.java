package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] queue = new int[N];
        int front = -1;
        int back = -1;

        for (int i = 0; i < N; i++) {
            String input = sc.next();

            if (input.contains("push")) {
                int num = sc.nextInt();

                if (front == -1) {
                    front++;
                }
                back++;
                queue[back] = num;
            } else if (input.equals("pop")) {
                if (isEmpty(front, back)) {     //큐에 들어있는 정수가 없는 경우
                    System.out.println(-1);
                } else {
                    System.out.println(queue[front++]);
                }
            } else if (input.equals("size")) {
                if (isEmpty(front, back)) {
                    System.out.println(0);
                } else {
                    System.out.println(back - front + 1);
                }
            } else if (input.equals("empty")) {
                if (isEmpty(front, back)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input.equals("front")) {
                if (isEmpty(front, back)) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue[front]);
                }
            } else if (input.equals("back")) {
                if (isEmpty(front, back)) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue[back]);
                }
            }
        }
    }

    public static boolean isEmpty(int front, int back) {
        if (front == -1 || front == back + 1) {
            return true;
        } else {
            return false;
        }
    }
}
