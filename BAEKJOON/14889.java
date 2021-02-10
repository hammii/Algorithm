import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static boolean[] team;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        team = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate(1, 0);
        bw.write(min + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void calculate(int idx, int cnt) {
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> link = new ArrayList<>();
        int start_score = 0;
        int link_score = 0;

        if (cnt == N / 2) {
            for (int i = 1; i <= N; i++) {
                if (team[i]) {
                    start.add(i);
                } else {
                    link.add(i);
                }
            }
            for (int i = 0; i < (N / 2); i++) {
                for (int j = 0; j < (N / 2); j++) {
                    start_score += map[start.get(i)][start.get(j)];
                    link_score += map[link.get(i)][link.get(j)];
                }
            }

            if (Math.abs(start_score - link_score) < min) {
                min = Math.abs(start_score - link_score);
            }
            return;
        }

        for (int i = idx; i <= N; i++) {    // 팀 나누기
            team[i] = true;
            calculate(i + 1, cnt + 1);
            team[i] = false;
        }
    }
}
