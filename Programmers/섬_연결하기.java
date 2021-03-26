import java.util.*;

class Edge implements Comparable<Edge> {
    int s, e, cost;

    Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Solution {
    static int[] parent;
    static PriorityQueue<Edge> edges;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        edges = new PriorityQueue<>();

        for (int i = 0; i < costs.length; i++) {
            edges.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        while (!edges.isEmpty()) {
            Edge cur = edges.poll();

            if (find(cur.s) == find(cur.e)) {
                continue;
            } else {
                union(cur.s, cur.e);
                answer += cur.cost;
            }
        }
        return answer;
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) parent[rootY] = rootX;
    }
}