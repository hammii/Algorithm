import java.util.Scanner;

class Solution
{
    private static final int MOD = 1234567891;

	public static void main(String args[]) throws Exception
	{
		  Scanner sc = new Scanner(System.in);
       	    int T = sc.nextInt();

        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            int R = sc.nextInt();

            // 팩토리얼 정의
            long fac[] = new long[N + 1];
            fac[0] = 1;
            for (int i = 1; i <= N; i++) {
                fac[i] = (fac[i - 1] * i) % MOD;
            }

            long a = (fac[R] * fac[N - R]) % MOD;
            long a_p = power(a, MOD - 2);
            long result = ((fac[N] * a_p) % MOD);

            System.out.println("#" + test + " " + result);
        }
	}
    
     static long power(long N, long x) {
        if (x == 1)     // 지수가 1일 때
            return N % MOD;
        else {
            if (x % 2 == 1) {   // 홀수인 경우
                long tmp = power(N, (x - 1) / 2);
                return tmp * tmp % MOD * N % MOD;
            } else {    // 짝수인 경우
                long tmp = power(N, x / 2);
                return tmp * tmp % MOD;
            }
        }
    }
}