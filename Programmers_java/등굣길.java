class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {  // 웅덩이 표시
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        // 왼쪽, 위쪽에 웅덩이 있으면 경우의 수 증가 X
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                if (row == 1 && col == 1) { // 시작점
                    dp[1][1] = 1;
                    continue;
                }

                if (dp[row][col] == -1) {   // 웅덩이 패스
                    continue;
                }

                int top = dp[row - 1][col];
                int left = dp[row][col - 1];
                if (dp[row - 1][col] == -1) top = 0;
                if (dp[row][col - 1] == -1) left = 0;

                dp[row][col] = (top + left) % 1000000007;
            }
        }

        return dp[n][m];
    }
}