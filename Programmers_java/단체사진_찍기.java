class Solution {
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[8];
        dfs("", visited, data);
        return answer;
    }

    public void dfs(String names, boolean[] visited, String[] data) {
        if (names.length() == 8) {
            if (check(names, data)) {
                answer++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(names + friends[i], visited, data);
                visited[i] = false;
            }
        }
    }

    public boolean check(String names, String[] data) {
        for (String d : data) {
            int idx_1 = names.indexOf(d.charAt(0));
            int idx_2 = names.indexOf(d.charAt(2));
            char op = d.charAt(3);
            int between = d.charAt(4) - '0';
            int abs = Math.abs(idx_1 - idx_2);

            if (op == '=') {
                if (!(abs == between + 1)) return false;
            } else if (op == '>') {
                if (!(abs > between + 1)) return false;
            } else if (op == '<') {
                if (!(abs < between + 1)) return false;
            }
        }
        return true;
    }
}