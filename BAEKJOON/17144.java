import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map = new int[51][51];
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] air_r = new int[2];
        int air_cnt = 0;

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {  // 공기청정기가 설치된 장소 저장
                    air_r[air_cnt++] = i;
                }
            }
        }

        while (T > 0) {
            int[][] copy_map = new int[51][51];

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] <= 0) {   // 미세먼지가 없거나 공기청정기가 설치된 곳이라면 건너뜀
                        if (map[i][j] == -1) copy_map[i][j] = map[i][j];
                        continue;
                    }

                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {   // 1. 미세먼지가 확산된다.
                        int next_r = i + dr[k];
                        int next_c = j + dc[k];

                        if (next_r > 0 && next_c > 0 && next_r <= R && next_c <= C) {
                            if (map[next_r][next_c] != -1) {    // 인접한 공기청정기가 없는 경우에만
                                copy_map[next_r][next_c] += map[i][j] / 5;
                                cnt++;
                            }
                        }
                    }
                    copy_map[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
                }
            }
            map = copy_map;

            // 2. 공기청정기가 작동한다.
            for (int i = air_r[0] - 1; i > 1; i--) {    // 내려오는 방향
                map[i][1] = map[i - 1][1];
            }
            for (int i = 1; i < C; i++) {   // <-
                map[1][i] = map[1][i + 1];
            }
            for (int i = 1; i < air_r[0]; i++) {    // 올라오는 방향
                map[i][C] = map[i + 1][C];
            }
            for (int i = C; i > 2; i--) {   // ->
                map[air_r[0]][i] = map[air_r[0]][i - 1];
            }
            map[air_r[0]][2] = 0;

            for (int i = air_r[1] + 1; i < R; i++) {
                map[i][1] = map[i + 1][1];
            }
            for (int i = 0; i < C; i++) {
                map[R][i] = map[R][i + 1];
            }
            for (int i = R; i > air_r[1]; i--) {
                map[i][C] = map[i - 1][C];
            }
            for (int i = C; i > 2; i--) {
                map[air_r[1]][i] = map[air_r[1]][i - 1];
            }
            map[air_r[1]][2] = 0;

            T--;
        }

        int sum = 0;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }

        bw.write(sum + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
