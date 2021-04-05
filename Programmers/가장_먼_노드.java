import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        int answer;

        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {     // 양방향 추가해주기
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        answer = bfs();
        return answer;
    }

    public static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (true) {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int adj : graph.get(cur)) {
                    if (!visited[adj]) {
                        temp.add(adj);
                        visited[adj] = true;
                    }
                }
            }

            if (temp.isEmpty()) break;
            queue.addAll(temp);
            cnt = temp.size();
        }

        return cnt;
    }
}