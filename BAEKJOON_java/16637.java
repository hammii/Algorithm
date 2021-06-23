import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Integer> num; // 원래 숫자
	static ArrayList<Character> op; // 연산
	static int answer = -(int) Math.pow(2, 31);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		num = new ArrayList<>();
		op = new ArrayList<>();

		char[] cArr = br.readLine().toCharArray();
		for (char c : cArr) {
			if (c >= '0' && c <= '9') {
				num.add(Character.getNumericValue(c));
			} else {
				op.add(c);
			}
		}

		dfs(0, num.get(0));

		bw.write(answer + "\n");

		br.close();
		bw.close();
	}

	public static void dfs(int idx, int sum) {
		if (idx == op.size()) {
			answer = Math.max(answer, sum);
		} else {
			dfs(idx + 1, calculate(sum, num.get(idx + 1), op.get(idx))); // 괄호 안 치고 넘기기

			if (idx + 2 <= op.size()) { // 괄호 치고 넘기기
				dfs(idx + 2,
						calculate(sum, calculate(num.get(idx + 1), num.get(idx + 2), op.get(idx + 1)), op.get(idx)));
			}
		}
	}

	public static int calculate(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

}
