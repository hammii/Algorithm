import java.util.LinkedList;
import java.util.Queue;

class Printer {
    int location;
    int priority;

    Printer(int location, int priority) {
        this.location = location;
        this.priority = priority;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Printer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Printer(i, priorities[i]));
        }

        while (!queue.isEmpty()) {
            boolean flag = false;
            Printer cur = queue.peek();

            for (Printer q : queue) {
                if (cur.priority < q.priority) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {    // 우선순위가 가장 높은 경우
                if (queue.poll().location == location) {
                    answer = priorities.length - queue.size();
                }
            } else {
                queue.add(queue.poll());
            }
        }
        return answer;
    }
}