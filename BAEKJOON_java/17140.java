import java.io.*;
import java.util.*;

class Number implements Comparable<Number> {
	int n;
	int cnt;

	public Number(int n, int cnt) {
		super();
		this.n = n;
		this.cnt = cnt;
	}

	@Override
	public int compareTo(Number o) {
		if (this.cnt > o.cnt) {
			return 1;
		} else if (this.cnt == o.cnt) {
			return this.n - o.n;
		} else {
			return -1;
		}
	}
}

public class Main {
	static int[][] A;
	static ArrayList<Number> row_list;
	static ArrayList<Number> col_list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		A = new int[3][3];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		while (true) {
			if (answer > 100) {
				answer = -1;
				break;
			}

			if (r - 1 < A.length && c - 1 < A[0].length) {
				if (A[r - 1][c - 1] == k) {
					break;
				}
			}

			if (A.length >= A[0].length) {
				calculateR();
			} else {
				calculateC();
			}
			answer++;
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}

	public static void calculateR() {
		int[][] temp = new int[101][101];
		int max_len = 0;

		for (int i = 0; i < A.length; i++) { // 행 마다 반복
			int[] count = new int[101]; // 숫자 등장 횟수
			row_list = new ArrayList<>();

			for (int j = 0; j < A[i].length; j++) {
				int num = A[i][j];
				if (num != 0) {
					count[num]++;
				}
			}

			for (int j = 1; j < count.length; j++) {
				if (count[j] != 0) {
					row_list.add(new Number(j, count[j]));
				}
			}

			Collections.sort(row_list); // 정렬

			int k = 0;
			for (int j = 0; j < row_list.size(); j++) {
				temp[i][k] = row_list.get(j).n;
				temp[i][k + 1] = row_list.get(j).cnt;
				k += 2;

				max_len = Math.max(max_len, k);
			}
		}

		if (max_len > 100) {
			max_len = 100;
		}

		A = new int[A.length][max_len];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = temp[i][j];
			}
		}
	}

	public static void calculateC() {
		int[][] temp = new int[101][101];
		int max_len = 0;

		for (int col = 0; col < A[0].length; col++) { // 열 마다 반복
			int[] count = new int[101]; // 숫자 등장 횟수
			col_list = new ArrayList<>();

			for (int row = 0; row < A.length; row++) {
				int num = A[row][col];
				if (num != 0) {
					count[num]++;
				}
			}

			for (int j = 1; j < count.length; j++) {
				if (count[j] != 0) {
					col_list.add(new Number(j, count[j]));
				}
			}

			Collections.sort(col_list); // 정렬

			int k = 0;
			for (int row = 0; row < col_list.size(); row++) {
				temp[k][col] = col_list.get(row).n;
				temp[k + 1][col] = col_list.get(row).cnt;
				k += 2;

				max_len = Math.max(max_len, k);
			}
		}

		if (max_len > 100) {
			max_len = 100;
		}

		A = new int[max_len][A[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = temp[i][j];
			}
		}
	}

}
