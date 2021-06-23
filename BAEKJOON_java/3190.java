import java.awt.*;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int[][] map = new int[101][101];
    public static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    public static int[] dc = {0, 1, 0, -1};
    public static Deque<Point> q = new LinkedList<Point>();
    public static int N, L, ans = 0;
    public static int[] time;
    public static char[] direction;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 2;  // 사과는 2
        }

        L = Integer.parseInt(br.readLine());
        time = new int[L];
        direction = new char[L];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            direction[i] = st.nextToken().charAt(0);
        }

        q.add(new Point(1, 1));
        map[1][1] = 1;

        playGame(1, 1, 1);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void playGame(int row, int col, int d) {
        int i = 0;
        while (true) {
            if (i < L && ans == time[i]) {
                if (direction[i] == 'D') { // 우회전
                    d = (d + 1) % 4;
                } else if (direction[i] == 'L') {  // 좌회전
                    d = (d + 3) % 4;
                }
                i++;
            }

            int next_r = row + dr[d];
            int next_c = col + dc[d];
            q.addFirst(new Point(next_r, next_c));   // 머리를 다음칸에 위치

            if (next_r <= 0 || next_c <= 0 || next_r > N || next_c > N) {   // 밖으로 나가는 경우
                ans++;
                break;
            }

            if (map[next_r][next_c] == 2) { // 사과가 있다면
                map[next_r][next_c] = 1;
            } else if (map[next_r][next_c] == 0) {    // 사과가 없다면
                map[next_r][next_c] = 1;
                map[q.peekLast().x][q.peekLast().y] = 0;    // 꼬리가 위치한 칸 비워주기
                q.pollLast();
            } else {  // 자기 자신과 부딪힌다면
                ans++;
                break;
            }

            row = next_r;
            col = next_c;
            ans++;
        }
    }
}
