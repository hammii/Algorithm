package com.gachon;

import java.util.Scanner;

public class Main {
    static int[] max_heap = new int[100001];
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
        int temp = max_heap[x];
        max_heap[x] = max_heap[y];
        max_heap[y] = temp;
    }

    static void add(int num) {
        max_heap[++size] = num;

        for (int i = size; i > 1; i = i / 2) {
            if (max_heap[i] > max_heap[i / 2]) {
                swap(i, i / 2);
            } else {
                break;
            }
        }
    }

    static void pop() {
        System.out.println(max_heap[1]);

        max_heap[1] = max_heap[size];
        max_heap[size--] = 0;

        for (int i = 1; i * 2 <= size; ) {
            if (max_heap[i] > max_heap[i * 2] && max_heap[i]>max_heap[i*2+1]) {
                break;
            } else if (max_heap[i*2] > max_heap[i * 2 + 1]) {     //왼쪽 자식이 더 큰 경우
                swap(i, i * 2);
                i = i * 2;
            } else {    //오른쪽 자식이 더 큰 경우
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }
    }
}
