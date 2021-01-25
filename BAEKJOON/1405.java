import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited = new boolean[30][30];
    static int N;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static double result = 0;
    static double[] way = new double[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {   // 동,서,남,북 확률
            way[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        dfs(15, 15, 1.0);
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x, double percentage) {
        if (N == 0) { // 갈때까지 갔으면
            result += percentage;
            return;
        }
        visited[y][x] = true;   // 방문 표시

        for (int i = 0; i < 4; i++) {   // 동, 서, 남, 북 훑기
            if (!visited[y + dy[i]][x + dx[i]] && way[i] > 0) {   // 방문하지 않은 곳이면
                N--;
                dfs(y + dy[i], x + dx[i], percentage * way[i]);  // 자리 옮기기
                N++;
                visited[y + dy[i]][x + dx[i]] = false;
            }
        }
    }
}