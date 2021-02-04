import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Edge {
    int s, e, cost;

    Edge(int s, int e, int cost) {
        this.s = s;
        this.e = e;
        this.cost = cost;
    }
}

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }

        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.cost, o2.cost);
            }
        });

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            Edge edge = edges.get(i);
            if (!isSameParent(edge.s, edge.e)) {
                union(edge.s, edge.e);
                answer += edge.cost;
            }
        }
        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

}