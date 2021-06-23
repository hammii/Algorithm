import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long MIN = 1000000001;
    static long MAX = -1000000001;
    static int N;
    static int[] A = new int[101];
    static int[] op = new int[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        DFS(A[1], 2);

        bw.write(MAX + "\n" + MIN + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void DFS(int sum, int cnt) {
        if (cnt == N + 1) {
            MAX = Math.max(MAX, sum);
            MIN = Math.min(MIN, sum);
            return;
        }

        for (int i = 1; i <= 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 1) {
                    DFS(sum + A[cnt], cnt + 1);
                } else if (i == 2) {
                    DFS(sum - A[cnt], cnt + 1);
                } else if (i == 3) {
                    DFS(sum * A[cnt], cnt + 1);
                } else {
                    DFS(sum / A[cnt], cnt + 1);
                }
                op[i]++;
            }
        }
    }
}