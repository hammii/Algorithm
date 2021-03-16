class Solution {
    static int n;
    static int target;
    static int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void dfs(int cnt, int prev) {
        if (cnt > 8) {
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, cnt);
            return;
        }

        int temp = n;
        for (int i = 0; i < 8 - cnt; i++) {
            int newCount = cnt + i + 1;

            dfs(newCount, prev + temp);
            dfs(newCount, prev - temp);
            dfs(newCount, prev / temp);
            dfs(newCount, prev * temp);

            temp = temp * 10 + n;
        }
    }
}