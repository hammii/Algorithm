import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        bw.write(pow(A, B, C) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static long pow(long A, long B, long C) {
        if (B == 1) {
            return A % C;
        }

        if (B % 2 == 1) {   // 홀수승인 경우
            return ( pow(A, B - 1, C) * A ) % C;
        } else {    // 짝수승인 경우
            long half = pow(A, B / 2, C);
            return (half * half) % C;
        }
    }
}