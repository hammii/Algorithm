import java.io.*;

public class Main {
    static int N;
    static int cnt = 0;
    static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        col = new int[N];

        dfs(0);
        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int x) {
        if (x == N) { // 마지막 행일 때
            cnt++;
        } else {
            for (int i = 0; i < N; i++) {
                col[x] = i;     // 오른쪽으로 한칸씩 이동
                if (isValid(x)) {   // 퀸을 놓을 수 있으면
                    dfs(x + 1); // 다음 줄로 이동
                }
            }
        }
    }

    static boolean isValid(int level) {
        for (int i = 0; i < level; i++) {   // 위에 놓여진 퀸들과 비교
            if (col[i] == col[level] || Math.abs(col[level] - col[i]) == level - i) {   // 같은 열이거나 대각선으로 겹치는 경우
                return false;
            }
        }
        return true;
    }
}