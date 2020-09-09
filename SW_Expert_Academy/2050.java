package com.gachon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        for (int i = 0; i < line.length(); i++) {
            int num = ((int) line.charAt(i)) - 64;
            System.out.print(num + " ");
        }

    }
}
