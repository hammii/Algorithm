import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int[][] color;
	static Deque<Integer>[][] map;
	static int[][] horse;

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		color = new int[N + 2][N + 2];
		map = new ArrayDeque[N + 2][N + 2];
		horse = new int[K + 1][3];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				color[0][j] = 2;
				color[N + 1][j] = 2;
				color[i][0] = 2;
				color[i][N + 1] = 2;
			}
		}

		for (int i = 1; i <= N; i++) { // 색깔 입력
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new ArrayDeque<>();
			}
		}

		for (int k = 1; k <= K; k++) { // 말 입력
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[x][y].addLast(k);
			horse[k][0] = x;
			horse[k][1] = y;
			horse[k][2] = d;
		}

		int cnt = 1;

		loop: while (true) {
			for (int k = 1; k <= K; k++) {
				int x = horse[k][0];
				int y = horse[k][1];

				if (map[x][y].peekFirst() != k)
					continue;

				int next_x = x + dx[horse[k][2]];
				int next_y = y + dy[horse[k][2]];

				if (color[next_x][next_y] == 2) { // 이동하려는 칸이 파란색이면 방향 반대로
					if (horse[k][2] == 1) {
						horse[k][2] = 2;
					} else if (horse[k][2] == 2) {
						horse[k][2] = 1;
					} else if (horse[k][2] == 3) {
						horse[k][2] = 4;
					} else if (horse[k][2] == 4) {
						horse[k][2] = 3;
					}

					next_x = x + dx[horse[k][2]];
					next_y = y + dy[horse[k][2]];
				}

				if (color[next_x][next_y] == 2) {
					continue;
				}

				if (color[next_x][next_y] == 0) { // 흰색
					while (!map[x][y].isEmpty()) {
						int cur = map[x][y].pollFirst();

						map[next_x][next_y].addLast(cur);
						horse[cur][0] = next_x;
						horse[cur][1] = next_y;
					}
				} else if (color[next_x][next_y] == 1) { // 빨간색
					while (!map[x][y].isEmpty()) {
						int cur = map[x][y].pollLast();

						map[next_x][next_y].addLast(cur);
						horse[cur][0] = next_x;
						horse[cur][1] = next_y;
					}
				}

				if (map[next_x][next_y].size() >= 4) {
					break loop;
				}
			}

			cnt++;

			if (cnt > 1000) {
				cnt = -1;
				break;
			}
		}

		bw.write(cnt + "\n");
		bw.close();
		br.close();
	}
}
