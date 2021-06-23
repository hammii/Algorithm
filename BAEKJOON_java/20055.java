import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int K;
    public static int[] A;
    public static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(simulation(0) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int simulation(int cnt) {
        while (isOK()) {
            int temp = A[A.length - 1]; // 1. 벨트 한 칸 회전
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = temp;

            for (int i = robot.length - 1; i > 0; i--) {    // 로봇도 벨트와 같이 회전
                robot[i] = robot[i - 1];
            }
            robot[0] = false;

            robot[N - 1] = false;
            for (int i = N - 1; i > 0; i--) {   // 2. 로봇 이동가능하면 이동
                if (robot[i - 1] && !robot[i] && A[i] >= 1) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    A[i]--;
                }
            }

            if (A[0] > 0) {     // 3. 올라가는 위치에 로봇 올리기
                robot[0] = true;
                A[0]--;
            }

            cnt++;
        }

        return cnt;
    }

    public static boolean isOK() {
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }
}