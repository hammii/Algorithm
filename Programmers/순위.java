class Solution {
    public int solution(int n, int[][] results) {
        final int INF = 987654321;
        int[][] players = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {  // 초기 세팅
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    players[i][j] = 0;
                } else {
                    players[i][j] = INF;
                }
            }
        }

        for (int[] result : results) {  // 경기 결과 대입
            int winner = result[0];
            int loser = result[1];
            players[winner][loser] = 1;
        }

        for (int k = 1; k <= n; k++) {  // 플로이드 워셜
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    players[i][j] = Math.min(players[i][j], players[i][k] + players[k][j]);
                }
            }
        }

        boolean[] flag = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (players[i][j] == INF) {   // 두 선수 사이에 승패 결과가 없으면
                    if (players[j][i] == INF) {
                        flag[i] = true;
                        break;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {  // 순위를 알 수 있는 선수
            if (!flag[i]) {
                answer++;
            }
        }

        return answer;
    }
}