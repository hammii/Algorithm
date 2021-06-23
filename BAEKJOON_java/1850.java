package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        StringBuilder builder = new StringBuilder();

        for(int i=0;i<getGCD(a,b);i++){
            builder.append('1');
        }
        
        System.out.print(builder);
    }

    public static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }
}
