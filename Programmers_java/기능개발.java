import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];

        // 작업 날짜
        Queue<Integer> day = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            if (remain % speeds[i] == 0) {
                day.add((100 - progresses[i]) / speeds[i]);
            } else {
                day.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        // max: 가장 오래걸리는 날짜, idx: answer 배열의 인덱스
        int max = day.poll();
        int idx = 0;
        answer[idx]++;

        while (!day.isEmpty()) {
            if (day.peek() > max) {
                max = day.peek();
                idx++;
            }
            answer[idx]++;
            day.poll();
        }

        answer = Arrays.copyOf(answer, idx + 1);
        return answer;
    }
}