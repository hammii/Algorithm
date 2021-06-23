import java.util.*;

class Solution {
    static List<String> answer = new ArrayList<>();
    static String route = "";
    static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        dfs(tickets, "ICN", 0);

        Collections.sort(answer);
        return answer.get(0).split(",");
    }
    
    public static void dfs(String[][] tickets, String end, int cnt) {
        route += end + ",";

        if (cnt == tickets.length) {
            answer.add(route);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String next_s = tickets[i][0];
            String next_e = tickets[i][1];
            if (next_s.equals(end) && !visited[i]) {
                visited[i] = true;
                dfs(tickets, next_e, cnt + 1);
                visited[i] = false;
                route = route.substring(0, route.length() - 4);
            }
        }
    }
}