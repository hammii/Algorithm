import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] border;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(line[j - 1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; i + j <= N - 1; j++) {
				selectXY(i, j);
			}
		}

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}

	public static void selectXY(int d1, int d2) {
		for (int i = 1; i <= N - 2; i++) {
			for (int j = 2; j <= N - 1; j++) {
				if (checkLine(i, j, d1, d2)) {
					divide(i, j, d1, d2);
				}
			}
		}
	}

	public static boolean checkLine(int x, int y, int d1, int d2) {
		if (y - d1 <= 0 || y + d2 > N || x + d1 + d2 > N) {
			return false;
		}
		return true;
	}

	public static void divide(int x, int y, int d1, int d2) {
		int[] sum = new int[6];
		border = new boolean[N + 1][N + 1];

		// 5 구역 나누기
		for (int i = 0; i <= d1; i++) {
			if (!border[x + i][y - i]) {
				sum[5] += map[x + i][y - i];
				border[x + i][y - i] = true;
			}
		}
		for (int i = 0; i <= d2; i++) {
			if (!border[x + i][y + i]) {
				sum[5] += map[x + i][y + i];
				border[x + i][y + i] = true;
			}
		}
		for (int i = 0; i <= d2; i++) {
			if (!border[x + d1 + i][y - d1 + i]) {
				sum[5] += map[x + d1 + i][y - d1 + i];
				border[x + d1 + i][y - d1 + i] = true;
			}
		}
		for (int i = 0; i <= d1; i++) {
			if (!border[x + d2 + i][y + d2 - i]) {
				sum[5] += map[x + d2 + i][y + d2 - i];
				border[x + d2 + i][y + d2 - i] = true;
			}
		}

		for (int r = 1; r <= N; r++) {
			boolean flag = false;
			for (int c = 1; c <= N; c++) {
				if (border[r][c]) { // 경계선을 마주쳤을 때
					if (r == x && c == y)
						continue;
					if (r == x + d1 + d2 && c == y - d1 + d2)
						continue;

					flag = !flag;
					continue;
				}

				if (flag) {
					sum[5] += map[r][c];
					continue;
				}

				if (1 <= r && r < x + d1 && 1 <= c && c <= y) {
					sum[1] += map[r][c];
				} else if (1 <= r && r <= x + d2 && y < c && c <= N) {
					sum[2] += map[r][c];
				} else if (x + d1 <= r && r <= N && 1 <= c && c < y - d1 + d2) {
					sum[3] += map[r][c];
				} else if (x + d2 < r && r <= N && y - d1 + d2 <= c && c <= N) {
					sum[4] += map[r][c];
				}
			}
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < sum.length; i++) {
			max = Math.max(max, sum[i]);
			min = Math.min(min, sum[i]);
		}

		answer = Math.min(answer, Math.abs(max - min));
	}
}
