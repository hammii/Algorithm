import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 오름차순
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순
        int[] answer = new int[2];

        for (int i = 0; i < operations.length; i++) {
            String oper = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);

            if (oper.equals("I")) {
                pq.add(num);
                reverse_pq.add(num);
            } else if (oper.equals("D")) {
                if (num == 1) { // 최댓값 삭제
                    Integer max = reverse_pq.poll();
                    pq.remove(max);
                } else {    // 최솟값 삭제
                    Integer min = pq.poll();
                    reverse_pq.remove(min);
                }
            }
        }

        if (!pq.isEmpty()) {
            answer[0] = reverse_pq.peek();
            answer[1] = pq.peek();
        }

        return answer;
    }
}