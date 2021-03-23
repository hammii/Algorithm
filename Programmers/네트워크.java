import java.util.*;

class Solution {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                BFS(i, computers);
            }
        }
        return answer;
    }

    public static void BFS(int i, int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;

            for (int j = 0; j < arr.length; j++) {
                if (!visited[j] && arr[cur][j] == 1) {
                    queue.add(j);
                }
            }
        }
    }
}