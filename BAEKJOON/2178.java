import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {   // 입력
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        bfs();

        bw.write(map[N - 1][M - 1] + "\n");
        bw.close();
    }

    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int next_x = cur.x + dx[i];
                int next_y = cur.y + dy[i];
                if (next_x >= 0 && next_x < N && next_y >= 0 && next_y < M) {
                    if (!visited[next_x][next_y] && map[next_x][next_y] == 1) {
                        q.offer(new Point(next_x, next_y));
                        visited[next_x][next_y] = true;
                        map[next_x][next_y] = map[cur.x][cur.y] + 1;
                    }
                }
            }
        }
    }
}
