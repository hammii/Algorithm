import java.awt.Point;
import java.io.*;
import java.util.*;

// N: 크기, M: 활성 바이러스 개수
// map: 빈칸(0), 벽(1), 바이러스를 놓을 수 있는 위치(2)
// virus: 바이러스 맵

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static int[][] map;
    static int answer = -1;
    static int min_time = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        ArrayList<Point> virus_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    virus_list.add(new Point(i, j));
                }
            }
        }

        dfs(virus_list, new ArrayList<>());

        bw.write(answer + "\n");
        bw.flush();
        bw.close();

    }

    public static void dfs(ArrayList<Point> origin_list, ArrayList<Point> new_list) {
        if (new_list.size() == M) {
            if (!bfs(new_list)) { // 가능한 곳이 한군데라도 있으면
                answer = min_time;
            }
        }

        for (int i = 0; i < origin_list.size(); i++) {
            Point p = origin_list.get(i);
            if (new_list.contains(p)) {
                continue;
            }
            new_list.add(p);
            dfs(origin_list, new_list);
            new_list.remove(p);
        }

    }

    public static boolean bfs(ArrayList<Point> list) {
        String[][] virus = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Point p = new Point(i, j);

                if (map[i][j] == 0) { // 빈칸
                    virus[i][j] = "-1";
                } else if (map[i][j] == 1) { // 벽
                    virus[i][j] = "-";
                } else if (map[i][j] == 2 && !list.contains(p)) { // 비활성 바이러스
                    virus[i][j] = "*";
                } else {
                    virus[i][j] = "0";
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(virus[i][j] + " ");
//            }
//            System.out.println();
//        }

        Queue<Point> queue = new LinkedList<>(list);
        int time = 0;
        while (true) {
            Queue<Point> near_queue = new LinkedList<>();

            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int next_r = cur.x + dr[i];
                    int next_c = cur.y + dc[i];

                    if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= N) {
                        continue;
                    }

                    if (virus[next_r][next_c].equals("-1") ) { // 방문하지 않은 곳이라면
                        virus[next_r][next_c] = String.valueOf(time);
                        near_queue.add(new Point(next_r, next_c));
                    }
                    if (virus[next_r][next_c].equals("*")) { // 비활성화 바이러스를 지나갈 경우
                        virus[next_r][next_c] = String.valueOf(time);
                    }
                }
            }
            if (near_queue.isEmpty()) {
                break;
            }
            queue.addAll(near_queue);
            time++;
        }

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (virus[i][j].equals("-1")) { // 방문하지 않은 곳이 한군데라도 있으면
                    flag = true;
                    break;
                }
            }
        }

        min_time = Math.min(min_time, time); // 최소값으로 정답 업데이트
        return flag;
    }
}
