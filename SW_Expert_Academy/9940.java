import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                arr[j] = num;
                set.add(num);
            }

            // 중복을 허락하지 않는 Set을 이용해 순열인지 아닌지 판단
            if (arr.length == set.size()) {
                System.out.println("#" + (i + 1) + " Yes");
            } else {
                System.out.println("#" + (i + 1) + " No");
            }
        }
	}
}