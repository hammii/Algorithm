import java.io.*;
import java.util.*;

public class Solution {
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer;
	static boolean used;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int test = 0;
		while (test++ < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			visited = new boolean[N + 1][N + 1];

			int max = 0;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						dfs(i, j, 1);
						visited[i][j] = false;
					}
				}
			}

			System.out.println("#" + test + " " + answer);
			answer = 0;
		}

	}

	public static void dfs(int x, int y, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny]) {
				if (map[nx][ny] < map[x][y]) {
					visited[nx][ny] = true;
					dfs(nx, ny, cnt + 1);
					visited[nx][ny] = false;
				} else if (!used && map[nx][ny] - K < map[x][y]) {
					int temp = map[nx][ny];
					used = true;
					map[nx][ny] = map[x][y] - 1;
					visited[nx][ny] = true;
					dfs(nx, ny, cnt + 1);
					visited[nx][ny] = false;
					map[nx][ny] = temp;
					used = false;
				}
			}
		}

		answer = Math.max(answer, cnt);
	}
}