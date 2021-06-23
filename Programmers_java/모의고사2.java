import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) cnt[0]++;
            if (answers[i] == second[i % second.length]) cnt[1]++;
            if (answers[i] == third[i % third.length]) cnt[2]++;
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

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
