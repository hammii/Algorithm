import java.util.*;

class Node {
	int x, y, d;

	public Node(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int[] dx = { -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른쪽
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][][] dp;
	static int N;
	static int answer = Integer.MAX_VALUE;

	public static int solution(int[][] board) {
		map = board;
		N = board.length;
		dp = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		BFS();

		for (int i = 0; i < 4; i++) {
			answer = Math.min(answer, dp[N - 1][N - 1][i]);
		}
		return answer;
	}

	public static void BFS() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 1));
		q.add(new Node(0, 0, 3));
		dp[0][0][1] = 0; // 아래방향
		dp[0][0][3] = 0; // 오른쪽방향

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int cost = dp[cur.x][cur.y][cur.d];

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!(nx >= 0 && nx < N && ny >= 0 && ny < N) || map[nx][ny] == 1)	continue;

				if (cur.d != i) {
					if (dp[nx][ny][i] > cost + 600) {
						q.add(new Node(nx, ny, i));
						dp[nx][ny][i] = cost + 600;
					}
				} else {
					if (dp[nx][ny][i] > cost + 100) {
						q.add(new Node(nx, ny, i));
						dp[nx][ny][i] = cost + 100;
					}
				}
			}
		}
	}

}