import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[51][51];
    static ArrayList<Point> chick = new ArrayList<Point>();
    static ArrayList<Point> home = new ArrayList<Point>();
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[13];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Point(i, j));
                }
                if (map[i][j] == 2) {
                    chick.add(new Point(i, j));
                }
            }
        }

        chooseStore(0, 0);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void chooseStore(int idx, int cnt) {
        if (cnt == M) {    // M개 뽑았을 때
            ans = Math.min(ans, calculateDist());    // 거리 계산해서 최소값으로 갱신
            return;
        }

        if (idx == chick.size()) return;

        visited[idx] = true;
        chooseStore(idx + 1, cnt + 1);
        visited[idx] = false;
        chooseStore(idx + 1, cnt);
    }

    public static int calculateDist() {
        int sum_dist = 0;

        for (int i = 0; i < home.size(); i++) {
            int min_dist = Integer.MAX_VALUE;
            for (int k = 0; k < chick.size(); k++) {   // 모든 치킨집과의 거리 계산
                if (visited[k]) {
                    int dist = Math.abs(chick.get(k).x - home.get(i).x) + Math.abs(chick.get(k).y - home.get(i).y);
                    min_dist = Math.min(min_dist, dist);
                }
            }
            sum_dist += min_dist;
        }
        return sum_dist;
    }
}