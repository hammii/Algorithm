package com.gachon;

import java.util.Scanner;

public class Main {
    static int N;
    static int[] deque;
    static int front = -1;
    static int back = -1;
    static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        deque = new int[N];

        for (int i = 0; i < N; i++) {
            String input = sc.next();
            if (input.contains("push_front")) {
                int num = sc.nextInt();
                push_front(num);
            } else if (input.contains("push_back")) {
                int num = sc.nextInt();
                push_back(num);
            } else if (input.equals("pop_front")) {
                pop_front();
            } else if (input.equals("pop_back")) {
                pop_back();
            } else if (input.equals("size")) {
                System.out.println(size);
            } else if (input.equals("empty")) {
                if (isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (input.equals("front")) {
                if (isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque[front]);
                }
            } else if (input.equals("back")) {
                if (isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque[back]);
                }
            }
        }
    }

    public static void push_front(int num) {
        if (front == -1 && back == -1) {    // 덱에 처음 추가할 경우
            front++;
            back++;
            deque[front] = num;
        } else {
            if (front == 0) {   // front가 맨 앞일 경우
                front = N - 1;
            } else {
                front--;
            }
            deque[front] = num;
        }
        size++;
    }

    public static void push_back(int num) {
        if (front == -1 && back == -1) {    // 덱에 처음 추가할 경우
            front++;
            back++;
            deque[back] = num;
        } else {
            if (back == N - 1) {   // back이 맨 뒤일 경우
                back = 0;
            } else {
                back++;
            }
            deque[back] = num;
        }
        size++;
    }

    public static void pop_front() {
        if (isEmpty()) {
            System.out.println(-1);
        } else {
            if (front == N - 1) {   // front가 맨 뒤일 경우
                System.out.println(deque[front]);
                front = 0;
            } else {
                System.out.println(deque[front++]);
            }
        }
        if (size > 0) {
            size--;
        }
    }

    public static void pop_back() {
        if (isEmpty()) {
            System.out.println(-1);
        } else {
            if (back == 0) {    // back이 맨 앞일 경우
                System.out.println(deque[back]);
                back = N - 1;
            } else {
                System.out.println(deque[back--]);
            }
        }
        if (size > 0) {
            size--;
        }
    }

    public static boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
