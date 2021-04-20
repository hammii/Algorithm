import java.io.*;
import java.util.*;

class Shark {
	int x, y, d;

	public Shark(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int N, M, k;
	static int[][][] priority;
	static int[][] map;
	static int[][] num;
	static int[][] smell;
	static Map<Integer, Shark> sharkMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		priority = new int[M + 1][5][5];
		map = new int[N + 1][N + 1];
		num = new int[N + 1][N + 1];
		smell = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					sharkMap.put(map[i][j], new Shark(i, j, 0));
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			int d = Integer.parseInt(st.nextToken());
			sharkMap.get(i).d = d;
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= 4; k++) {
					priority[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		int cnt = 0;
		while (true) {
			cnt++;

			Map<Integer, Shark> temp = new HashMap<>();

			// 자기자리에 냄새 기록
			for (Integer key : sharkMap.keySet()) {
				Shark shark = sharkMap.get(key);
				smell[shark.x][shark.y] = k; 
				num[shark.x][shark.y] = key;
			}

			// 상어 다음 자리 찾기
			for (Integer key : sharkMap.keySet()) {
				Shark shark = sharkMap.get(key);

				boolean flag = false;
				for (int i = 1; i <= 4; i++) {
					int dir = priority[key][shark.d][i];
					int nx = shark.x + dx[dir];
					int ny = shark.y + dy[dir];

					if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
						if (num[nx][ny] == 0) {
							temp.put(key, new Shark(nx, ny, dir));
							flag = true;
							break;
						}
					}
				}

				if (!flag) { // 빈칸이 없을 때
					for (int i = 1; i <= 4; i++) {
						int dir = priority[key][shark.d][i];
						int nx = shark.x + dx[dir];
						int ny = shark.y + dy[dir];

						if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
							if (num[nx][ny] == key) {
								temp.put(key, new Shark(nx, ny, dir));
								break;
							}
						}
					}
				}
			}
			
			// 상어 자리 옮기기
			for (Integer key : temp.keySet()) {
				Shark cur = temp.get(key);

				map[sharkMap.get(key).x][sharkMap.get(key).y] = 0;

				if (map[cur.x][cur.y] != 0) { // 이미 상어가 있는 경우
					if (key > map[cur.x][cur.y]) {
						sharkMap.remove(key);
						continue;
					} else {
						sharkMap.remove(map[cur.x][cur.y]);
					}
				}

				map[cur.x][cur.y] = key;

				sharkMap.get(key).x = cur.x;
				sharkMap.get(key).y = cur.y;
				sharkMap.get(key).d = cur.d;
			}

			// smell 확인
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (smell[i][j] > 1) {
						smell[i][j]--;
					} else if (smell[i][j] == 1) {
						smell[i][j] = 0;
						num[i][j] = 0;
					}
				}
			}

			if (sharkMap.size() == 1) {
				break;
			}

			if (cnt >= 1000) {
				cnt = -1;
				break;
			}
		}

		bw.write(cnt + "\n");
		bw.close();
		br.close();

	}
}
