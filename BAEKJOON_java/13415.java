package com.gachon;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted_arr = new int[N];
        Deque<Integer> set = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted_arr[i] = arr[i];
        }

        int K = Integer.parseInt(br.readLine());

        int sort_max = 0;   // 어디까지 정렬할 건지
        for (int i = 0; i < K; i++) {
            String str = br.readLine();
            int A = Integer.parseInt(str.split(" ")[0]);
            int B = Integer.parseInt(str.split(" ")[1]);

            sort_max = Math.max(sort_max, Math.max(A, B));

            while ((!set.isEmpty()) && (Math.abs(set.getLast()) <= A)) {
                set.pollLast();
            }
            set.addLast(A);

            while ((!set.isEmpty()) && (Math.abs(set.getLast()) <= B)) {
                set.pollLast();
            }
            set.addLast(-B);
        }

        set.addLast(0); // 마지막 연산 위해

        Arrays.sort(arr, 0, sort_max);   // arr 정렬하기

        int final_idx = sort_max - 1;
        int ascend_idx = sort_max - 1;
        int descend_idx = 0;

        int cur = set.pollFirst();
        while (!set.isEmpty()) {
            int next = set.pollFirst();
            int diff = Math.abs(cur) - Math.abs(next);

            if (cur > 0) {  // 오름차순
                for (int i = 0; i < diff; i++) {
                    sorted_arr[final_idx--] = arr[ascend_idx--];
                }
            } else {    // 내림차순
                for (int i = 0; i < diff; i++) {
                    sorted_arr[final_idx--] = arr[descend_idx++];
                }
            }
            cur = next;
        }

        for (int i = 0; i < sorted_arr.length; i++) {
            bw.write(sorted_arr[i] + " ");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}