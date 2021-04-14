import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { -0, 0, -1, 1 };
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Point> virus;
    static boolean[] choose;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        virus = new ArrayList<>();

        boolean zero_flag = false;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }

                if (map[i][j] == 0) {
                    zero_flag = true;
                }
            }
        }

        if (!zero_flag) { // 빈칸이 하나도 없을 경우
            answer = 0;
        } else {
            choose = new boolean[virus.size()];
            dfs(0, 0);

            if (answer == Integer.MAX_VALUE) {
                answer = -1;
            }
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static void dfs(int idx, int cnt) {
        if (cnt == M) {
            spreadVirus(); // 바이러스 퍼뜨리기
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            if (!choose[i]) {
                choose[i] = true;
                dfs(i, cnt + 1);
                choose[i] = false;
            }
        }
    }

    public static void spreadVirus() {
        visited = new boolean[N + 1][N + 1];

        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) { // 선택된 바이러스라면 큐에 추가
            if (choose[i]) {
                q.add(virus.get(i));
                visited[virus.get(i).x][virus.get(i).y] = true;
            }
        }

        int cnt = 0;
        int t = 0;

        while (!q.isEmpty()) {
            boolean flag = false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point cur = q.poll();

                for (int k = 0; k < 4; k++) {
                    int next_x = cur.x + dx[k];
                    int next_y = cur.y + dy[k];

                    if (next_x > 0 && next_x <= N && next_y > 0 && next_y <= N) {
                        if (!visited[next_x][next_y]) {
                            visited[next_x][next_y] = true;

                            if (map[next_x][next_y] == 0) {
                                q.add(new Point(next_x, next_y));
                                flag = true;
                            }
                            if (map[next_x][next_y] == 2) { // 비활성 바이러스인 경우
                                q.add(new Point(next_x, next_y));
                            }
                        }
                    }
                }
            }

            if (!flag) { // 빈칸은 없고 비활성 바이러스만 있는 경우
                t++;
            } else {
                cnt += ++t;
                t = 0;
            }
        }

        if (checkVisit()) {
            answer = Math.min(answer, cnt);
        }
    }

    public static boolean checkVisit() { // 방문 안한 곳 있는지 확인
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
