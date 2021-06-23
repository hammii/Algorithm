import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for (int p : prices) {
            stack.add(p);
        }

        Deque<Integer> compare = new ArrayDeque<>();
        for (int i = stack.size() - 1; i >= 0; i--) {
            int cur = stack.pop();
            int cnt = 0;

            for (Integer c : compare) {
                cnt++;
                if (cur > c) break;
            }

            answer[i] = cnt;
            compare.addFirst(cur);
        }

        return answer;
    }
}