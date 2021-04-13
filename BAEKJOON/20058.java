import java.util.*;
import java.awt.Point;
import java.io.*;

public class Main {
	static int[][] A, temp;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; // 위, 아래, 왼쪽, 오른쪽
	static int[] dc = { 0, 0, -1, 1 };
	static int pow;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		pow = (int) Math.pow(2, N);
		A = new int[pow + 1][pow + 1];
		visited = new boolean[pow + 1][pow + 1];

		for (int i = 1; i <= pow; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= pow; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			divideMap((int) Math.pow(2, L));
			checkIce();
		}

		int max = 0;
		for (int i = 1; i <= pow; i++) {
			for (int j = 1; j <= pow; j++) {
				if (!visited[i][j] && A[i][j] != 0) {
					max = Math.max(max, countBig(i, j));
				}
			}
		}

		bw.write(calculateSum() + "\n");
		bw.write(max + "\n");

		br.close();
		bw.close();
	}

	static void divideMap(int L) {
		for (int i = 1; i < A.length; i = i + L) {
			for (int j = 1; j < A.length; j = j + L) {
				rotateMap(i, j, L);
			}
		}

	}

	static void rotateMap(int r, int c, int size) {
		int sqaure = size / 2;

		for (int num = 0; num < sqaure; num++) {
			int start_r = r + num;
			int start_c = c + num;
			int end_r = r + size - num - 1;
			int end_c = c + size - num - 1;

			Queue<Integer> temp = new LinkedList<>();
			int c_idx = start_c;
			int r_idx = end_r;

			for (int i = start_r; i <= end_r; i++) { // 첫째줄 복사
				temp.add(A[i][start_c]);
			}
			for (int i = start_r; i < end_r; i++) { // 첫째줄 채우기
				A[i][start_c] = A[end_r][c_idx++];
			}
			for (int i = start_c; i < end_c; i++) { // 둘째줄 채우기
				A[end_r][i] = A[r_idx--][end_c];
			}
			for (int i = end_r; i > start_r; i--) { // 셋째줄 채우기
				A[i][end_c] = A[start_r][c_idx--];
			}
			for (int i = end_c; i > start_c; i--) { // 넷째줄 채우기
				A[start_r][i] = temp.poll();
			}
		}

	}

	static void checkIce() {
		ArrayList<Point> temp = new ArrayList<>();

		for (int i = 1; i <= pow; i++) {
			for (int j = 1; j <= pow; j++) {
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int next_r = i + dr[k];
					int next_c = j + dc[k];
					if (next_r <= 0 || next_r > pow || next_c <= 0 || next_c > pow) {
						cnt++;
					} else {
						if (A[next_r][next_c] == 0) {
							cnt++;
						}
					}
				}

				if (cnt >= 2) {
					temp.add(new Point(i, j));
				}
			}
		}

		for (Point cur : temp) {
			if (A[cur.x][cur.y] == 0) continue;
			A[cur.x][cur.y]--;
		}
	}

	static int countBig(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		visited[r][c] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int next_r = cur.x + dr[i];
				int next_c = cur.y + dc[i];

				if (next_r > 0 && next_r <= pow && next_c > 0 && next_c <= pow) {
					if (!visited[next_r][next_c] && A[next_r][next_c] != 0) {
						q.add(new Point(next_r, next_c));
						visited[next_r][next_c] = true;
					}
				}
			}
		}

		return cnt;
	}

	static int calculateSum() {
		int sum = 0;
		for (int i = 1; i <= pow; i++) {
			for (int j = 1; j <= pow; j++) {
				sum += A[i][j];
			}
		}
		return sum;
	}
}