import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static String origin;
    static boolean[] visited = new boolean[7];
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        origin = numbers;
        dfs("", 0);
        return set.size();
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void dfs(String str, int cnt) {
        if (cnt == origin.length()) {
            if (!str.equals("") && isPrime(Integer.parseInt(str))) {
                set.add(Integer.parseInt(str));
            }
        }

        for (int i = 0; i < origin.length(); i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(str + origin.charAt(i), cnt + 1);
            dfs(str, cnt + 1);
            visited[i] = false;
        }
    }
}