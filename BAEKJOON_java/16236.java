import java.io.*;
import java.util.*;

class Fish implements Comparable<Fish> {
    int r, c, dist;

    Fish(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dist < o.dist) {
            return -1;
        } else if (this.dist == o.dist) {
            if (this.r < o.r) {
                return -1;
            } else if (this.r == o.r) {
                return Integer.compare(this.c, o.c);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}

public class Main {
    static int[][] map = new int[21][21];
    static boolean[][] visit = new boolean[21][21];
    static int[] dr = {-1, 0, 0, 1};    // 상, 좌, 우, 하
    static int[] dc = {0, -1, 1, 0};
    static int shark_r, shark_c, shark_size = 2;
    static int N, fish_cnt = 0, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {   // 아기상어
                    shark_r = i;
                    shark_c = j;
                }
            }
        }
        babyShark(shark_r, shark_c);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void babyShark(int r, int c) {
        Queue<Fish> queue = new LinkedList<>();
        queue.add(new Fish(r, c, 0));
        PriorityQueue<Fish> pq = new PriorityQueue<>();

        while (!pq.isEmpty() || !queue.isEmpty()) {
            pq.clear();

            while (!queue.isEmpty()) {
                Fish cur = queue.poll();
                visit[cur.r][cur.c] = true;

                for (int i = 0; i < 4; i++) {
                    int next_r = cur.r + dr[i];
                    int next_c = cur.c + dc[i];
                    Fish next = new Fish(next_r, next_c, cur.dist + 1);

                    if (next_r > 0 && next_c > 0 && next_r <= N && next_c <= N && !visit[next_r][next_c]) {
                        if (map[next_r][next_c] > 0 && map[next_r][next_c] < shark_size) {      // 물고기를 먹을 수 있는 경우
                            if (!pq.contains(next)) {
                                pq.add(next);   // 먹을 수 있는 물고기는 pq에 추가
                            }
                            break;
                        } else if (pq.isEmpty() && map[next_r][next_c] <= shark_size) {     // 물고기를 지나갈 수 있는 경우
                            if (!queue.contains(next)) {
                                queue.add(next);    // 지나갈 수 있는 물고기는 queue에 추가
                                visit[next_r][next_c] = true;
                            }
                        }
                    }
                }
            }

            if (!pq.isEmpty()) {
                Fish next_shark = pq.poll();

                map[shark_r][shark_c] = 0;  // 원래 상어가 있던 자리 빈칸으로 수정
                shark_r = next_shark.r;
                shark_c = next_shark.c;
                fish_cnt++;
                ans += next_shark.dist;

                if (fish_cnt == shark_size) {   // 상어의 크기와 이때까지 먹은 물고기 수가 같은 경우
                    shark_size++;
                    fish_cnt = 0;
                }
                next_shark.dist = 0;
                queue.add(next_shark);

                for (int row = 1; row <= N; row++) {
                    for (int col = 1; col <= N; col++) {
                        visit[row][col] = false;
                    }
                }
            } else {
                break;
            }
        }
    }
}