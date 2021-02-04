import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                N -= 5;
                cnt++;
            } else if (N % 3 == 0) {
                N -= 3;
                cnt++;
            } else if (N > 5) {
                N -= 5;
                cnt++;
            } else {
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