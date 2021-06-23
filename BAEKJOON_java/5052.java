import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] num = new String[n];
            boolean result = true;

            for (int j = 0; j < n; j++) {
                num[j] = br.readLine();
            }
            Arrays.sort(num);

            for (int j = 1; j < n; j++) {
                if (num[j].startsWith(num[j - 1])) {
                    result = false;
                    break;
                }
            }

            if (result) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}