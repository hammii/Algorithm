import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dr = {{-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}}; // 서, 남, 동, 북 방향
    public static int[][] dc = {{1, 1, 0, 0, 0, 0, -1, -1, -2, -1}, {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1}, {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}};
    public static int[] per = {1, 1, 2, 2, 7, 7, 10, 10, 5};
    public static int[] next_r = {0, 1, 0, -1};
    public static int[] next_c = {-1, 0, 1, 0};
    public static int N;
    public static int[][] map;
    public static long ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado((N + 1) / 2, (N + 1) / 2, 0);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void tornado(int row, int col, int d) {
        int cnt = 1;

        loop:
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 2; j++) {  // 두번씩 반복
                for (int l = 1; l <= cnt; l++) {
                    int nextRow = row + next_r[d];  // 이동할 위치
                    int nextCol = col + next_c[d];
                    int sum = 0;

                    if (nextRow == 1 && nextCol == 0) break loop;   // (1,1)에 위치했을 때 종료

                    int sand = map[nextRow][nextCol];   // 토네이도 한 칸 이동했을 때 모래의 양
                    for (int k = 0; k < 10; k++) {
                        if (k == 9) {   // 알파값 계산
                            if (nextRow + dr[d][k] < 1 || nextCol + dc[d][k] < 1 || nextRow + dr[d][k] > N || nextCol + dc[d][k] > N) {
                                ans += sand - sum;
                            } else {
                                map[nextRow + dr[d][k]][nextCol + dc[d][k]] += sand - sum;
                            }
                            break;
                        }

                        if (nextRow + dr[d][k] < 1 || nextCol + dc[d][k] < 1 || nextRow + dr[d][k] > N || nextCol + dc[d][k] > N) {
                            ans += sand * per[k] / 100;
                        } else {
                            map[nextRow + dr[d][k]][nextCol + dc[d][k]] += sand * per[k] / 100;
                        }
                        sum += sand * per[k] / 100;
                    }
                    row = nextRow;
                    col = nextCol;
                }
                d = (d + 1) % 4;    // 방향 바꾸기
            }
            cnt++;
        }
    }
}