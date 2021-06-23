import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());    // 시험장의 개수
        int[] A = new int[N + 1];
        int B, C;
        long cnt = 0;

        // 각 시험장에 있는 응시자의 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 총감독관, 부감독관이 감시할 수 있는 응시자의 수
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            A[i] -= B;
            cnt++;

            if (A[i] > 0) {
                cnt += A[i] / C;
                if (A[i] % C > 0) {
                    cnt++;
                }
            }
        }
        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}