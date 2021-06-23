import java.util.*;
import java.io.*;

// N: 맵의 크기
// M: 파이어볼 개수
// K: 명령수
// r,c,m,s,d: 행,열,질량,속력,방향

class Fireball {
	int r, c, m, s, d;

	public Fireball(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}

public class Main {
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Fireball>[][] map = new ArrayList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		int answer = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Fireball(r, c, m, s, d));
			answer += m;
		}

		while (K > 0) {
			ArrayList<Fireball> tempList = new ArrayList<>();

			// 이동할 파이어볼 tempList에 추가
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j].size() != 0) {
						for (int k = 0; k < map[i][j].size(); k++) {
							Fireball cur = map[i][j].get(k);

							int next_r = cur.r + dr[cur.d] * cur.s % N;
							int next_c = cur.c + dc[cur.d] * cur.s % N;

							if (next_r > N) {
								next_r = next_r % N;
							} else if (next_r < 1) {
								next_r = N - (Math.abs(next_r) % N);
							}
							if (next_c > N) {
								next_c = next_c % N;
							} else if (next_c < 1) {
								next_c = N - (Math.abs(next_c) % N);
							}

							tempList.add(new Fireball(next_r, next_c, cur.m, cur.s, cur.d));
							map[i][j].remove(k--);
						}
					}
				}
			}

			// 파이어볼 이동
			for (Fireball t : tempList) {
				map[t.r][t.c].add(t);
			}

			// 겹치는 곳 4개로 나누기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j].size() >= 2) {
						int sum_m = 0;
						int sum_s = 0;
						int even_flag = 0;
						int odd_flag = 0;

						for (Fireball cur : map[i][j]) {
							sum_m += cur.m;
							sum_s += cur.s;

							if (cur.d % 2 == 0) even_flag++;
							else odd_flag++;

						}

						answer -= sum_m;	// 현재 파이어볼 질량 빼주기 

						sum_m /= 5;
						sum_s /= map[i][j].size();

						map[i][j].clear();
						
						if (sum_m == 0)
							continue;

						answer += sum_m * 4;	// 4개의 파이어볼 질량 더해주기
						if (even_flag == 0 || odd_flag == 0) {
							for (int k = 0; k <= 6; k = k + 2) {
								map[i][j].add(new Fireball(i, j, sum_m, sum_s, k));
							}
						} else {
							for (int k = 1; k <= 7; k = k + 2) {
								map[i][j].add(new Fireball(i, j, sum_m, sum_s, k));
							}
						}
					}
				}
			}
			K--;
		}

		bw.write(answer + "\n");
		br.close();
		bw.close();
	}
}
