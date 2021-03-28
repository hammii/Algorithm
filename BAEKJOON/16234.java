import java.io.*;
import java.util.*;

class Point {
	int row;
	int col;
	int value;

	public Point(int row, int col, int value) {
		this.row = row;
		this.col = col;
		this.value = value;
	}
}

public class Main {
	public static int[] dy = { -1, 0, 1, 0 }; // 상,좌,하,우 순서
	public static int[] dx = { 0, -1, 0, 1 };
	public static int N, L, R;
	public static boolean[][] visited;
	public static int[][] map;
	public static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = true;
		while (flag) {
			flag = false;
			visited = new boolean[N][N];
			answer++;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bfs(i, j)) {
						flag = true;
					}
				}
			}
		}

		bw.write(answer - 1 + "\n");

		bw.flush();
		bw.close();
	}

	public static boolean bfs(int i, int j) {
		boolean flag = false;
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j, map[i][j]));
		visited[i][j] = true;

		Queue<Point> temp = new LinkedList<>();
		temp.add(new Point(i, j, map[i][j]));

		int sum = map[i][j];

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int k = 0; k < 4; k++) {
				int next_r = cur.row + dy[k];
				int next_c = cur.col + dx[k];
				if (next_r >= 0 && next_r < N && next_c >= 0 && next_c < N) {
					if (!visited[next_r][next_c]) {
						int diff = Math.abs(map[next_r][next_c] - cur.value);
						if (diff >= L && diff <= R) {
							flag = true;
							queue.add(new Point(next_r, next_c, map[next_r][next_c]));
							temp.add(new Point(next_r, next_c, map[next_r][next_c]));
							visited[next_r][next_c] = true;
							sum += map[next_r][next_c];
						}
					}
				}
			}
		}

		if (temp.size() > 1) {
			for (Point p : temp) {
				map[p.row][p.col] = sum / temp.size();
			}
		}

		return flag;
	}
}
