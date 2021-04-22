import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		return this.y - o.y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

public class Main {
	static int N, M, D;
	static int[][] origin_map, map;
	static boolean[] visited;
	static ArrayList<Node> origin_enemy;
	static ArrayList<Node> enemy;
	static int answer;

	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		origin_map = new int[N + 2][M + 1];
		map = new int[N + 2][M + 1];
		visited = new boolean[M + 1];
		origin_enemy = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				origin_map[i][j] = Integer.parseInt(st.nextToken());

				if (origin_map[i][j] == 1) {
					origin_enemy.add(new Node(i, j));
				}
			}
		}

		setLocation(0);

		bw.write(answer + "\n");

		br.close();
		bw.close();
	}

	public static void setLocation(int cnt) {
		if (cnt == 3) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					map[i][j] = origin_map[i][j];
				}
			}
			enemy = new ArrayList<>();

			for (Node o : origin_enemy) {
				enemy.add(new Node(o.x, o.y));
			}

			startGame();
            
            return;
		}

		for (int i = 1; i <= M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				setLocation(cnt + 1);
				visited[i] = false;
			}
		}
	}

	public static void startGame() {
		int killCnt = 0;

		while (enemy.size() > 0) {
			ArrayList<Node> removeList = new ArrayList<>();
			for (int i = 1; i <= M; i++) {
				if (visited[i]) {
					Node point = getMin(N + 1, i);
					if (point != null) {
						removeList.add(point); // 궁수에게 가장 가까운 곳
					}
				}
			}

			for (Node r : removeList) {
				if (map[r.x][r.y] != 0) {
					map[r.x][r.y] = 0;
					enemy.remove(new Node(r.x, r.y));

					killCnt++;
				}
			}

			move(); // 적 이동
		}

		answer = Math.max(answer, killCnt);
	}

	public static Node getMin(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x, y));

		int cnt = 0;
		while (cnt < D) {
			PriorityQueue<Node> temp0 = new PriorityQueue<>();
			PriorityQueue<Node> temp1 = new PriorityQueue<>();

			while (!pq.isEmpty()) {
				Node cur = pq.poll();
				for (int i = 0; i < 3; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
						if (nx != x) {
							if (map[nx][ny] == 0) {
								temp0.add(new Node(nx, ny));
							} else {
								temp1.add(new Node(nx, ny));
							}
						}
					}
				}
			}

			if (temp1.size() > 0) {
				return temp1.poll();
			}

			pq.addAll(temp0);
			cnt++;
		}

		return null;
	}

	public static void move() {
		ArrayList<Node> temp = new ArrayList<>();
		for (int i = 0; i < enemy.size(); i++) {
			if (enemy.get(i).x == N) {
				temp.add(enemy.get(i));
			} else {
				enemy.get(i).x += 1;
			}

		}
		for (Node t : temp) {
			enemy.remove(t);
		}

		for (int i = N; i >= 1; i--) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = map[i - 1][j];
			}
		}
	}
}
