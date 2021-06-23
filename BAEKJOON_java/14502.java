import java.awt.*;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map = new int[9][9];
    public static int[][] copy_map = new int[9][9];
    public static int[][] spread_map = new int[9][9];
    public static int N, M;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                copy_map[i][j] = map[i][j];
            }
        }

        makeWall(0);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void makeWall(int cnt) {
        if (cnt == 3) { // 벽 3개 다 세웠을 경우
            spreadVirus();  // 바이러스 퍼뜨리기
            countZero();    // 안전 영역 카운트
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (copy_map[i][j] == 0) {
                    copy_map[i][j] = 1;
                    makeWall(cnt + 1);
                    copy_map[i][j] = 0;
                }
            }
        }
    }

    public static void spreadVirus() {
        Queue<Point> q = new LinkedList<Point>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                spread_map[i][j] = copy_map[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (spread_map[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int r = q.peek().x;
            int c = q.peek().y;
            q.poll();

            for (int k = 0; k < 4; k++) {
                int next_r = r + dr[k];
                int next_c = c + dc[k];

                if (next_r > 0 && next_c > 0 && next_r <= N && next_c <= M) {
                    if (spread_map[next_r][next_c] == 0) {
                        spread_map[next_r][next_c] = 2;
                        q.add(new Point(next_r, next_c));
                    }
                }
            }
        }
    }

    public static void countZero(){
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (spread_map[i][j] == 0) {
                    cnt++;
                }
            }
        }
        ans = Math.max(ans, cnt);
    }
}
