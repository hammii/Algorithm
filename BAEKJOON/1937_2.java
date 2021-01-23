import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[][] day;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        day = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max_day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max_day = Math.max(dfs(i, j), max_day);
            }
        }
        bw.write(max_day + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int dfs(int x, int y) {
        if (day[x][y] != 0) {   // 이미 계산한 곳이면 return
            return day[x][y];
        }

        int cnt = 1;
        for (int i = 0; i < 4; i++) {   // 상하좌우 반복
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {   // 대나무 숲을 벗어나지 않는지
                if (map[x][y] < map[x + dx[i]][y + dy[i]]) {    // 옮긴 지역이 전 지역보다 많을 경우
                    cnt = Math.max(dfs(nx, ny) + 1, cnt);
                    day[x][y] = cnt;
                }
            }
        }

        return cnt;
    }
}