import java.io.*;
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        boolean[] bridge = new boolean[bridge_length];  
        int weight_sum = 0; 
        int idx = 1;    

        Queue<Integer> queue = new LinkedList<>();  

        queue.add(truck_weights[0]);
        bridge[bridge_length - 1] = true;
        weight_sum += truck_weights[0];

        while (!queue.isEmpty()) {
            answer++;

            if (bridge[0]) {
                weight_sum -= queue.peek();
                queue.poll();
            }
            for (int i = 0; i < bridge_length - 1; i++) {
                bridge[i] = bridge[i + 1];
            }
            bridge[bridge_length - 1] = false;

            if (idx < truck_weights.length) {
                int next = truck_weights[idx];
                if (weight_sum + next <= weight) {
                    queue.add(next);
                    bridge[bridge_length - 1] = true;
                    weight_sum += next;
                    idx++;
                }
            }
        }

        return answer;
    }
}