package com.gachon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String num = Integer.toString(i);
            char[] arrChar = num.toCharArray();
            int count = 0;

            for (int j = 0; j < num.length(); j++) {
                if (arrChar[j] == '3' || arrChar[j] == '6' || arrChar[j] == '9') {
                    count++;
                }
            }

            if (count > 0) {
                for (int k = 0; k < count; k++) {
                    System.out.print("-");
                }
            } else {
                System.out.print(num);
            }
            System.out.print(" ");
        }
    }
}
