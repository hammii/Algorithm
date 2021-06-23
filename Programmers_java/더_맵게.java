import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.size() >= 2) {
            int min = pq.poll();
            int min2 = pq.poll();

            if (min >= K) break;
            pq.add(min + min2 * 2);
            answer++;
        }

        if (pq.size() == 1 && pq.poll() < K) {
            answer = -1;
        }

        return answer;
    }
}