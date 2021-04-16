import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static Deque<Integer>[][] map;
	static int[][] color_map, horse;

	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new ArrayDeque[N + 1][N + 1];
		color_map = new int[N + 1][N + 1];
		horse = new int[K + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayDeque<>();
				color_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[x][y].addLast(i); // 맵에 그려주기
			horse[i][0] = x;
			horse[i][1] = y;
			horse[i][2] = d;
		}

		int cnt = 1;

		loop: while (true) {
			for (int i = 0; i < K; i++) {
				int x = horse[i][0];
				int y = horse[i][1];

				int next_x = x + dx[horse[i][2]];
				int next_y = y + dy[horse[i][2]];

				if (next_x <= 0 || next_x > N || next_y <= 0 || next_y > N || color_map[next_x][next_y] == 2) {
					if (horse[i][2] == 1)
						horse[i][2] = 2;
					else if (horse[i][2] == 2)
						horse[i][2] = 1;
					else if (horse[i][2] == 3)
						horse[i][2] = 4;
					else if (horse[i][2] == 4)
						horse[i][2] = 3;
				}

				next_x = x + dx[horse[i][2]];
				next_y = y + dy[horse[i][2]];

				if (next_x <= 0 || next_x > N || next_y <= 0 || next_y > N || color_map[next_x][next_y] == 2) {
					continue;
				}

				int size = map[x][y].size();

				if (color_map[next_x][next_y] == 0) { // 흰색
					boolean flag = false;

					for (int k = 0; k < size; k++) {
						int cur = map[x][y].pollFirst();
						if (cur == i) { // 바꾸려는 말의 위치 찾음
							flag = true;
						}
						if (flag) {
							map[next_x][next_y].addLast(cur);
							horse[cur][0] = next_x;
							horse[cur][1] = next_y;
						} else {
							map[x][y].addLast(cur);
						}
					}
				} else if (color_map[next_x][next_y] == 1) { // 빨간색
					for (int k = 0; k < size; k++) {
						int cur = map[x][y].pollLast();
						map[next_x][next_y].addLast(cur);
						horse[cur][0] = next_x;
						horse[cur][1] = next_y;

						if (cur == i) {
							break;
						}
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
