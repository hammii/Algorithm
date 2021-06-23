import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost)
            return -1;
        else if (this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}

public class Main {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;
    public static int answer = 0;

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            parent[y] = x;
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        edgeList = new ArrayList<Edge>();

        for (int i = 0; i < M; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            edgeList.add(new Edge(v1, v2, cost));
        }

        Collections.sort(edgeList);

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {   // edge 개수만큼 반복
            Edge edge = edgeList.get(i);
            if (!isSameParent(edge.v1, edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }
}
