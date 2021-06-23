import java.io.*;
import java.util.*;

public class Main {
    static int[][] num;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new int[N][N];
        cnt = new int[3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        bw.write(cnt[0] + "\n");
        bw.write(cnt[1] + "\n");
        bw.write(cnt[2] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean check(int row, int col, int len) {
        int tmp = num[row][col];
        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (tmp != num[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void divide(int row, int col, int len) {
        if (check(row, col, len)) { // 같은 수로 되어 있을 때
            cnt[num[row][col] + 1]++;
        } else {    // 같은 수로 되어있지 않을 때
            int newLen = len / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divide(row + newLen * i, col + newLen * j, newLen);
                }
            }
        }
    }
}