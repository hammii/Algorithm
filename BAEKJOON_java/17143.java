import java.io.*;
import java.util.*;

class Shark implements Comparable<Shark> {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		super();
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	@Override
	public int compareTo(Shark o) {
		return o.z - this.z;
	}

}

public class Main {
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };
	static int R;
	static int C;
	static int[][] map;
	static PriorityQueue<Shark> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[R + 1][C + 1]; // 상어의 개수
		pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			pq.add(new Shark(r, c, s, d, z));
			map[r][c]++;
		}

		for (int man = 1; man <= C; man++) { // 낚시왕 이동

			// 제일 가까운 상어 잡기
			for (int row = 1; row <= R; row++) {
				if (map[row][man] != 0) {
					map[row][man] = 0;

					Shark delete = null;
					for (Shark s : pq) {
						if (s.r == row && s.c == man) {
							delete = s;
							break;
						}
					}
					if (delete != null) {	// 잡아먹을 상어가 있을 때만
						answer += delete.z;
						pq.remove(delete);
					}

					break;
				}
			}

			// 상어 이동
			moveShark();

			// map에 두마리 있는지 확인
			for (int i = 1; i <= R; i++) {
				for (int j = 1; j <= C; j++) {
					if (map[i][j] >= 2) {
						boolean flag = false;
						LinkedList<Shark> delete = new LinkedList<>();

						for (Shark s : pq) {
							if (s.r == i && s.c == j) {
								if (!flag) {
									flag = true;
								} else {
									delete.add(s);
									map[i][j]--;
								}
							}
						}

						if (delete.size() > 0) {
							pq.removeAll(delete);
						}
					}
				}
			}
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();

	}

	public static void moveShark() {
		for (Shark shark : pq) {
			map[shark.r][shark.c]--; // 맵에서 지우기

			int cnt = 0;
			while (cnt < shark.s) { // 속력만큼 이동
				int next_r = shark.r + dr[shark.d];
				int next_c = shark.c + dc[shark.d];

				if (next_r <= 0 || next_r > R) { // 1이면 2, 2이면 1 방향 바꾸기
					if (shark.d == 1) {
						shark.d = 2;
					} else if (shark.d == 2) {
						shark.d = 1;
					}
					continue;
				}
				if (next_c <= 0 || next_c > C) { // 3이면 4, 4이면 3 방향바꾸기
					if (shark.d == 3) {
						shark.d = 4;
					} else if (shark.d == 4) {
						shark.d = 3;
					}
					continue;
				}

				shark.r = next_r;
				shark.c = next_c;

				cnt++;
			}

			map[shark.r][shark.c]++; // 맵에 다시 그려주기

		}

	}
}
