class Solution {
    public static String origin;
    public static boolean[] visited;
    public static String MAX = "0";
    
    public String solution(String number, int k) {
        origin = number;
        visited = new boolean[number.length()];

        int idx = 0;
        for (int i = 0; i <= k; i++) {
            if (origin.charAt(i) == 9) {
                MAX = "9";
                idx = i;
                break;
            }
            if (Integer.parseInt(origin.charAt(i) + "") > Integer.parseInt(MAX)) {
                MAX = String.valueOf(origin.charAt(i));
                idx = i;
            }
        }

        dfs(MAX, idx + 1, number.length() - k, 1);
        return MAX;
    }
    
    public static void dfs(String number, int idx, int len, int cnt) {
        if (len == cnt) {
            if (MAX.compareTo(number) < 0) MAX = number;
            return;
        }

        for (int i = idx; i < origin.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(number + origin.charAt(i), i + 1, len, cnt + 1);
            visited[i] = false;
        }
    }
}