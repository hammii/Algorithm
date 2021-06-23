import java.io.*;
import java.util.*;

public class Main {
	static int N, M, x, d, k;
	static int[][] circle;
	static boolean[][] erase;
	static long answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken()); // 회전 수
		circle = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				circle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()); // x의 배수
			d = Integer.parseInt(st.nextToken()); // d 방향으로
			k = Integer.parseInt(st.nextToken()); // k칸 회전

			erase = new boolean[N + 1][M + 1];

			for (int i = x; i <= N; i = i + x) {
				rotation(i, d);
			}
			checkAdj();
			erase();
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (circle[i][j] > 0) {
					answer += circle[i][j];
				}
			}
		}

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}

	public static void rotation(int row, int d) {
		if (d == 0) { // 시계방향
			for (int i = 1; i <= k; i++) {
				int temp = circle[row][M];
				for (int j = M; j > 1; j--) {
					circle[row][j] = circle[row][j - 1];
				}
				circle[row][1] = temp;
			}
		} else if (d == 1) { // 반시계방향
			for (int i = 1; i <= k; i++) {
				int temp = circle[row][1];
				for (int j = 1; j < M; j++) {
					circle[row][j] = circle[row][j + 1];
				}
				circle[row][M] = temp;
			}
		}
	}

	public static void checkAdj() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (circle[i][j] == 0) {
					continue;
				}

				// 원판 내에서 확인
				if (circle[i][j] == circle[i][(j + (M - 1)) % M]) {
					erase[i][j] = true;
					erase[i][(j + (M - 1)) % M] = true;
				}
				if (circle[i][j] == circle[i][(j + 1) % M]) {
					erase[i][j] = true;
					erase[i][(j + 1) % M] = true;
				}

				// 다른 이웃한 원판 확인
				if (i == 1) { // 첫번째 원판
					if (circle[i][j] == circle[i + 1][j]) {
						erase[i][j] = true;
						erase[i + 1][j] = true;
					}
				} else if (i == N) { // 마지막 원판
					if (circle[i][j] == circle[i - 1][j]) {
						erase[i][j] = true;
						erase[i - 1][j] = true;
					}
				} else {
					if (circle[i][j] == circle[i - 1][j]) {
						erase[i][j] = true;
						erase[i - 1][j] = true;
					}
					if (circle[i][j] == circle[i + 1][j]) {
						erase[i][j] = true;
						erase[i + 1][j] = true;
					}
				}
			}
		}
	}

	public static void erase() {
		boolean flag = false;
		int sum = 0;
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (circle[i][j] == 0) {
					continue;
				}

				if (erase[i][j]) {
					circle[i][j] = 0;
					flag = true;
				} else {
					sum += circle[i][j];
					cnt++;
				}
			}
		}

		// 인접하면서 수가 같은 것이 없는 경우
		if (!flag) {
			float avg = (float) sum / cnt;

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (circle[i][j] == 0) {
						continue;
					}

					if (circle[i][j] > avg) {
						circle[i][j]--;
					} else if (circle[i][j] < avg) {
						circle[i][j]++;
					}
				}
			}
		}
	}
}
