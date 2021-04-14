import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, L, R;
	static int[][] A;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		A = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			visited = new boolean[N + 1][N + 1];

			boolean flag = false;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j]) {
						if(bfs(i,j)) {
							flag = true;
						}
					}
				}
			}

			if (flag == false) {
				break;
			}
			answer++;
		}

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}

	public static boolean bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> temp = new LinkedList<>();
		q.offer(new Point(r, c));
		visited[r][c] = true;

		boolean flag = false;
		int sum = 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			temp.offer(cur);
			sum += A[cur.x][cur.y];

			for (int i = 0; i < 4; i++) {
				int next_x = cur.x + dx[i];
				int next_y = cur.y + dy[i];

				if (next_x > 0 && next_x <= N && next_y > 0 && next_y <= N) {
					if (!visited[next_x][next_y]) {
						int diff = Math.abs(A[cur.x][cur.y] - A[next_x][next_y]);

						if (L <= diff && diff <= R) {
							q.offer(new Point(next_x, next_y));
							visited[next_x][next_y] = true;

							flag = true;
						}
					}
				}

			}
		}

		for (Point p : temp) {	// 인구수 갱신
			A[p.x][p.y] = sum / temp.size();
		}
		
		return flag;
	}
}
