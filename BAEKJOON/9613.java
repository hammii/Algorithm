import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long[] num = new long[n];
            for (int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(sumGCD(num) + "\n");
        }

        br.close();
        bw.close();
    }

    public static long sumGCD(long[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += GCD(arr[i], arr[j]);
            }
        }

        return sum;
    }

    public static long GCD(long a, long b) {
        if (b == 0) return a;
        else return GCD(b, a % b);
    }
}
