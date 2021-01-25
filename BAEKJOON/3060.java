import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long T = Long.parseLong(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());    // 사료 양
            long[] pig = new long[7];
            long pig_sum = 0;
            int cnt = 1;

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 6; j++) {
                pig[j] = Long.parseLong(st.nextToken());
                pig_sum += pig[j];
            }

            while (pig_sum <= N) {
                pig_sum *= 4;
                cnt++;
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}