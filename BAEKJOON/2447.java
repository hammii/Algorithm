import java.io.*;

public class Main {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        divide(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static void divide(int row, int col, int len) throws IOException {
        if (len == 1) {
            map[row][col] = true;
        } else {
            int newLen = len / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        map[i][j] = false;
                    } else {
                        divide(row + newLen * i, col + newLen * j, newLen);
                    }
                }
            }
        }
    }
}