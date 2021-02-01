import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            dp[1] = 1;
            for (int j = 2; j <= n; j++) {
                if (j >= 4) {
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                } else if (j == 2) {
                    dp[j] = dp[j - 1] + 1;
                } else if (j == 3) {
                    dp[j] = dp[j - 1] + dp[j - 2] + 1;
                }
            }
            bw.write(dp[n] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}