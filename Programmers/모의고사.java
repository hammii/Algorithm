import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        List<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> second = new ArrayList<>(Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
        List<Integer> third = new ArrayList<>(Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));
        int[] cnt = new int[3];

        while (first.size() < answers.length) {
            first.addAll(first);
        }
        while (second.size() < answers.length) {
            second.addAll(second);
        }
        while (third.size() < answers.length) {
            third.addAll(third);
        }

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first.get(i)) cnt[0]++;
            if (answers[i] == second.get(i)) cnt[1]++;
            if (answers[i] == third.get(i)) cnt[2]++;
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, cnt[i]);
        }

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            if (max == cnt[i]) {
                answer[idx++] = i + 1;
            }
        }

        answer = Arrays.copyOfRange(answer, 0, idx);
        return answer;
    }
}