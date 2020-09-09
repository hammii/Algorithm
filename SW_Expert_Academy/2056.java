package com.gachon;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int[] array31 = new int[]{1, 3, 5, 7, 8, 10, 12};
        int[] array30 = new int[]{4, 6, 9, 11};

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();

            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String date = str.substring(6);

            int intMonth = Integer.parseInt(month);
            int intDate = Integer.parseInt(date);
            boolean result = false;

            if (intMonth > 0 && intMonth <= 12) {
                if (IntStream.of(array31).anyMatch(x -> x == intMonth)) {
                    if (intDate > 0 && intDate <= 31) {
                        result = true;
                    }
                } else if (IntStream.of(array30).anyMatch(x -> x == intMonth)) {
                    if (intDate > 0 && intDate <= 30) {
                        result = true;
                    }
                } else if (intMonth == 2) {
                    if (intDate > 0 && intDate <= 28) {
                        result = true;
                    }
                }
            }

            if (result) {
                System.out.println("#" + test_case + " " + year + "/" + month + "/" + date);
            } else {
                System.out.println("#" + test_case + " -1");
            }
        }
    }
}
