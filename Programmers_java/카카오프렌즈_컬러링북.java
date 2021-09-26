import java.awt.*;
import java.util.*;

public class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        map = picture;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(bfs(i, j, m, n), maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int bfs(int x, int y, int m, int n) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

        return cnt;
    }
}
