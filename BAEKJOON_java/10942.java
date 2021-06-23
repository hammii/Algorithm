import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] copy_arr = Arrays.copyOfRange(arr, start - 1, end);

            if (isPalindrome(copy_arr)) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isPalindrome(int[] arr) {
        int n = arr.length;

        if (n == 1) {   // 길이가 1인 경우
            return true;
        }
        for (int i = 0; i < (n / 2); i++) {
            if (!(arr[i] == arr[n - i - 1])) {
                return false;
            }
        }
        return true;
    }
}