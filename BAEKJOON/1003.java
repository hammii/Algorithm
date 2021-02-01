import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][2];

            for (int j = 0; j <= N; j++) {
                if (j == 0) {
                    dp[j][0] = 1;
                    dp[j][1] = 0;
                } else if (j == 1) {
                    dp[j][0] = 0;
                    dp[j][1] = 1;
                } else {
                    dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
                    dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
                }
            }

            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}