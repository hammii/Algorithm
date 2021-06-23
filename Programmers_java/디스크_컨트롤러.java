import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int idx = 0;
        int count = 0;

        Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                int[] temp = pq.poll();
                answer += time - temp[0] + temp[1];
                time += temp[1];
                count++;
            }
        }

        answer = answer / jobs.length;
        return answer;
    }
}