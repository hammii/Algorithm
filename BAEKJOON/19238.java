import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M, fuel;
	static int[][] start;
	static int[][] end;
	static int[][] map;
	static int[][] start_end_map;
	static boolean[][] visited;
	static int joon_x, joon_y;
	static int dfs_min = Integer.MAX_VALUE;
	static int answer = 0;
	static boolean[] finished;

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		start = new int[M + 1][M + 1];
		end = new int[M + 1][M + 1];
		map = new int[N + 1][N + 1];
		start_end_map = new int[N + 1][N + 1];
		finished = new boolean[M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		joon_x = Integer.parseInt(st.nextToken());
		joon_y = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start_x = Integer.parseInt(st.nextToken());
			int start_y = Integer.parseInt(st.nextToken());
			int end_x = Integer.parseInt(st.nextToken());
			int end_y = Integer.parseInt(st.nextToken());

			start[i][0] = start_x;
			start[i][1] = start_y;
			end[i][0] = end_x;
			end[i][1] = end_y;
			start_end_map[start_x][start_y] = i;
			start_end_map[end_x][end_y] = -i;
		}

		while (true) {
			visited = new boolean[N + 1][N + 1];

			Point pick = bfs(); // 출발점 선정
			if (pick == null) {
				answer = -1;
				break;
			}

			joon_x = pick.x;
			joon_y = pick.y;

			int num = start_end_map[pick.x][pick.y];

			int end_x = end[num][0];
			int end_y = end[num][1];

			if (fuel < 0) {
				answer = -1;
				break;
			}

			visited = new boolean[N + 1][N + 1];

			dfs_min = Integer.MAX_VALUE;
			dfs(pick.x, pick.y, end_x, end_y, 0);

			joon_x = end_x;
			joon_y = end_y;

			fuel -= dfs_min;

			if (fuel < 0) {
				answer = -1;
				break;
			}

			fuel += dfs_min * 2;

			start_end_map[pick.x][pick.y] = 0;
			start_end_map[end_x][end_y] = 0;

			finished[num] = true; // 완주 !!!

			if (check()) {
				break;
			}
		}

		bw.write((answer == -1 ? -1 : fuel) + "\n");
		bw.close();
		br.close();
	}

	public static boolean check() {
		for (int i = 1; i <= M; i++) {
			if (!finished[i]) {
				return false;
			}
		}
		return true;
	}

	public static Point bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(joon_x, joon_y));
		visited[joon_x][joon_y] = true;

		int cnt = 0;

		List<Point> sortList = new ArrayList<>();

		while (!q.isEmpty()) {
			List<Point> temp = new ArrayList<>();
			boolean flag = false;

			while (!q.isEmpty()) {
				Point cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int next_x = cur.x + dx[i];
					int next_y = cur.y + dy[i];

					if (next_x > 0 && next_x <= N && next_y > 0 && next_y <= N) {
						if (map[next_x][next_y] != 1 && !visited[next_x][next_y]) {
							temp.add(new Point(next_x, next_y));
							visited[next_x][next_y] = true;
						}
					}
				}
			}

			for (Point p : temp) {
				if (start_end_map[p.x][p.y] > 0) {
					sortList.add(new Point(p.x, p.y));
					flag = true;
				}
				q.add(p);
			}
			cnt++;

			if (flag) {
				break;
			}

		}

		if (sortList.size() > 1) { // 가장 작은 승객 고르기
			Collections.sort(sortList, new Comparator<Point>() {
				@Override
				public int compare(Point o1, Point o2) {
					if (o1.x > o2.x) {
						return 1;
					} else if (o1.x == o2.x) {
						if (o1.y > o2.y) {
							return 1;
						}
					} else {
						return -1;
					}
					return 0;
				}
			});
		} else if (sortList.size() == 0) {
			return null;
		}

		fuel -= cnt; // 태우러 가는 길 연료 사용

		return sortList.get(0);
	}

	public static void dfs(int x, int y, int end_x, int end_y, int cnt) {
		if (x == end_x && y == end_y) {
			dfs_min = Math.min(dfs_min, cnt);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int next_x = x + dx[i];
			int next_y = y + dy[i];

			if (next_x > 0 && next_x <= N && next_y > 0 && next_y <= N) {
				if (map[next_x][next_y] != 1 && !visited[next_x][next_y]) {
					visited[next_x][next_y] = true;
					dfs(next_x, next_y, end_x, end_y, cnt + 1);
					visited[next_x][next_y] = false;
				}
			}
		}
	}
}
