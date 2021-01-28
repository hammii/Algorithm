import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] d_col = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] d_row = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        findIsland(i, j);
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void findIsland(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 8; i++) {
            int next_row = row + d_row[i];
            int next_col = col + d_col[i];

            if (next_row < 0 || next_row >= h || next_col < 0 || next_col >= w) {
                continue;
            }
            if (map[next_row][next_col] == 1 && !visited[next_row][next_col]) {
                findIsland(next_row, next_col);
            }
        }
    }
}