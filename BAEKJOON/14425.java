import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(sc.next(), 1);
        }
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if (map.get(str) != null) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}