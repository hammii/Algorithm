import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(arr, visited, 0, 0, 6);
            System.out.println();
        }
    }

    public static void combination(int[] arr, boolean[] visited, int idx, int n, int r) {
        if (n == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(arr, visited, i, n + 1, r);
            visited[i] = false;
        }
    }
}
