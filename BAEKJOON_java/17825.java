import java.io.*;
import java.util.*;

public class Main {
	static int[][] map = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0 },
			{ 10, 13, 16, 19, 25 }, { 20, 22, 24, 25 }, { 30, 28, 27, 26, 25 }, { 25, 30, 35, 40, 0 } };
	static int[][] horse_positions = new int[4][2];
	static int[] scores = new int[4];
	static int[] moveArr = new int[10];
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			moveArr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		bw.write(answer + "\n");
		bw.close();
		br.close();
	}

	public static void dfs(int idx) {
		if (idx == 10) {
			int sum = 0;
			for (int i = 0; i < 4; i++) {
				sum += scores[i];
			}

			answer = Math.max(answer, sum);
			return;
		}

		int move = moveArr[idx];
		
		loop:
		for (int i = 0; i < 4; i++) {
			int cur_path = horse_positions[i][0]; // 말이 위치한 경로
			int cur_block = horse_positions[i][1]; // 경로위에서 몇번짼지

			if (cur_block == map[cur_path].length - 1) { // 도착지점이면 건너뛰기
				continue;
			}

			int next_path = cur_path;
			int next_block = cur_block + move;

			if (cur_path == 0) {
				if (next_block == 5) {
					next_path = 1;
					next_block = 0;
				} else if (next_block == 10) {
					next_path = 2;
					next_block = 0;
				} else if (next_block == 15) {
					next_path = 3;
					next_block = 0;
				} else if (next_block == 20) {
					next_path = 4;
					next_block = 3;
				}
			} else if (cur_path < 4) {
				if (next_block >= map[cur_path].length - 1) { // 중간 지점을 넘어간다면
					next_path = 4;
					next_block -= map[cur_path].length - 1;
				}
			}

			if (next_block >= map[next_path].length) { // 도착을 넘어가면 도착에서 멈춤
				next_block = map[next_path].length - 1;
			}

			if (map[next_path][next_block] != 0) { // 이동하려는 곳에 말이 이미 있다면
				for (int k = 0; k < 4; k++) {
					if (next_path == horse_positions[k][0] && next_block == horse_positions[k][1]) {
						continue loop;
					}
				}
			}

			horse_positions[i][0] = next_path;
			horse_positions[i][1] = next_block;
			scores[i] += map[next_path][next_block];

			dfs(idx + 1);

			horse_positions[i][0] = cur_path;
			horse_positions[i][1] = cur_block;
			scores[i] -= map[next_path][next_block];
		}
	}
}
