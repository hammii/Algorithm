package com.gachon;

import java.util.Scanner;

public class Main {
    static int[] min_heap = new int[100001];
    static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x > 0) {
                add(x);
            } else if (x == 0) {
                if (size == 0) {
                    System.out.println(0);
                } else {
                    pop();
                }
            }
        }
    }

    static void swap(int x, int y) {
        int temp = min_heap[x];
        min_heap[x] = min_heap[y];
        min_heap[y] = temp;
    }

    static void add(int num) {
        min_heap[++size] = num;

        for (int i = size; i > 1; i = i / 2) {
            if (min_heap[i] > min_heap[i / 2]) {
                break;
            } else {
                swap(i, i / 2);
            }
        }
    }

    static void pop() {
        System.out.println(min_heap[1]);

        min_heap[1] = min_heap[size];
        size--;

        for (int i = 1; i * 2 <= size; ) {
            if (min_heap[i] < min_heap[i * 2] && min_heap[i] < min_heap[i * 2 + 1]) {
                break;
            } else if (min_heap[i * 2] < min_heap[i * 2 + 1]) {     //왼쪽 자식이 더 작은 경우
                swap(i, i * 2);
                i = i * 2;
            } else {    //오른쪽 자식이 더 작은 경우
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }
    }
}
