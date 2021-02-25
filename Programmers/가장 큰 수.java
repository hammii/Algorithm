import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str_arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str_arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str_arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String s : str_arr) {
            answer += s;
        }

        return str_arr[0].equals("0") ? str_arr[0] : answer;
    }
}