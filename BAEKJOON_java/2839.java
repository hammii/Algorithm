import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (true) {
            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }
            N -= 3;
            cnt++;

            if (N < 0) {
                cnt = -1;
                break;
            }
        }
        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}