import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long[] A = new long[N];

        // 배열에 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 투 포인터
        int end = 0, cnt = 0, sum = 0;
        for (int start = 0; start < N; start++) {
            while (sum < M && end < N) {    // 합을 맞추는 end 찾기
                sum += A[end];
                end++;
            }
            if (sum == M) {     // 합이 맞았을 경우
                cnt++;
            }
            sum -= A[start];    // start 가 1 증가할 예정이므로 현재 start 가 가리키는 값을 제외
        }
        bw.write(cnt + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}