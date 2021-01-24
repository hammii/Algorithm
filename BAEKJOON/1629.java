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

        long half = pow(A, B / 2, C);
        if (B % 2 == 0) {
            return (half * half) % C;
        } else {
            return (((half * half) % C) * A) % C;
        }
    }
}