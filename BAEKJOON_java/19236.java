import java.io.*;
import java.util.*;

class Fish {
	int x, y, d, alive;

	Fish(int x, int y, int d, int alive) {
		this.x = x;
		this.y = y;
		this.d = d;
		this.alive = alive;
	}
}

public class Main {
	static int N = 4;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map;
	static Fish[] fishes;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[N + 1][N + 1];
		fishes = new Fish[17];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken()) - 1;

				map[i][j] = num;
				fishes[num] = new Fish(i, j, dir, 1);
			}
		}

		int first_eat = map[1][1];
		map[1][1] = -1;
		fishes[first_eat].alive = 0;

		dfs(1, 1, fishes[first_eat].d, first_eat);

		System.out.println(answer);
	}

	public static void dfs(int x, int y, int d, int sum) {
		int[][] copy_map = new int[N + 1][N + 1];
		Fish[] copy_fish = new Fish[17];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				copy_map[i][j] = map[i][j];
			}
		}

		for (int i = 1; i <= 16; i++) {
			copy_fish[i] = new Fish(fishes[i].x, fishes[i].y, fishes[i].d, fishes[i].alive);
		}

		moveFish();

		for (int i = 1; i <= N; i++) {
			int nx = x + dx[d] * i;
			int ny = y + dy[d] * i;
			if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
				if (map[nx][ny] == 0) {
					continue;
				}
				map[x][y] = 0;

				int eatable = map[nx][ny];
				map[nx][ny] = -1;
				fishes[eatable].alive = 0;

				dfs(nx, ny, fishes[eatable].d, sum + eatable);

				map[nx][ny] = eatable;
				fishes[eatable].alive = 1;
				map[x][y] = -1;
			} else {
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = copy_map[i][j];
			}
		}

		for (int i = 1; i <= 16; i++) {
			fishes[i] = new Fish(copy_fish[i].x, copy_fish[i].y, copy_fish[i].d, copy_fish[i].alive);
		}

		answer = Math.max(answer, sum);
	}

	public static void moveFish() {
		for (int i = 1; i <= 16; i++) {
			if (fishes[i].alive == 0) {
				continue;
			}

			Fish cur = fishes[i];
			int x = cur.x;
			int y = cur.y;
			int d = cur.d;
			for (int k = 0; k < 8; k++) {
				int nd = (d + k) % 8;
				int nx = x + dx[nd];
				int ny = y + dy[nd];
				if (nx <= 0 || nx > N || ny <= 0 || ny > N || map[nx][ny] == -1) {
					continue;
				}

				int temp_num = map[nx][ny];
				map[nx][ny] = map[x][y];
				map[x][y] = temp_num;

				fishes[i] = new Fish(nx, ny, nd, 1);
				if (temp_num != 0) { // 빈칸이 아닌 경우
					fishes[temp_num] = new Fish(x, y, fishes[temp_num].d, 1);
				}
				break;
			}
		}
	}
}